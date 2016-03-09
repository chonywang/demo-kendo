
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">


	<!-- Common Kendo UI CSS -->
<!--     <link href="${pageContext.request.contextPath}/app/resources/css/kendo.common.min.css" rel="stylesheet" /> -->
    
	<!--------------------- TEMAS DE KENDO UI --------------------->
     <!-- Default Kendo UI theme CSS -->
<%-- 	<link href="${pageContext.request.contextPath}/app/resources/css/kendo.default.min.css" rel="stylesheet" /> --%>
    <!-- BlueOpal Kendo UI theme CSS -->
    <link href="${pageContext.request.contextPath}/app/resources/css/kendo.blueopal.min.css" rel="stylesheet" />    
    <!-- Black Kendo UI theme CSS -->
<%-- 	<link href="${pageContext.request.contextPath}/app/resources/css/kendo.black.min.css" rel="stylesheet" /> --%>
	<!-- Bootstrap Kendo UI theme CSS -->
<!-- 	<link href="${pageContext.request.contextPath}/app/resources/css/kendo.bootstrap.min.css" rel="stylesheet" /> -->
    <!-- Flat Kendo UI theme CSS -->
<!-- 	<link href="${pageContext.request.contextPath}/app/resources/css/kendo.flat.min.css" rel="stylesheet" /> -->
	<!--------------------- TEMAS DE KENDO UI --------------------->
	
    <!-- jQuery JavaScript -->
    <script src="${pageContext.request.contextPath}/app/resources/js/jquery-1.11.1.js"></script>
	<!-- Archivo de migracion jquery -->
	<script src="${pageContext.request.contextPath}/app/resources/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>    

    <!-- Kendo UI combined JavaScript -->
    <script src="${pageContext.request.contextPath}/app/resources/js/kendo.all.min.js"></script>

	<!-- Kendo Web JavaScript -->
	<script src="${pageContext.request.contextPath}/app/resources/js/kendo.web.min.js"></script>

	<!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/app/resources/css/bootstrap.min.css" rel="stylesheet" />

	<!-- Kendo Common Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/app/resources/css/kendo.common-bootstrap.min.css">

	<!-- Styles personalizados CSS -->
    <link href="${pageContext.request.contextPath}/app/resources/css/styles-all-devices.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/app/resources/css/styles-lg-devices.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/app/resources/css/styles-md-devices.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/app/resources/css/styles-sm-devices.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/app/resources/css/styles-xs-devices.css" rel="stylesheet" />

	<!-- Inicio Cultures of Kendo Calendar -->
	<script src="${pageContext.request.contextPath}/app/resources/js/cultures/kendo.culture.es-ES.min.js" type="text/javascript"></script>
	<!-- Fin Cultures of Kendo Calendar -->
	
	<!-- Inicio soporte css3 para IE -->
<!-- 		<!--[if IE]>  -->
			<script src="${pageContext.request.contextPath}/app/resources/js/html5shiv.min.js" type="text/javascript"></script>
<!-- 		<![endif]-->
		 	<script src="${pageContext.request.contextPath}/app/resources/js/respond.min.js" type="text/javascript"></script>
	<!-- Fin soporte css3 para IE -->
	
	<!-- Archivo Util personalizado -->
	<script src="${pageContext.request.contextPath}/app/resources/js/util.js" type="text/javascript"></script>
	
	
	<!-- Popup de Accion realizada -->
	<kendo:window name="popupAccionRealizada" title="Popup de Accion Realizada" modal="true" 
					draggable="true" resizable="false" visible="false" >
			<kendo:window-content>						
	
	        <p id="mensajePopupAccionRealizada" ></p>	        
	        
	        <div class="pull-right">
	        	<kendo:button name="btnAccionRealizadaOk" click="cerrarPopupAccionRealizada">Aceptar</kendo:button>				
	        </div>	        
			
		</kendo:window-content>	
	</kendo:window>
	
	
	
	<script type="text/javascript">
		
	
	
		function abrirPopupAccionRealizada(titulo, mensaje){
			$('#mensajePopupAccionRealizada').text("");
			//Escribimos el mensaje a mostrar en el cuerpo del popup de confirmacion
			$('#mensajePopupAccionRealizada').text(mensaje);
			$("#popupAccionRealizada").data("kendoWindow").title(titulo).center().open();
		}
		
		function abrirPopupAccionRealizada(titulo, mensaje, array){
			$('#mensajePopupAccionRealizada').text("");
			//Escribimos el mensaje a mostrar en el cuerpo del popup de confirmacion
			$('#mensajePopupAccionRealizada').text(mensaje);
	// 		console.log('array tamanio: ' + array.length);
	
			$('#listaMensajesHtml').remove();
	
			array = array || [];
			
			var tamArray = array.length;
			
			if(tamArray>0){
				var html = '<p id="listaMensajesHtml">';
				$(array).each(function(indice, elemento){
					if(indice>0){
						html = html + '<br/>';
					}
					
					html = html + '<span style="margin-left: 10px;"> * ' + elemento + '</span>';
				});
				html = html + '</p>'
				$("#mensajePopupAccionRealizada").after(html);
			}
			
			$("#popupAccionRealizada").data("kendoWindow").title(titulo).center().open();
		}
		
		function cerrarPopupAccionRealizada(){
			$("#popupAccionRealizada").data("kendoWindow").close();
		}
	
	</script>
	
	