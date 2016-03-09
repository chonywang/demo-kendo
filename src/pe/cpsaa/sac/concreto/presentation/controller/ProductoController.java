package pe.cpsaa.sac.concreto.presentation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.cpsaa.sac.concreto.application.ClienteApplication;
import pe.cpsaa.sac.concreto.application.ProductoApplication;
import pe.cpsaa.sac.concreto.application.TablaGeneralApplication;
import pe.cpsaa.sac.concreto.domain.factory.UsuarioFactory;
import pe.cpsaa.sac.concreto.presentation.viewmodel.ClienteViewModel;
import pe.cpsaa.sac.concreto.presentation.viewmodel.ProductoViewModel;
import pe.cpsaa.sac.concreto.presentation.viewmodel.TablaGeneralViewModel;
import pe.cpsaa.sac.concreto.util.Constantes;

import com.kendoui.spring.models.DataSourceResult;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ClienteApplication clienteApplication;
	@Autowired
	ProductoApplication productoApplication;
	@Autowired
	TablaGeneralApplication tablaGeneralApplication;
	@Autowired
	UsuarioFactory usuarioFactory;
	
	DataSourceResult dataSourceResult;
	
	Logger logger = Logger.getLogger(ProductoController.class);

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String initLoteMolde(ModelMap model){
		
		return "producto/administrarProducto";
	}
	
	@RequestMapping(value="/obtenerProducto",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerProducto(@RequestBody ProductoViewModel productoViewModel){

		List<ProductoViewModel> listaProducto= productoApplication.obtenerProducto(productoViewModel);

		dataSourceResult = new DataSourceResult();
		
		dataSourceResult.setData(listaProducto);
		dataSourceResult.setTotal(Long.valueOf(listaProducto.size()));
		
		return dataSourceResult;
	}
	
	@RequestMapping(value="/obtenerProductoPorId",method=RequestMethod.POST)
	public @ResponseBody ProductoViewModel obtenerProductoPorId(@RequestBody ProductoViewModel productoViewModel){

		ProductoViewModel viewModel = null;
		viewModel = productoApplication.obtenerProductoById(productoViewModel);

		return viewModel;
	}
	
	@RequestMapping(value="/registrarProducto",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> registrarProducto(@RequestBody ProductoViewModel productoViewModel){
		
		Map<String, Object> response = null;
		try {
			response = productoApplication.registrarProducto(productoViewModel);
			if(response == null){
				response = new HashMap<String, Object>();
				response.put("codigo", Constantes.TRANSACCION_EXITOSA);
				response.put("mensaje", "El Producto fue registrada de forma satisfactoria.");
			}
			
		} catch (Exception e) {
			response = new HashMap<String, Object>();
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al registrar el Producto.");
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/modificarProducto",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> modificarProducto(@RequestBody ProductoViewModel productoViewModel){
		
		Map<String, Object> response = null;
		try {
			response = productoApplication.modificarProducto(productoViewModel);
			if(response == null){
				response = new HashMap<String, Object>();
				response.put("codigo", Constantes.TRANSACCION_EXITOSA);
				response.put("mensaje", "El Producto fue registrada de forma satisfactoria.");
			}
			
		} catch (Exception e) {
			response = new HashMap<String, Object>();
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al modificar el Producto.");
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/eliminarProducto",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> eliminarProducto(@RequestBody ProductoViewModel productoViewModel){
		
		Map<String, Object> response = null;
		try {
			response = productoApplication.eliminarProducto(productoViewModel);
			if(response == null){
				response = new HashMap<String, Object>();
				response.put("codigo", Constantes.TRANSACCION_EXITOSA);
			}
			
		} catch (Exception e) {
			response = new HashMap<String, Object>();
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al eliminar la Obra.");
			e.printStackTrace();
		}
		return response;
	}
		
	@RequestMapping(value="/obtenerTipoProducto",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerTipoProducto(){
		List<TablaGeneralViewModel> lista = null;
		lista = tablaGeneralApplication.obtenerConstantesCombo(Constantes.TablaGeneral.TIPOPRODUCTO);
		
		dataSourceResult = new DataSourceResult();
		
		dataSourceResult.setData(lista);
		dataSourceResult.setTotal(Long.valueOf(lista.size()));
		
		return dataSourceResult;
	}
	
	@RequestMapping(value="/obtenerClientes",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerClientes(){
		List<ClienteViewModel> lista = null;
		lista = clienteApplication.obtenerClienteCombo();
		
		dataSourceResult = new DataSourceResult();
		
		dataSourceResult.setData(lista);
		dataSourceResult.setTotal(Long.valueOf(lista.size()));
		
		return dataSourceResult;
	}
	
}
