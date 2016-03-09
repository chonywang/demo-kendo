<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%> 

<!DOCTYPE html>
<html>
<head>
	<title>MEN&Uacute; SAC CONCRETO</title>
	<jsp:include page="../WEB-INF/template/configuracionWeb.jsp" />
</head>
<body>
	
	<jsp:include page="../WEB-INF/template/header.jsp" flush="true" />
	
	<div class="container">
		<h4>Pagina Inicio Sistema SAC</h4>
		
		<br />
		<br />
		<form id="pagina" method="POST">
			<a href="#" onclick="irPagina('loteConcreto')">Administrar Lote Concreto</a>
			<br />
			<a href="#" onclick="irPagina('muestraIndividualConcreto')">Administrar Muestra Individual</a>
			<br />
			<a href="#" onclick="irPagina('muestraAleatoriaConcreto')">Administrar Muestra Aleatoria</a>
			<br />
			<a href="#" onclick="irPagina('ingresoCuradoConcreto')">Administrar Ingreso a Curado</a>
			<br />
			<a href="#" onclick="irPagina('ensayoEndurecido')">Administrar Ensayo Endurecido</a>
			<br />		
			<a href="#" onclick="irPagina('consultaEnsayo')">Administrar Consulta Ensayo Page</a>
			<br />		 
		</form>
	</div>
	

	<script type="text/javascript">
		$(document).ready(function() {

		});
		
		function irPagina(ruta){
			
			var formulario = document.getElementById("pagina");
			formulario.action=ruta;
			formulario.submit();
		}
		
	</script>
	
	<jsp:include page="../WEB-INF/template/footer.jsp" />
	
</body>
</html>