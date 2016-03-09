<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%> 

<!DOCTYPE html>
<html>
<head>
<title>Administrar Producto</title>
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
			<div class="panel-heading">Administrar Producto</div>
			<div class="panel-body">
			
				<div class="well" style="background-image: none !important">
                    <form class="form-horizontal" role="form">
                        <div class="row">
							<div class="col-md-11">
                        		<div class="row row-padding-bottom-all">
                        			<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
                        				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Cliente</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
											<kendo:dropDownList style="width:100%" name="cbxCliente" optionLabel="Seleccione"
												autoBind="false" dataTextField="nombreCliente"
												dataValueField="idCliente">
												<kendo:dataSource>
												</kendo:dataSource>
											</kendo:dropDownList>
	                        				
	                        			</div>
                        			</div>
                        			<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 remove-padding-left-col-md">
	                        			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Tipo Producto</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
											<kendo:dropDownList style="width:100%" name="cbxTipoProducto" optionLabel="Seleccione"
												autoBind="false" dataTextField="nombre"
												dataValueField="id">
												<kendo:dataSource>
												</kendo:dataSource>
											</kendo:dropDownList>
	                        				
	                        			</div>
	                        		</div>
	                        		
	                        		<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 remove-padding-left-col-md">
	                        			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-lateral-col-md">Nombre</div>
	                        			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 remove-padding-lateral-col-md">
	                        				<input id="txtNombre" type="text" class="k-input full-width" />
	                        			</div>
	                        		</div>
                        			
                        		</div> 
                        		<!-- Fin de Fila 1 -->
                        	</div>
                        	<div class="col-md-1 remove-padding-left-col-md">

                        			<div class="col-xs-12 col-sm-6 col-md-12 remove-padding-lateral-col-md">										
										<kendo:button name="btnBuscar" type="button" class="full-width"
											click="buscarProducto">
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
											click="registrarProducto"> 
									<kendo:button-content>Registrar</kendo:button-content>
								</kendo:button>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-right-col-md row-padding-bottom-all">
								<kendo:button name="btnModificar" type="button" class="full-width"
											click="modificarProducto"> 
									<kendo:button-content>Modificar</kendo:button-content>
								</kendo:button>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 remove-padding-right-col-md">
								<kendo:button name="btnEliminar" type="button" class="full-width"
											 click="eliminarProducto">
									<kendo:button-content>Eliminar</kendo:button-content>
								</kendo:button>
							</div> 
						</div>
					</div>
				</div>
				
<!-- 				<div style="margin-bottom: 20px; overflow-x: scroll; overflow-y: hidden;"> -->
				<div class="row row-padding-bottom-all">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

					<kendo:grid name="gridProducto" pageable="true" sortable="false" 
						scrollable="false" filterable="false" groupable="false">
						<kendo:dataSource pageSize="10" autoSync="false">
							<kendo:dataSource-schema data="data" total="total">
								<kendo:dataSource-schema-model id="idProducto">									
									<kendo:dataSource-schema-model-fields>										
										<kendo:dataSource-schema-model-field name="idProducto" type="number" />
										<kendo:dataSource-schema-model-field name="nombreCliente" type="number" />
										<kendo:dataSource-schema-model-field name="nombreProducto" type="string" />
										<kendo:dataSource-schema-model-field name="tipoProducto" type="string" />
										<kendo:dataSource-schema-model-field name="cantidadProducto" type="number" />
										<kendo:dataSource-schema-model-field name="precioProducto" type="number" />
									</kendo:dataSource-schema-model-fields>
								</kendo:dataSource-schema-model>
							</kendo:dataSource-schema>
						</kendo:dataSource>

						<kendo:grid-columns>							
							<kendo:grid-column field="idProducto" title=" " template="<input name='cxbProducto' type='radio' class='radio'/>" width="5%" />
							<kendo:grid-column field="nombreCliente" title="Nombre Cliente" width="10%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'" />
							<kendo:grid-column field="nombreProducto" title="Nombre Producto" width="15%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'" />
							<kendo:grid-column field="tipoProducto" title="Tipo Producto" width="10%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'"/>
							<kendo:grid-column field="cantidadProducto" title="Cantidad" width="10%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'"/>
							<kendo:grid-column field="precioProducto" title="Precio" width="10%" headerAttributes="style= 'white-space: pre-line;text-overflow: inherit'"/>
						</kendo:grid-columns>

					</kendo:grid>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="registrarProducto.jsp" flush="true" />
		<jsp:include page="modificarProducto.jsp" flush="true" />
	</div>
	<jsp:include page="../../WEB-INF/template/footer.jsp" />
	<script src="${pageContext.request.contextPath}/app/resources/js/producto.js"></script>
</body>
</html>