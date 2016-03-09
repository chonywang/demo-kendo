<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<title>MEN&Uacute; SAC CONCRETO</title>
	<jsp:include page="../WEB-INF/template/configuracionWeb.jsp" />
</head>
<body>
	
	<jsp:include page="../WEB-INF/template/header.jsp" flush="true" />
	
	
	<div id="contenedor" style="width:100%;">
		<kendo:splitter name="splitter" orientation="horizontal">
		    <kendo:splitter-panes>
			    <kendo:splitter-pane id="left_pane" size="225px" min="200px" collapsible="true">
			        <kendo:splitter-pane-content>
		                <div class="pane-content">						                
			                <kendo:panelBar name="panelBar" style="border: none;" >
							</kendo:panelBar>						                
                        </div>
		            </kendo:splitter-pane-content>
			    </kendo:splitter-pane>
			    <kendo:splitter-pane id="right_pane" collapsible="false">
			    	<kendo:splitter-pane-content>
				    	<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
							<h5>Bienvenido(a)</h5>
						 	<h3>${usuarioSesion.nombre} ${usuarioSesion.apellidoPaterno}</h3>
						    <p>Al sistema de Producto</p>
						</div>
					</kendo:splitter-pane-content>
			    </kendo:splitter-pane>
		    </kendo:splitter-panes>    
		</kendo:splitter>
	</div>

	
	<jsp:include page="../WEB-INF/template/footer.jsp" />
	
	<script>
	//<C[DATA[
	$(document).ready(function(){
		
// 		$('#bodyPane').data().pane.contentUrl = 'content/bienvenida'
		
		var windowHeight = $( window ).height();
		var windowWidth = $( window ).width();	
		
		var headerHeight = $( '#idHeader' ).height();
		var headerWidth = $( '#idHeader' ).width();
		var footerHeight = $( '#idFooter' ).height();
		
		var heightSplitter = windowHeight - (headerHeight + footerHeight) - 30;
				
		$('#idDatos').text('Altura: ' + heightSplitter + 'px Ancho: ' + windowWidth + 'px');
		
		var widthContenedorSplitter = $('#contenedor').width();
		
		$('#splitter').css('width',headerWidth + 28);
		$('#splitter').css('height',heightSplitter - 3);
		
		$('#splitter').children().css('height',heightSplitter-3);
		
		$('#right_pane').css('width',headerWidth - $('#left_pane').width());
		
		$( window ).resize(function() {
			var windowHeight = $( window ).height();
			var windowWidth = $( window ).width();			
			$('#idDatos').text('Altura: ' + heightSplitter + 'px Ancho: ' + windowWidth + 'px');			
			
			var heightSplitter = windowHeight - (headerHeight + footerHeight) - 28;
			
			$('#splitter').css('width',windowWidth-2);
			$('#splitter').css('height',heightSplitter-3);
			
		});
		
		/* var resultado = null;
		
		$.ajax({
			url : "${pageContext.request.contextPath}/app/principal/obtenerPermisoOpcionMenu",
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
			},
			error: function(jqXHR, textStatus, error) {
				abrirPopupAccionRealizada('Mensaje','Error en la conexi\u00f3n con el servidor de aplicaciones.');
			}
		}); */
		
		//carga del menu
		var prueba = [];
		
		prueba =[{
		          text: "Control de Productos Clientes"
		         }, 
		         {
		          text: "Control de Productos",
		          items: [{                              
		          	      text: "Administrar Producto",
		                  url: "${pageContext.request.contextPath}/app/producto/"
		             	 },
		                 {
		                  text: "Adminsitrar Maestros",
		                  items: [{
		                	      text: "Clientes",
		                	      url: "${pageContext.request.contextPath}/app/cliente/"
		                  		 }]
		                 }]
		         }];
		
		//$('#panelBar').data('kendoPanelBar').dataSource(prueba);
		 $("#panelBar").kendoPanelBar({
			    dataSource: prueba });
		
		
	});

	//]]>
	</script>
	
</body>
</html>