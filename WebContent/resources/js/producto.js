//<C[DATA[
$(document).ready(function() {
	
	$('#btnRegistrar').data('kendoButton').enable(true);
	$('#btnModificar').data('kendoButton').enable(true);
	$('#btnEliminar').data('kendoButton').enable(true);
	
			//var opcionMenuResponse = obtenerOpcionMenu();
			//$('#cbxOpcionMenu').data('kendoComboBox').dataSource.data(opcionMenuResponse.data);
			/*Cambiamos el texto del footer de la grilla*/
			var grid = $('#gridProducto').data('kendoGrid');
			grid.dataSource.bind("change", function (e) {			
				var texto;
				if($('#gridProducto').data('kendoGrid').dataSource.data().length != 0){
					texto = $('#gridProducto span.k-pager-info.k-label').text();			
					texto = texto.replace('of','de').replace('items','registros');				
				}else{
					texto = 'No existen registros a mostrar';				
				}
				$('#gridProducto span.k-pager-info.k-label').text(texto);
			});
			/**/
			
			$('#gridProducto').css('width', '100%');
			$('#gridProducto').data('kendoGrid').table.on("click", ".radio",seleccionarFila);
			$('#txtCodigo').attr('maxlength','20');
			
			var cliente = cargarComboConsulta('obtenerClientes');
			$('#cbxCliente').data('kendoDropDownList').dataSource.data(cliente.data);
			var tipoProducto = cargarComboConsulta('obtenerTipoProducto');
			$('#cbxTipoProducto').data('kendoDropDownList').dataSource.data(tipoProducto.data);
			
			buscarProducto();

//			limpiarComponentesRegistrarObraModal();
//			limpiarComponentesModificarObraModal();

		});

// Variables globales
var idProductoSeleccionado = null;
var idFcSeleccionado = null;

function seleccionarFila() {

	$("tr.k-state-selected").removeClass("k-state-selected");

	var checked = this.checked, row = $(this).closest("tr"), grid = $("#gridProducto").data("kendoGrid"), dataItem = grid.dataItem(row);
	if (checked) {
		$('input:radio').removeAttr('checked');
		this.checked = true;
		row.addClass("k-state-selected");
		idProductoSeleccionado = dataItem.id;
		idFcSeleccionado = dataItem.idFc;
	} else {
		row.removeClass("k-state-selected");
		idProductoSeleccionado = null;
		idFcSeleccionado= null;
		
	}
}




function limpiarComponentesRegistrarObraModal() {
	$('#cbxPlantaReg').data('kendoDropDownList').value('');
	$('#cbxClienteReg').data('kendoComboBox').value('');
	$('#cbxContratistaReg').data('kendoComboBox').value('');
	
	$('#txtCodigoReg').val('');
	$('#txtNombreReg').val('');
	$('#txtCodigoSapReg').val('');
	$('#txtDireccionReg').val('');
	$('#txtCorreo1Reg').val('');
	$('#txtCorreo2Reg').val('');
	
}

function limpiarComponentesModificarObraModal() {
	$('#cbxPlantaMod').data('kendoDropDownList').value('');
	$('#cbxClienteMod').data('kendoComboBox').value('');
	$('#cbxContratistaMod').data('kendoComboBox').value('');
	
	$('#txtCodigoMod').val('');
	$('#txtNombreMod').val('');
	$('#txtCodigoSapMod').val('');
	$('#txtDireccionMod').val('');
	$('#txtCorreo1Mod').val('');
	$('#txtCorreo2Mod').val('');
}


function registrarProducto(){
	
	//limpiarComponentesRegistrarObraModal();
	var cliente = cargarComboConsulta('obtenerClientes');
	$('#cbxClienteReg').data('kendoDropDownList').dataSource.data(cliente.data);
	var tipoProducto = cargarComboConsulta('obtenerTipoProducto');
	$('#cbxTipoProductoReg').data('kendoDropDownList').dataSource.data(tipoProducto.data);
	
	$("#RegistrarProducto").data("kendoWindow").title("Registrar Producto").center().open();
}

function modificarProducto(){
	if (idProductoSeleccionado != null) {
		
		//limpiarComponentesModificarObraModal();

		productoViewModel = {
				idProducto : idProductoSeleccionado
		}
		
		var response = transaccionProducto("obtenerProductoPorId", productoViewModel);
		if(response==null){
			return;
		}
		
		var cliente = cargarComboConsulta('obtenerClientes');
		$('#cbxClienteMod').data('kendoDropDownList').dataSource.data(cliente.data);
		var tipoProducto = cargarComboConsulta('obtenerTipoProducto');
		$('#cbxTipoProductoMod').data('kendoDropDownList').dataSource.data(tipoProducto.data);
		
		
		$('#cbxClienteMod').data('kendoDropDownList').value(response.idCliente);
		$('#cbxTipoProductoMod').data('kendoDropDownList').value(response.tipoProducto);
		$('#txtCantidadMod').val(response.cantidadProducto);
		$('#txtPrecioMod').val(response.precioProducto);
		$('#txtNombreMod').val(response.nombreProducto);
				
		$("#ModificarProducto").data("kendoWindow").title("Modificar Producto").center().open();
	} else {
		abrirPopupAccionRealizada('Mensaje','Debe seleccionar un Producto.');
	}
}

function eliminarProducto(){
	if (idProductoSeleccionado != null) {
		abrirPopupConfirmacion('Mensaje','¿Est\u00e1 seguro de querer eliminar el Producto?.');

		$("#btnConfirmacionConfirmar").unbind('click');
		$("#btnConfirmacionConfirmar").click(function() {
			cerrarPopupConfirmacion();
			productoViewModel = {
					idProducto : idProductoSeleccionado
			}
			
			var response = transaccionProducto("eliminarProducto", productoViewModel);
			if(response==null){
				return;
			}
			if (response.codigo == 1) {
				abrirPopupAccionRealizada('Mensaje','El Producto ha sido eliminada de forma satisfactoria.');
				buscarProducto();
				
			} else {
				abrirPopupAccionRealizada('Mensaje', response.mensaje);
			}
		});
		
	} else {
		abrirPopupAccionRealizada('Mensaje','Debe seleccionar una Obra.');
	}
}

function AceptarRegistrarProducto(){
	var flag = true;
	var listaCamposRequeridos = [];
	
	
	
	var idCliente = $('#cbxClienteReg').data('kendoDropDownList').value();
	var tipoProducto = $('#cbxTipoProductoReg').data('kendoDropDownList').value();
	var cantidad = $('#txtCantidadReg').val();
	var precio = $('#txtPrecioReg').val();
	var nombreProducto = $('#txtNombreReg').val();
	
	
	productoViewModel = {
			idCliente : idCliente,
			tipoProducto : tipoProducto,
			nombreProducto : nombreProducto,
			precioProducto : precio,
			cantidadProducto : cantidad
	}
	var response = transaccionProducto("registrarProducto", productoViewModel);
	if(response==null){
		return;
	}
	if (response.codigo == 1) {
		
//		limpiarComponentesRegistrarObraModal();
		idProductoSeleccionado = null;
		abrirPopupAccionRealizada('Mensaje','El Producto ha sido registrada de forma satisfactoria.');
		$("#RegistrarProducto").data("kendoWindow").close();
		buscarProducto();
		
	} else {
		abrirPopupAccionRealizada('Mensaje', response.mensaje);
	}
	
}

function CancelarModificarProducto(){
	abrirPopupConfirmacion('Mensaje','¿Est\u00e1 seguro de cancelar la modificaci\u00f3n del Producto?.');

	$("#btnConfirmacionConfirmar").unbind('click');
	$("#btnConfirmacionConfirmar").click(function() {
		cerrarPopupConfirmacion();
		$("#ModificarProducto").data("kendoWindow").close();
	});
}

function CancelarRegistrarProducto(){
	abrirPopupConfirmacion('Mensaje','¿Est\u00e1 seguro de cancelar el registro de la Obra?.');

	$("#btnConfirmacionConfirmar").unbind('click');
	$("#btnConfirmacionConfirmar").click(function() {
		cerrarPopupConfirmacion();
		$("#RegistrarObra").data("kendoWindow").close();
	});
}

function AceptarModificarProducto(){
	var flag = true;
	var listaCamposRequeridos = [];
	
	
	var idCliente = $('#cbxClienteMod').data('kendoDropDownList').value();
	var tipoProducto = $('#cbxTipoProductoMod').data('kendoDropDownList').value();
	var cantidad = $('#txtCantidadMod').val();
	var precio = $('#txtPrecioMod').val();
	var nombreProducto = $('#txtNombreMod').val();
	
	
	productoViewModel = {
			idCliente : idCliente,
			tipoProducto : tipoProducto,
			nombreProducto : nombreProducto,
			precioProducto : precio,
			cantidadProducto : cantidad
	}
	
	var response = transaccionProducto("modificarProducto", productoViewModel);
	if(response==null){
		return;
	}
	if (response.codigo == 1) {
//		limpiarComponentesModificarObraModal();
		idProductoSeleccionado = null;
		idFcSeleccionado = null;
		abrirPopupAccionRealizada('Mensaje','El Producto ha sido modificada de forma satisfactoria.');
		$("#ModificarProducto").data("kendoWindow").close();
		buscarProducto();
	}else{
		abrirPopupAccionRealizada('Mensaje', response.mensaje);
	}
	
}

function limpiarCamposBusqueda(){
	$('#cbxProducto').data('kendoComboBox').value('');
	$('#cbxTipoProducto').data('kendoDropDownList').value('');
	$('#cbxTipoCemento').data('kendoDropDownList').value('');
	$('#cbxLineaProducto').data('kendoDropDownList').value('');
	$('#txtCodigoSap').val('');
		
}

function buscarProducto(){
	
	productoViewModel = {}
	
	var response = transaccionProducto("obtenerProducto", productoViewModel);
	if(response==null){
		return;
	}
	
	$('#gridProducto').data('kendoGrid').dataSource.data(response.data);
	$('#gridProducto').data('kendoGrid').pager.page(1);
		

	
	
}

function transaccionProducto(metodo, productoViewModel){
	var resultado = null;
	$.ajax({
		url : metodo,
		type : "POST",
		contentType : "application/json; charset=utf-8",
		data :  JSON.stringify(productoViewModel),
		async : false,
		cache : false,
		processData : false,
		success : function(response) {
			if(!validarSesion(response)){
				cerrarSesion();
			}else{
				resultado = response;
			}
		},
		error: function(jqXHR, textStatus, error) {
			abrirPopupAccionRealizada('Mensaje','Error en la conexi\u00f3n con el servidor de aplicaciones.');
		}
	});
	return resultado;
}

function cargarComboConsulta(metodo) {
	var resultado = null;
	$.ajax({
		url : metodo,
		type : "POST",
		contentType : "application/json; charset=utf-8",
		async : false,
		cache : false,
		processData : false,
		success : function(response) {
			if(!validarSesion(response)){
				cerrarSesion();
			}else{
				resultado = response;
			}
		}
	});
	return resultado;
}


// ]]>
