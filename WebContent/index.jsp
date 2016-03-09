<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<title>SAC Concreto</title>
	
	<jsp:include page="WEB-INF/template/header.jsp" flush="true" />
	
</head>
<body>
	
	<div class="container">
		<h4>Pagina Inicio Sistema SAC</h4>
		
		<br />
		<br />
		<form id="pagina" method="POST">
			<a href="#" onclick="irPagina('app/loteConcreto')">Administrar Lote Concreto Page</a>
			<br />
			<a href="#" onclick="irPagina('app/muestraIndividualConcreto')">Administrar Muestra Individual Page</a>
			<br />
			<a href="#" onclick="irPagina('app/muestraAleatoriaConcreto')">Administrar Muestra Aleatoria Page</a>
			<br />
			<a href="#" onclick="irPagina('app/ingresoCuradoConcreto')">Administrar Ingreso a Curado Page</a>
			<br />
			<a href="#" onclick="irPagina('app/ensayoEndurecido')">Administrar Ensayo Endurecido Page</a>
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

</body>
</html>