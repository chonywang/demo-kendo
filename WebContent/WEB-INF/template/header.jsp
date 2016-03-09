
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<!-- 	<header> -->
		<div id="idHeader" style="background-color: #E9EAF0; padding-left:15px; padding-right:15px;">
		
	        <div class="row">
	        
	        	<div class="col-sm-2 col-md-2 col-lg-2 remove-padding-lateral-col-md">
	        	
	        		<div>	  
	        			<div class='col-sm-12 col-md-12 remove-padding-lateral-col-sm' align="center">
			        			<img src="${pageContext.request.contextPath}/app/resources/images/ga.png" class="img-responsive" />
			        		</div>
	        		</div>
	        	</div>
	        	
		        <div class="col-sm-8 col-md-8 col-lg-8">
		        	<div class="row">
		        		<div class="col-sm-12 col-md-12 ">
			        		<h2 align="center">Sistema de Productos</h2>
			        	</div>
		        	</div>		        	
		        	<div class="row" style="background-color:#CED1DC">
		        		<div class="col-sm-7 col-md-8 col-lg-9">Bienvenido(a) Sr(ita).: ${usuarioSesion.nombre} ${usuarioSesion.apellidoPaterno}</div>
			        	<div class="col-sm-5 col-md-4 col-lg-3 remove-padding-right-col-md">
			        		<div class="row">
<!-- 			        			<form id="formHeader" method="POST"> -->
				        			<div class="col-sm-4 col-md-4 col-lg-4 remove-padding-right-col-md">
				        				<img src="${pageContext.request.contextPath}/app/resources/images/Icono Home.gif" />
				        				<a href="${pageContext.request.contextPath}/app/login/" style="cursor: pointer;">Inicio</a>
				        			</div>
				        			<div class="col-sm-8 col-md-8 col-lg-8 remove-padding-right-col-md">
				        				<img src="${pageContext.request.contextPath}/app/resources/images/Icono Cerrar Sesion.gif" />
				        				<a href="#" onclick="cerrarSesion()" style="cursor: pointer;">Cerrar Sesi&oacute;n</a>
				        			</div>
<!-- 				        		</form> -->
			        		</div>
			        	</div>
		        	</div>		        	
		        </div>
		        <div class="col-sm-2 col-md-2 col-lg-2">
		        	<div class='col-sm-12 col-md-12 remove-padding-lateral-col-sm' align="center">
			        			<img src="${pageContext.request.contextPath}/app/resources/images/ga.png" class="img-responsive" />
			        </div>
		        	
		        </div>
	        </div>		        
	    </div>
<!-- 	</header> -->
	
	<!-- Popup de Confirmacion -->
	<kendo:window name="popupConfirmacion" title="Popup de Confirmacion" modal="true" 
					draggable="true" resizable="false" visible="false" >
			<kendo:window-content>						
	
	        <p id="mensajePopupConfirmacion" ></p>
	        
	        <div class="pull-right">
	        	<kendo:button name="btnConfirmacionConfirmar" >Si</kendo:button>
				<kendo:button name="btnConfirmacionCancelar" click="cerrarPopupConfirmacion">No</kendo:button>
	        </div>	        
			
		</kendo:window-content>	
	</kendo:window>
	
	



<script>
//<C[DATA[
          
    var listaPermisos = [];
    var listaRoles = [];
          
	$(document).ready(function(){
		
		//listaPermisos = obtenerListaPermisosUsuario();
		//listaRoles = obtenerListaRolesUsuario();
		
	});
	
	function usuarioTienePermiso(codigoPermiso){

		var numeroRespuesta = $.inArray( codigoPermiso, listaPermisos );
		
		if(numeroRespuesta>=0){
			return true;
		}else{
			return false;
		}
		
	}

	function usuarioTienePermisoEliminar(codigoPermiso){

		var numeroRespuesta = $.inArray( codigoPermiso, listaPermisos );
		var numeroRespuesta2 = $.inArray( 42, listaRoles );
		var numeroRespuesta3 = $.inArray( 41, listaRoles );
		if(numeroRespuesta>0 && (numeroRespuesta2>0 || numeroRespuesta3>0)){
		//if(numeroRespuesta>0 && numeroRespuesta2>0){
			return true;
		}else{
			return false;
		}
		
	}

	function usuarioTienePermisoModificar(codigoPermiso){
		var numeroRespuesta = $.inArray( codigoPermiso, listaPermisos );
		var numeroRespuesta2 = $.inArray( 42, listaRoles );
		var numeroRespuesta3 = $.inArray( 41, listaRoles );
		if(numeroRespuesta>0 && (numeroRespuesta2>0 || numeroRespuesta3>0)){
			return true;
		}else{
			return false;
		}
	}
	
	function obtenerListaPermisosUsuario(){
		
		var resultado = [];
		
		$.ajax({
			url : '${pageContext.request.contextPath}/app/login/obtenerListaPermisos',
			type : "POST",
			contentType : "application/json; charset=utf-8",			
			async : false, 
			cache : false,  
			processData : false,
			success : function(response) {
				resultado = response;
			}
		});
		
		return resultado;
		
	}

	function obtenerListaRolesUsuario(){
		
		var resultado = [];
		
		$.ajax({
			url : '${pageContext.request.contextPath}/app/login/obtenerListaRoles',
			type : "POST",
			contentType : "application/json; charset=utf-8",			
			async : false, 
			cache : false,  
			processData : false,
			success : function(response) {
				resultado = response;
			}
		});
		
		return resultado;
		
	}
	
	//Constantes globales de codigos de permisos
	var LOTE_INICIO = 'HU0001_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var LOTE_MODIFICAR_ESTADO = 'HU0001_PERM_002';
	var LOTE_REGISTRAR = 'HU0001_PERM_003';
	var LOTE_MODIFICAR = 'HU0001_PERM_004';
	var LOTE_ELIMINAR = 'HU0001_PERM_005';
	
	var MUESTRA_INDIVIDUAL_INICIO = 'HU0002_PERM_001';	// Este Permiso falta validar en su pantalla respectiva
	var MUESTRA_INDIVIDUAL_REGISTRAR = 'HU0002_PERM_002';
	var MUESTRA_INDIVIDUAL_MODIFICAR = 'HU0002_PERM_003';
	var MUESTRA_INDIVIDUAL_ELIMINAR = 'HU0002_PERM_004';
	var MUESTRA_INDIVIDUAL_REGISTRAR_INSPECCION_PLANTA = 'HU0002_PERM_005';
	
	var MUESTRA_ALEATORIA_INICIO = 'HU0003_PERM_001';	// Este Permiso falta validar en su pantalla respectiva
	var MUESTRA_ALEATORIA_REGISTRAR = 'HU0003_PERM_002';
	var MUESTRA_ALEATORIA_MODIFICAR = 'HU0003_PERM_003';
	var MUESTRA_ALEATORIA_ELIMINAR = 'HU0003_PERM_004';
	var MUESTRA_ALEATORIA_REGISTRAR_CONCRETO_FRESCO = 'HU0003_PERM_005';
	var MUESTRA_ALEATORIA_REASIGNAR_DT = 'HU0003_PERM_005';
		
	var INGRESO_CURADO_INICIO = 'HU0004_PERM_001';	// Este Permiso falta validar en su pantalla respectiva
	var INGRESO_CURADO_INGRESAR_A_CURADO = 'HU0004_PERM_002';
	
	var ENSAYO_ENDURECIDO_INICIO = 'HU0005_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var ENSAYO_ENDURECIDO_REGISTRAR_COMPRESION = 'HU0005_PERM_002';
	var ENSAYO_ENDURECIDO_REGISTRAR_FLEXION = 'HU0005_PERM_003';
	
	var CONSULTA_ENSAYO_INICIO = 'HU0006_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	
	var CERTIFICADO_CALIDAD_INICIO = 'HU0007_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var CERTIFICADO_CALIDAD_ENVIAR_CORREO_MANUAL = 'HU0007_PERM_002';
	
	var REPORTE_CARTA_CONTROL_INICIO = 'HU0008_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var REPORTE_CARTA_CONTROL_ENVIAR_CORREO_MANUAL = 'HU0008_PERM_002';
	
	var REPORTE_GERENCIAL_INICIO = 'HU0009_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var REPORTE_GERENCIAL_ENVIAR_CORREO_MANUAL = 'HU0009_PERM_002';
	
	var TIPO_MOLDE_INICIO = 'HU0010_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var TIPO_MOLDE_REGISTRAR = 'HU0010_PERM_002';
	var TIPO_MOLDE_MODIFICAR = 'HU0010_PERM_003';
	var TIPO_MOLDE_ELIMINAR = 'HU0010_PERM_004';
	
	var LOTE_MOLDE_INICIO = 'HU0011_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var LOTE_MOLDE_REGISTRAR = 'HU0011_PERM_002';
	var LOTE_MOLDE_MODIFICAR = 'HU0011_PERM_003';
	var LOTE_MOLDE_ELIMINAR = 'HU0011_PERM_004';
	
	var MIXER_INICIO = 'HU0012_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var MIXER_REGISTRAR = 'HU0012_PERM_002';
	var MIXER_MODIFICAR = 'HU0012_PERM_003';
	var MIXER_ELIMINAR = 'HU0012_PERM_004';
	
	var CLIENTE_CONTRATISTA_INICIO = 'HU0013_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var CLIENTE_CONTRATISTA_REGISTRAR = 'HU0013_PERM_002';
	var CLIENTE_CONTRATISTA_MODIFICAR = 'HU0013_PERM_003';
	var CLIENTE_CONTRATISTA_ELIMINAR = 'HU0013_PERM_004';
	
	var OBRA_INICIO = 'HU0014_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var OBRA_REGISTRAR = 'HU0014_PERM_002';
	var OBRA_MODIFICAR = 'HU0014_PERM_003';
	var OBRA_ELIMINAR = 'HU0014_PERM_004';

	var PRODUCTO_INICIO = 'HU0015_PERM_001';// Este Permiso falta validar en su pantalla respectiva
	var PRODUCTO_REGISTRAR = 'HU0015_PERM_002';
	var PRODUCTO_MODIFICAR = 'HU0015_PERM_003';
	var PRODUCTO_ELIMINAR = 'HU0015_PERM_004';
	
	
	
	
	function cerrarSesion(){
		
// 		alert('Entro al metodo cerrar sesion');
		var resultado = null;
		$.ajax({
			url : '${pageContext.request.contextPath}/app/login/cerrarSesion',
			type : "POST",
			contentType : "application/json; charset=utf-8",			
			async : false, 
			cache : false,  
			processData : false,
			success : function(response) {
				resultado = response;
			}
		});
// 		console.log('Cerrar Sesion: ' + resultado);
		
		window.location.href="${pageContext.request.contextPath}";
		
	}
	
// 	function onSelect(e){
// 		var textItemSeleccionado = $(e.item).find("> .k-link").text();
// 	} 
	
	
// 	function irPagina(idFormulario, ruta){
			
// 		var formulario = document.getElementById(idFormulario);
// 		formulario.action=ruta;
// 		formulario.submit();
		
// 	}
	
	function abrirPopupConfirmacion(titulo, mensaje){
		//Escribimos el mensaje a mostrar en el cuerpo del popup de confirmacion
		$('#mensajePopupConfirmacion').text(mensaje);
		$("#popupConfirmacion").data("kendoWindow").title(titulo).center().open();
	}
	
	function cerrarPopupConfirmacion(){
		$("#popupConfirmacion").data("kendoWindow").close();
	}
	
	function recargarGrilla(idGrilla){
// 		$('#' + idGrilla).data('kendoGrid').dataSource.read();
// 		$('#' + idGrilla).data('kendoGrid').refresh();
	}
	
	function habilitarTextBox(idTextBox, varBoolean){
		
		if(varBoolean){
			$('#' + idTextBox).removeAttr('disabled');
			$('#' + idTextBox).removeClass('k-state-disabled');
		}else{
			$('#' + idTextBox).attr('disabled','disabled');
			$('#' + idTextBox).addClass('k-state-disabled');
		}
		
	}
	
	function obtenerNombreTipoLotePorCaracter(caracter){
		
		var retorno = '';
// 		console.log('Entro obtener nombre Tipo Lote: ' + caracter);
// 		alert('Entro obtener nombre Tipo Lote');
		
		if(caracter!=null && caracter.toUpperCase()=='A'){
			retorno = 'Autom\xE1tico';
		}
		if(caracter!=null && caracter.toUpperCase()=='M'){
			retorno = 'Manual';
		}
		
		return retorno;
	}
	
	function obtenerNombreEstadoCierrePorCaracter(caracter){
		var retorno = '';
// 		console.log('Entro obtener nombre Tipo Lote: ' + caracter);
// 		alert('Entro obtener nombre Tipo Lote');
		
		if(caracter!=null && caracter.toUpperCase()=='A'){
			retorno = 'Abierto';
		}
		if(caracter!=null && caracter.toUpperCase()=='C'){
			retorno = 'Cerrado';
		}
		
		return retorno;
	}
	
	function obtenerNombreTipoEstadoMuestraIndividual(caracter){
		
		var retorno = '';
		console.log('Entro obtener nombre Estado Muestra Individual: ' + caracter);
// 		alert('Entro obtener nombre Tipo Lote');
		
		if(caracter!=null && caracter=='C'){
			retorno = 'Conforme';
		}
		if(caracter!=null && caracter=='NC'){
			retorno = 'No Conforme';
		}
		if(caracter!=null && caracter=='REL'){
			retorno = 'Reprocesado/Eliminado';
		}
		if(caracter!=null && caracter=='REP'){
			retorno = 'Reprocesado';
		}
		console.log('Retorno: ' + retorno);
		return retorno;
	}
	
	function completarIdLote(idLote){
		
// 		if(idLote!=null && idLote!='' && idLote.length<10 && idLote.indexOf("-")==-1){
		if(idLote!=null && idLote!='' && idLote.length<10){
			
			var tamIdLote = idLote.length;
			var tamSubTotal = 10;
			var tamFaltante = tamSubTotal - tamIdLote;
			var subCuerpoIdLoteCompleto = idLote;
			
			for(var i=0;i<tamFaltante;i++){
				subCuerpoIdLoteCompleto = '0' + subCuerpoIdLoteCompleto;
			}
			
// 			var anioActual = kendo.toString(new Date(),'yyyy');
						
// 			return anioActual + '-' + subCuerpoIdLoteCompleto; 
			return subCuerpoIdLoteCompleto;
			
		}else{
			return idLote;
		}
		
	}
	
	
	function completarIdCliente(idCliente){
		
// 		if(idLote!=null && idLote!='' && idLote.length<10 && idLote.indexOf("-")==-1){
		if(idCliente!=null && idCliente!='' && idCliente.length<8){
			
			var tamIdCliente = idCliente.length;
			var tamSubTotal = 8;
			var tamFaltante = tamSubTotal - tamIdCliente;
			var subCuerpoIdClienteCompleto = idCliente;
			
			for(var i=0;i<tamFaltante;i++){
				subCuerpoIdClienteCompleto = '0' + subCuerpoIdClienteCompleto;
			}
			
// 			var anioActual = kendo.toString(new Date(),'yyyy');
						
// 			return anioActual + '-' + subCuerpoIdLoteCompleto; 
			return subCuerpoIdClienteCompleto;
			
		}else{
			return idCliente;
		}
		
	}
	
//]]>
</script>

<!-- 	<div class="container"> -->
