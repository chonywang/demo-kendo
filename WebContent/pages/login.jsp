

<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%> 
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html style="height: 100%;">
<head>
	<title>DEMO :: SISTEMA</title>
	<jsp:include page="../WEB-INF/template/configuracionWeb.jsp" flush="true" />
	<style type="text/css">
		.centradoAbsoluto {
			bottom: 0;
		    left: 0;
		    margin: auto !important;		   
		    position: relative;
		    right: 0;
		    top: 0;
		}
		.anchoMaximo-550{
			max-width: 550px;
		}
	</style>
</head>
<body style="height: 100%;" class="fondoPaginaLogin">	
	
	
	<div class="container" style="height: 100%;">
		
		
		<div id="loginContainer">
			<div id="sectionLogin" class="centradoAbsoluto anchoMaximo-550">
				<section class="panel panel-default">
					<div class="panel-heading letraRojaNegritaPacasmayo" align="center" style="font-size: 20px;">Sistema DEMO</div>
					<div class="panel-body" style="padding: 3px;">
						<%-- <div style="padding-bottom:3px;">
							<img src="${pageContext.request.contextPath}/app/resources/images/barraPacasmayo.png" class="img-responsive" />
						</div>
						<div style="padding-bottom:3px;">
							<img src="${pageContext.request.contextPath}/app/resources/images/fotoLogin.jpg" class="img-responsive" />
						</div> --%>
						<div class="container" style="background-color: #FFB400">
							<%-- <input type="hidden" name="flagRecordarUsuario" id="flagRecordarUsuario" value="${flagRecordarUsuario}" />
							<input type="hidden" name="mensajeInformacionLogin" id="mensajeInformacionLogin" value="${mensajeInformacionLogin}" />
							 --%>
							<form:form id="formLogin" method="POST">
								
								<div class="row row-padding-bottom-all letraRojaNegritaPacasmayo" style="padding-left:2px;">
									Ingresar al Sistema:
								</div>
								
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"></div>
									<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
										<div class="row row-padding-bottom-all">
											<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 letraRojaNegritaPacasmayo">Usuario:</div>
											<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
												<input id="txtUsuario" type="text" class="k-textbox full-width" value="${username}" onkeypress="return keyPressUsuario(event);">
											</div>						
										</div>
										<div class="row row-padding-bottom-all">
											<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 letraRojaNegritaPacasmayo">Contrase&ntilde;a:</div>
											<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
												<input id="txtContrasenia" type="password" class="k-textbox full-width" value="${password}" onkeypress="return keyPressContrasenia(event)">
											</div>						
										</div>
										
										<div class="row row-padding-bottom-all">
											<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 remove-padding-left-col-md pull-right">
												<kendo:button name="btnLimpiar" type="button" class="full-width" click="limpiarCampos">Limpiar</kendo:button>
											</div>
											<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 remove-padding-left-col-md pull-right">
												<kendo:button name="btnIngresar" type="button" class="full-width" click="ingresarAlSistema">Ingresar</kendo:button>
											</div>									
										</div>
										<!-- <div class="row row-padding-bottom-all">									
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center">
												<input id="ckbRecordarUsuario" type="checkbox" /> Recordar usuario
											</div>															
										</div> -->
									</div>
									<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"></div>
								</div>
							</form:form>				
						</div>
					</div>
				</section>
			</div>
			
		</div>
		
	</div>
	
	<script type="text/javascript">
	//<C[DATA[
	
		$(document).ready(function() {
			
			//Ponemos el foco en el usuario al iniciar la pagina
			$('#txtUsuario').focus();
			
			//Segun el flag en sesion marcamos el checkBox
			/* if($('#flagRecordarUsuario').val() == 'true'){
				$('#ckbRecordarUsuario').prop('checked',$('#flagRecordarUsuario').val())
			}else{
				$('#ckbRecordarUsuario').removeAttr('checked');
			}
			
			
			if($('#mensajeInformacionLogin').val() != ''){
				abrirPopupAccionRealizada('Mensaje', $('#mensajeInformacionLogin').val());
			} */
			
			
			$(window).resize(function(){
		          // aqui le pasamos la clase o id de nuestro div a centrar (en este caso "caja")
		          $('#loginContainer').css({
		               position:'relative',
		               top: ($(window).height() - $('#loginContainer').outerHeight())/2,
		               width: '100%'
		          });
		    });
			// Ejecutamos la funcion
			$(window).resize();
			
			
			
		});
		
		
		
		//--------------------Esto es temporal
// 		function cargarUsuarioLanda(){
// 			$('#txtUsuario').val('mlanda@cpsaa.com.pe');
// 			$('#txtContrasenia').val('surf2007');
// 		}
// 		function cargarUsuarioGastanaudi(){
// 			$('#txtUsuario').val('fgastanaudi@dino.com.pe');
// 			$('#txtContrasenia').val('12345678');
// 		}
		//--------------------
		
		function keyPressUsuario(e){
			
			var code = e.keyCode || e.which;
			
			if (code == 13) {
				$('#txtContrasenia').focus();
		    }
			
			return true;
			
		}
		
		function keyPressContrasenia(e){
			
			var code = e.keyCode || e.which;
			
			if (code == 13) {				
// 				if(validarIngresoCampos()){
					ingresarAlSistema();
// 				}				
		    }
			
			return true;
			
		}
		
		function validarIngresoCampos(){
			
// 			if( $.trim($('#txtContrasenia').val())!='' && $.trim($('#txtUsuario').val())!='' ){
				
// 			}
			
			if($.trim($('#txtUsuario').val())=='') {
// 				alert(USU001_ERR_006);
				$('#txtUsuario').focus();
				return false;
			}else if($.trim($('#txtContrasenia').val())=='') {
// 				alert(USU001_ERR_005);
				$('#txtContrasenia').focus();
				return false;
			} 
			return true;
			
		}
		
		function ingresarAlSistema(){
			
			if(validarIngresoCampos()){
				
				var usuario = $('#txtUsuario').val();
				var contrasenia = $('#txtContrasenia').val();
				var recordarUsuario = $('#ckbRecordarUsuario').prop('checked');
				
				var response = validarCredenciales(usuario, contrasenia, recordarUsuario);
				
				if(response!=null){
					if(response.codigo==0){
						abrirPopupAccionRealizada('Mensaje',response.mensaje);
					}else if(response.codigo==1){
						
						if(response.esCredencialValida){
			 				var formulario = document.getElementById("formLogin");				
			 				formulario.action= "app/login";
			 				formulario.submit();
						}else{
							abrirPopupAccionRealizada('Mensaje','Ud. no esta autorizado para ingresar al sistema. Consulte con el administrador.');
						}
					}	
				}
				
			}else {
				abrirPopupAccionRealizada('Mensaje','Los campos Usuario y Contrase\u00f1a son mandatorios.');
			}
			
		}
		
		function validarCredenciales(usuario, contrasenia, recordarUsuario){
			
			var resultado = null;
			
// 			console.log(recordarUsuario);
			
			var credencial = {
				usuario : usuario,
				contrasenia : contrasenia,
				recordarUsuario : recordarUsuario
			}
			
// 			console.log(JSON.stringify(credencial));
			
			$.ajax({
				url : 'app/login/validar',
				type : "POST",
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(credencial),
				async : false, 
				cache : false,  
				processData : false,
				success : function(response) {
					resultado = response;
				}
			});
			
// 			console.log('Credencial valida: ' + resultado);
			
			return resultado;
		}
		
		function limpiarCampos(){
			$('#txtUsuario').val('');
			$('#txtContrasenia').val('');
			$('#ckxRecordarUsuario').attr('checked',false);
			$('#txtUsuario').focus();
		}
		
		// Cambiar Kendo Theme
// 		function changeTheme(skinName, animate) {
// 		    var doc = document,
// 		        kendoLinks = $("link[href*='kendo.']", doc.getElementsByTagName("head")[0]),
// 		        commonLink = kendoLinks.filter("[href*='kendo.common']"),
// 		        skinLink = kendoLinks.filter(":not([href*='kendo.common'])"),
// 		        href = location.href,
// 		        skinRegex = /kendo\.\w+(\.min)?\.css/i,
// 		        extension = skinLink.attr("rel") === "stylesheet" ? ".css" : ".less",
// 		        url = commonLink.attr("href").replace(skinRegex, "kendo." + skinName + "$1" + extension),
// 		        exampleElement = $("#example");
		    
// 		    function preloadStylesheet(file, callback) {
// 		        var element = $("<link rel='stylesheet' media='print' href='" + file + "'").appendTo("head");
		        
// 		        setTimeout(function () {
// 		            callback();
// 		            element.remove();
// 		        }, 100);
// 		    }

// 		    function replaceTheme() {
// 		        var oldSkinName = $(doc).data("kendoSkin"),
// 		            newLink;

// 		        if ($.browser.msie) {
// 		            newLink = doc.createStyleSheet(url);
// 		        } else {
// 		            newLink = skinLink.eq(0).clone().attr("href", url);
// 		        }

// 		        newLink.insertBefore(skinLink[0]);
// 		        skinLink.remove();

// 		        $(doc.documentElement).removeClass("k-" + oldSkinName).addClass("k-" + skinName);
// 		    }

// 		    if (animate) {
// 		        preloadStylesheet(url, replaceTheme);
// 		    } else {
// 		        replaceTheme();
// 		    }
// 		};
		
	//]]>
	</script>
	
</body>
</html>