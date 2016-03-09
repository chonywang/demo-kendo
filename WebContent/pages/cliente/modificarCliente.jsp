<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kendoui.com/jsp/tags" prefix="kendo"%>

<kendo:window name="ModificarCliente" title="Modificar Cliente" modal="true" 
					draggable="true" resizable="false" visible="false" width="720px">
	<kendo:window-content>
	<div class="container">
		
		<div class="row row-padding-bottom-all">
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 remove-padding-right-col-md">
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-4 remove-padding-lateral-col-md">Nombres</div>
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8 remove-padding-lateral-col-md">
					<input type="text" class="k-textbox full-width" name="txtNombreMod" id="txtNombreMod" />
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-4 remove-padding-lateral-col-md">Apellidos</div>
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8 remove-padding-lateral-col-md">
					<input type="text" class="k-textbox full-width" name="txtApellidoMod" id="txtApellidoMod" />
				</div>
			</div>
			
		</div>
		
		
		<div class="row row-padding-bottom-all">
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 remove-padding-right-col-md">
				<div class="col-xs-12 col-sm-5 col-md-4 col-lg-4 remove-padding-lateral-col-md">Tipo Cliente</div>
				<div class="col-xs-12 col-sm-7 col-md-8 col-lg-8 remove-padding-lateral-col-md">
					<kendo:dropDownList name="cbxTipoClienteMod" style="width:100%" 
						optionLabel="Seleccione" dataTextField="nombre" dataValueField="id">
						<kendo:dataSource>
						</kendo:dataSource>
					</kendo:dropDownList>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-4 remove-padding-left-col-md">Sexo</div>
					<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8 remove-padding-lateral-col-md">
						<kendo:dropDownList name="cbxSexoMod" style="width:100%" 
						optionLabel="Seleccione" dataTextField="nombre" dataValueField="id">
						<kendo:dataSource>
						</kendo:dataSource>
					</kendo:dropDownList>
					</div>
			</div>
		</div>
		
		<div class="row row-padding-bottom-all">
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 remove-padding-right-col-md">
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-4 remove-padding-lateral-col-md">Estado Civil</div>
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8 remove-padding-lateral-col-md">
					<kendo:dropDownList name="cbxEstadoCivilMod" style="width:100%" 
						optionLabel="Seleccione" dataTextField="nombre" dataValueField="id">
						<kendo:dataSource>
						</kendo:dataSource>
					</kendo:dropDownList>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-4 remove-padding-lateral-col-md">Correo</div>
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-8 remove-padding-lateral-col-md">
					<input type="text" class="k-textbox full-width" name="txtCorreoMod"  id="txtCorreoMod" maxlength="100"/>
				</div>
			</div>
		</div>
				
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="pull-right">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 remove-padding-right-col-md">
						<kendo:button name="btnAceptarModProducto" click="AceptarModificarCliente" class="full-width">Aceptar</kendo:button>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 remove-padding-right-col-md">
						<kendo:button name="btnCancelarModProducto" click="CancelarModificarCliente" class="full-width">Cancelar</kendo:button>
					</div>
				</div>
			</div>
		</div>
		
		
	</div>
</kendo:window-content>	
</kendo:window>