<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%> 

<!DOCTYPE html>
<html>
<head>
<title>Administrar Cliente</title>
<jsp:include page="../../WEB-INF/template/configuracionWeb.jsp" />
</head>
<body>
	
	<jsp:include page="../../WEB-INF/template/header.jsp" flush="true" />
	
	<div class="container">

		<div class="panel-body" align="center">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
			</div>
			
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
			</div>
		</div>

		<section class="panel panel-default">
			<div class="panel-heading">Administrar Cliente</div>
			<div class="panel-body">
			
				<div class="well" style="background-image: none !important">
                    <form class="form-horizontal" role="form">
                        <div class="row">
							<div class="col-md-11">
                        		<div class="row row-padding-bottom-all">
                        			<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
                        				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Tipo Cliente</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
<!-- 	                        				<input id="txtCodigo" type="text" class="k-textbox full-width" onkeypress="return validarEntero(event)"/> -->
	                        				
	                        				<kendo:dropDownList style="width:100%" name="cbxTipoCliente" optionLabel="Seleccione"
												autoBind="false" dataTextField="nombre"
												dataValueField="id">
												<kendo:dataSource>
												</kendo:dataSource>
											</kendo:dropDownList>
	                        				
	                        			</div>
                        			</div>
                        			<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 remove-padding-left-col-md">
	                        			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Sexo Cliente</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
<!-- 	                        				<input id="txtNombre" type="text" class="k-textbox full-width" onkeyup="aMayuscula(this)"/> -->
	                        				
	                        				<kendo:dropDownList style="width:100%" name="cbxSexo" optionLabel="Seleccione"
												autoBind="false" dataTextField="nombre"
												dataValueField="id">
												<kendo:dataSource>
												</kendo:dataSource>
											</kendo:dropDownList>
	                        				
	                        			</div>
	                        		</div>
                        			<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 remove-padding-left-col-md">
	                        			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Estado Civil</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
<!-- 	                        				<input id="txtRUC" type="text" class="k-textbox full-width" onkeypress="return validarEntero(event)"/> -->
	                        				
	                        				<kendo:dropDownList style="width:100%" name="cbxEstadoCivil" optionLabel="Seleccione"
												autoBind="false" dataTextField="nombre"
												dataValueField="id">
												<kendo:dataSource>
												</kendo:dataSource>
											</kendo:dropDownList>
	                        				
	                        			</div>
	                        		</div>
	                        		
	                        		<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 remove-padding-left-col-md">
	                        			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Correo</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
	                        				<input id="txtCorreo" type="text" class="k-input full-width" />
	                        			</div>
	                        		</div>
                        			
                        		</div> 
                        		<!-- Fin de Fila 1 -->
                        	</div>
                        	<div class="col-md-1 remove-padding-left-col-md">

                        			<div class="col-xs-12 col-sm-6 col-md-12 remove-padding-lateral-col-md">										
										<kendo:button name="btnBuscar" type="button" class="full-width"
											click="buscarCliente">
											<kendo:button-content>Buscar</kendo:button-content>
										</kendo:button>										
									</div>

                        			<div class="col-xs-12 col-sm-6 col-md-12 remove-padding-lateral-col-md padding-top-md-13">		                        		
										<kendo:button name="btnLimpiar" type="button" class="full-width"
											click="limpiarCamposBusqueda">
											<kendo:button-content>Limpiar</kendo:button-content>
										</kendo:button>
									</div>
<!--                         		</div> -->
                        	</div>          
						</div>                        
                    </form>
		        </div>

				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
						<div class="row">
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-right-col-md row-padding-bottom-all">
								<kendo:button name="btnRegistrar" type="button" class="full-width"
											click="registrarCliente"> 
									<kendo:button-content>Registrar</kendo:button-content>
								</kendo:button>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-right-col-md row-padding-bottom-all">
								<kendo:button name="btnModificar" type="button" class="full-width"
											click="modificarCliente"> 
									<kendo:button-content>Modificar</kendo:button-content>
								</kendo:button>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-right-col-md">
								<kendo:button name="btnEliminar" type="button" class="full-width"
											 click="eliminarCliente">
									<kendo:button-content>Eliminar</kendo:button-content>
								</kendo:button>
							</div>
						</div>
					</div>
				</div>
				
<!-- 				<div style="margin-bottom: 20px; overflow-x: scroll; overflow-y: hidden;" > -->
				
				<div class="row row-padding-bottom-all">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				
					<kendo:grid name="gridCliente" pageable="true" sortable="false" 
						scrollable="true" filterable="false" groupable="false">
						<kendo:dataSource pageSize="10" autoSync="false">
							<kendo:dataSource-schema data="data" total="total">
								<kendo:dataSource-schema-model id="idCliente">									
									<kendo:dataSource-schema-model-fields>					
										<kendo:dataSource-schema-model-field name="idCliente" type="string" />					
										<kendo:dataSource-schema-model-field name="nombreCliente" type="string" />
										<kendo:dataSource-schema-model-field name="apellidoCliente" type="string" />
										<kendo:dataSource-schema-model-field name="tipoCliente" type="string" />
										<kendo:dataSource-schema-model-field name="sexoCliente" type="string" />
										<kendo:dataSource-schema-model-field name="estadoCivilCliente" type="string" />
									</kendo:dataSource-schema-model-fields>
								</kendo:dataSource-schema-model>
							</kendo:dataSource-schema>
						</kendo:dataSource>

						<kendo:grid-columns>							
							<kendo:grid-column field="idCliente" title=" " template="<input name='radCliente' type='radio' class='radio'/>" width="3%" />
							<kendo:grid-column field="nombreCliente" title="Nombre" width="8%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'" />
							<kendo:grid-column field="apellidoCliente" title="Apellido" width="40%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'" />
							<kendo:grid-column field="correoCliente" title="Correo" width="40%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'" />
							<kendo:grid-column field="tipoCliente" title="Tipo Cliente" width="11%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'"/>
							<kendo:grid-column field="sexoCliente" title="Sexo" width="10%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'" />
							<kendo:grid-column field="estadoCivilCliente" title="Estado Civil" width="10%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'"/>
						</kendo:grid-columns>

					</kendo:grid>
<!-- 				</div> -->
					</div>
				</div>
			</div>
			<!-- Fin de cuerpo de panel -->
		</section>
		<!-- Fin de estructura panel -->
		
		
		<!-- Seccion de popups -->
		<jsp:include page="registrarCliente.jsp" flush="true" />
		<jsp:include page="modificarCliente.jsp" flush="true" />
		<%-- <jsp:include page="registrarCliente.jsp" flush="true" />
		<jsp:include page="modificarCliente.jsp" flush="true" /> --%>
	</div>
	<jsp:include page="../../WEB-INF/template/footer.jsp" />
	<script src="${pageContext.request.contextPath}/app/resources/js/cliente.js"></script>
</body>
</html>