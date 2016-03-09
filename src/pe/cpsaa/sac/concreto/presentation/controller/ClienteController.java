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
import pe.cpsaa.sac.concreto.application.TablaGeneralApplication;
import pe.cpsaa.sac.concreto.domain.factory.UsuarioFactory;
import pe.cpsaa.sac.concreto.presentation.viewmodel.ClienteViewModel;
import pe.cpsaa.sac.concreto.presentation.viewmodel.TablaGeneralViewModel;
import pe.cpsaa.sac.concreto.util.Constantes;

import com.kendoui.spring.models.DataSourceResult;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteApplication clienteApplication;
	@Autowired
	TablaGeneralApplication tablaGeneralApplication;
	@Autowired
	UsuarioFactory usuarioFactory;
	
	
	
	DataSourceResult dataSourceResult;
	
	Logger logger = Logger.getLogger(ClienteController.class);

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String initLoteMolde(ModelMap model){
		
		return "cliente/administrarCliente";
	}
	
	@RequestMapping(value="/obtenerCliente",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerMixer(@RequestBody ClienteViewModel clienteViewModel){

		List<ClienteViewModel> listaViewModel= clienteApplication.obtenerCliente(clienteViewModel);

		dataSourceResult = new DataSourceResult();
		
		dataSourceResult.setData(listaViewModel);
		dataSourceResult.setTotal(Long.valueOf(listaViewModel.size()));
		
		return dataSourceResult;
	}
	
	
	@RequestMapping(value="/obtenerClientePorId",method=RequestMethod.POST)
	public @ResponseBody ClienteViewModel obtenerClientePorId(@RequestBody ClienteViewModel clienteViewModel){

		ClienteViewModel viewModel = null;
		viewModel = clienteApplication.obtenerClientePorId(clienteViewModel);

		return viewModel;
	}
	
	@RequestMapping(value="/registrarCliente",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> registrarCliente(@RequestBody ClienteViewModel clienteViewModel){
		
		Map<String, Object> response = null;
		try {
//			int var = 15/0;
			response = clienteApplication.registrarCliente(clienteViewModel);
			
			if(response == null){
				response = new HashMap<String, Object>();
				response.put("codigo", Constantes.TRANSACCION_EXITOSA);
			}
			
		} catch (Exception e) {
			response = new HashMap<String, Object>();
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al registrar el Cliente/Contratista.");
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/modificarCliente",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> modificarCliente(@RequestBody ClienteViewModel clienteViewModel){
		
		Map<String, Object> response = null;
		try {
			
			response = clienteApplication.modificarCliente(clienteViewModel);
			
			if(response == null){
				response = new HashMap<String, Object>();
				response.put("codigo", Constantes.TRANSACCION_EXITOSA);
			}
			
		} catch (Exception e) {
			response = new HashMap<String, Object>();
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al modificar el Cliente/Contratista.");
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/eliminarCliente",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> eliminarCliente(@RequestBody ClienteViewModel clienteViewModel){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			response = clienteApplication.eliminarCliente(clienteViewModel);
		} catch (Exception e) {			
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al eliminar el Cliente/Contratista.");
			e.printStackTrace();
		}
		
		return response;
	}

	
	@RequestMapping(value="/obtenerSexo",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerSexo(){
		
		List<TablaGeneralViewModel> tablaGeneralVM = tablaGeneralApplication.obtenerConstantesCombo(Constantes.TablaGeneral.SEXO);
		dataSourceResult = new DataSourceResult();
		dataSourceResult.setData(tablaGeneralVM);
		dataSourceResult.setTotal(Long.valueOf(tablaGeneralVM.size()));
		
		return dataSourceResult;
	}
	
	@RequestMapping(value="/obtenerEstadoCivil",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerEstadoCivil(){
		
		List<TablaGeneralViewModel> tablaGeneralVM = tablaGeneralApplication.obtenerConstantesCombo(Constantes.TablaGeneral.ESTADOCIVIL);
		dataSourceResult = new DataSourceResult();
		dataSourceResult.setData(tablaGeneralVM);
		dataSourceResult.setTotal(Long.valueOf(tablaGeneralVM.size()));
		
		return dataSourceResult;
	}
	
	@RequestMapping(value="/obtenerTipoCliente",method=RequestMethod.POST)
	public @ResponseBody DataSourceResult obtenerTipoCliente(){
		
		List<TablaGeneralViewModel> tablaGeneralVM = tablaGeneralApplication.obtenerConstantesCombo(Constantes.TablaGeneral.TIPOCLIENTE);
		dataSourceResult = new DataSourceResult();
		dataSourceResult.setData(tablaGeneralVM);
		dataSourceResult.setTotal(Long.valueOf(tablaGeneralVM.size()));
		
		return dataSourceResult;
	}
	
	
	
}
