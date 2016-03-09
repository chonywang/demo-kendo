//<C[DATA[
$(document).ready(function() {
	
	$('#btnRegistrar').data('kendoButton').enable(true);
	$('#btnModificar').data('kendoButton').enable(true);
	$('#btnEliminar').data('kendoButton').enable(true);
	
			//var opcionMenuResponse = obtenerOpcionMenu();
			//$('#cbxOpcionMenu').data('kendoComboBox').dataSource.data(opcionMenuResponse.data);
			/*Cambiamos el texto del footer de la grilla*/
			var grid = $('#gridCliente').data('kendoGrid');
			grid.dataSource.bind("change", function (e) {			
				var texto;
				if($('#gridCliente').data('kendoGrid').dataSource.data().length != 0){
					texto = $('#gridCliente span.k-pager-info.k-label').text();			
					texto = texto.replace('of','de').replace('items','registros');				
				}else{
					texto = 'No existen registros a mostrar';				
				}
				$('#gridCliente span.k-pager-info.k-label').text(texto);
			});
			/**/
			
			$('#gridCliente').css('width', '100%');
			$('#gridCliente').data('kendoGrid').table.on("click", ".radio",seleccionarFila);
			
			
			var tipoCliente = cargarComboConsulta('obtenerTipoCliente');
			$('#cbxTipoCliente').data('kendoDropDownList').dataSource.data(tipoCliente.data);
			
			var estadoCivil = cargarComboConsulta('obtenerEstadoCivil');
			$('#cbxEstadoCivil').data('kendoDropDownList').dataSource.data(estadoCivil.data);
			
			var sexo = cargarComboConsulta('obtenerSexo');
			$('#cbxSexo').data('kendoDropDownList').dataSource.data(sexo.data);
			
			
			buscarClienteInicial();			

//			limpiarComponentesRegistrarClienteModal();
//			limpiarComponentesModificarClienteModal();
			
		});

// Variables globales
var idClienteSeleccionado = null;

function seleccionarFila() {

	$("tr.k-state-selected").removeClass("k-state-selected");

	var checked = this.checked, row = $(this).closest("tr"), grid = $("#gridCliente").data("kendoGrid"), dataItem = grid.dataItem(row);
	if (checked) {
		$('input:radio').removeAttr('checked');
		this.checked = true;
		row.addClass("k-state-selected");

		idClienteSeleccionado = dataItem.id;

	} else {
		row.removeClass("k-state-selected");
		idClienteSeleccionado = null;
		
	}
}

function limpiarComponentesRegistrarClienteModal() {
	$('#txtCodigoReg').val('');
	$('#txtNombreReg').val('');
	$('#txtCodigoSapReg').val('');
	$('#txtRUCReg').val('');
	$('#txtTelefonoReg').val('');
	$('#txtCorreo1Reg').val('');
	$('#txtCorreo2Reg').val('');
	$('#txtCorreo3Reg').val('');
	$("#ckxClienteReg").prop('checked',false);
	$("#ckxContratistaReg").prop('checked',false);
}

function limpiarComponentesModificarClienteModal() {
	$('#txtCodigoMod').val('');
	$('#txtNombreMod').val('');
	$('#txtCodigoSapMod').val('');
	$('#txtRUCMod').val('');
	$('#txtTelefonoMod').val('');
	$('#txtCorreo1Mod').val('');
	$('#txtCorreo2Mod').val('');
	$('#txtCorreo3Mod').val('');
	$("#ckxClienteMod").prop('checked',false);
	$("#ckxContratistaMod").prop('checked',false);
	
	
}


function registrarCliente(){
	//limpiarComponentesRegistrarClienteModal();
	var tipoCliente = cargarComboConsulta('obtenerTipoCliente');
	$('#cbxTipoClienteReg').data('kendoDropDownList').dataSource.data(tipoCliente.data);
	
	var estadoCivil = cargarComboConsulta('obtenerEstadoCivil');
	$('#cbxEstadoCivilReg').data('kendoDropDownList').dataSource.data(estadoCivil.data);
	
	var sexo = cargarComboConsulta('obtenerSexo');
	$('#cbxSexoReg').data('kendoDropDownList').dataSource.data(sexo.data);
	
	
	$("#RegistrarCliente").data("kendoWindow").title("Registrar Cliente").center().open();
}

function modificarCliente(){
	if (idClienteSeleccionado != null) {
		limpiarComponentesModificarClienteModal();
		
		var clienteViewModel = {
				idCliente :  idClienteSeleccionado
		};
		var response = transaccionCliente("obtenerClientePorId", clienteViewModel);
		
		if(response!=null){
			
			var tipoCliente = cargarComboConsulta('obtenerTipoCliente');
			$('#cbxTipoClienteMod').data('kendoDropDownList').dataSource.data(tipoCliente.data);
			$('#cbxTipoClienteMod').data('kendoDropDownList').value(response.tipoCliente);
			var estadoCivil = cargarComboConsulta('obtenerEstadoCivil');
			$('#cbxEstadoCivilMod').data('kendoDropDownList').dataSource.data(estadoCivil.data);
			$('#cbxEstadoCivilMod').data('kendoDropDownList').value(response.estadoCivilCliente);
			
			var sexo = cargarComboConsulta('obtenerSexo');
			$('#cbxSexoMod').data('kendoDropDownList').dataSource.data(sexo.data);
			$('#cbxSexoMod').data('kendoDropDownList').value(response.sexoCliente);
			
			$('#txtApellidoMod').val(response.apellidoCliente);
			$('#txtNombreMod').val(response.nombreCliente);
			$('#txtCorreoMod').val(response.correoCliente);
			
			
			$("#ModificarCliente").data("kendoWindow").title("Modificar Cliente - Contratista").center().open();
		}
	} else {
		abrirPopupAccionRealizada('Mensaje','Debe seleccionar un Cliente.');
	}
}

function eliminarCliente(){
	if (idClienteSeleccionado != null) {
		abrirPopupConfirmacion('Mensaje','¿Est\u00e1 seguro de querer eliminar el Cliente?.');

		$("#btnConfirmacionConfirmar").unbind('click');
		$("#btnConfirmacionConfirmar").click(function() {
			cerrarPopupConfirmacion();
			clienteViewModel = {
				idCliente : idClienteSeleccionado
			}
			var response = transaccionCliente("eliminarCliente", clienteViewModel);
			
			if(response!=null){
				if (response.codigo == 1) {
					abrirPopupAccionRealizada('Mensaje','El Cliente ha sido eliminado de forma satisfactoria.');
					idClienteSeleccionado = null;
					buscarCliente();
					
				} else {
					abrirPopupAccionRealizada('Mensaje', response.mensaje);
				}
			}
		});
		
	} else {
		abrirPopupAccionRealizada('Mensaje','Debe seleccionar un Cliente.');
	}
}

function AceptarRegistrarCliente(){
	var flag = true;
	var listaCamposRequeridos = [];
	
	var nombre = $('#txtNombreReg').val();
	var apellido = $('#txtApellidoReg').val();
	var sexo =  $('#cbxSexoReg').data('kendoDropDownList').value();
	var estadoCivil =  $('#cbxEstadoCivilReg').data('kendoDropDownList').value();
	var tipoCliente =  $('#cbxTipoClienteReg').data('kendoDropDownList').value();
	var correo = $('#txtCorreoReg').val();
	
		
	clienteViewModel = {
			nombreCliente : nombre,
			apellidoCliente : apellido,
			sexoCliente : sexo,
			estadoCivilCliente : estadoCivil,
			tipoCliente : tipoCliente,
			correoCliente : correo
	}
	var response = transaccionCliente("registrarCliente", clienteViewModel);
	if(response!=null){
		if (response.codigo == 1) {
			abrirPopupAccionRealizada('Mensaje','El Cliente ha sido registrado de forma satisfactoria.');
			$("#RegistrarCliente").data("kendoWindow").close();
			buscarCliente();
			
		} else {
			abrirPopupAccionRealizada('Mensaje', response.mensaje);
		}
	}
}

function CancelarModificarCliente(){
	abrirPopupConfirmacion('Mensaje','¿Est\u00e1 seguro de cancelar el modificacion del Cliente?.');

	$("#btnConfirmacionConfirmar").unbind('click');
	$("#btnConfirmacionConfirmar").click(function() {
		cerrarPopupConfirmacion();
		$("#ModificarCliente").data("kendoWindow").close();
	});
}

function CancelarRegistrarCliente(){
	abrirPopupConfirmacion('Mensaje','¿Est\u00e1 seguro de cancelar la registro del Cliente?.');

	$("#btnConfirmacionConfirmar").unbind('click');
	$("#btnConfirmacionConfirmar").click(function() {
		cerrarPopupConfirmacion();
		$("#RegistrarCliente").data("kendoWindow").close();
	});
}

function AceptarModificarCliente(){
	var flag = true;
	var listaCamposRequeridos = [];
	
	var nombre = $('#txtNombreMod').val();
	var apellido = $('#txtApellidoMod').val();
	var sexo =  $('#cbxSexoMod').data('kendoDropDownList').value();
	var estadoCivil =  $('#cbxEstadoCivilMod').data('kendoDropDownList').value();
	var tipoCliente =  $('#cbxTipoClienteMod').data('kendoDropDownList').value();
	var correo = $('#txtCorreoMod').val();
	
		
	clienteViewModel = {
			idCliente : idClienteSeleccionado,
			nombreCliente : nombre,
			apellidoCliente : apellido,
			sexoCliente : sexo,
			estadoCivilCliente : estadoCivil,
			tipoCliente : tipoCliente,
			correoCliente : correo
	}
	
	var response = transaccionCliente("modificarCliente", clienteViewModel);
	if(response!=null){
		if (response.codigo == 1) {
			abrirPopupAccionRealizada('Mensaje','El Cliente ha sido modificado de forma satisfactoria.');
			$("#ModificarCliente").data("kendoWindow").close();
			idClienteSeleccionado = null;
			buscarCliente();	
			
		} else {
			abrirPopupAccionRealizada('Mensaje', response.mensaje);
		}
	}
	
}

function buscarCliente(){
	
	clienteViewModel = {
				
	}
	var response = transaccionCliente("obtenerCliente", clienteViewModel);
	if(response!=null){
		$('#gridCliente').data('kendoGrid').dataSource.data(response.data);
		$('#gridCliente').data('kendoGrid').pager.page(1);
	}
	
}

function limpiarCamposBusqueda(){
	$('#txtCodigo').val('');
	$('#txtNombre').val('');
	$('#txtRUC').val('');
	$('#cbxRol').data('kendoDropDownList').value('');
}

function transaccionCliente(metodo, clienteViewModel){
	var resultado = null;
	$.ajax({
		url : metodo,
		type : "POST",
		contentType : "application/json; charset=utf-8",
		data :  JSON.stringify(clienteViewModel),
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
