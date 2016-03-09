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
import org.springframework.web.servlet.ModelAndView;

import pe.cpsaa.sac.concreto.application.UsuarioApplication;
import pe.cpsaa.sac.concreto.domain.factory.UsuarioFactory;
import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;
import pe.cpsaa.sac.concreto.util.Constantes;
import pe.cpsaa.sac.concreto.util.Util;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UsuarioFactory usuarioFactory;
	@Autowired
	UsuarioApplication seguridadApplication;
	
	Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView inicio(ModelMap model){
		
		logger.info("Entro al metodo init de LoginController");
		
		//List<String> listaPermisos = obtenerListaPermisos();
//		listaPermisos.add("HU0001_PERM_001");
		
		model.addAttribute(Constantes.USUARIO_SESION, usuarioFactory.obtenerUsuarioSesion());
		//model.addAttribute("listaCodigosPermisos",listaPermisos);
		
		return new ModelAndView("principal",model); 
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView init(ModelMap model){
		
		logger.info("Entro al metodo init de LoginController");
		
		//List<String> listaPermisos = obtenerListaPermisos();
//		listaPermisos.add("HU0001_PERM_001");
		
		
		return new ModelAndView("principal",model);
	}
	
	@RequestMapping(value="/principal", method=RequestMethod.GET)
	public String principal(){
		
		logger.info("Entro al metodo bienvenida de LoginController");
		
		return "principal";
	}
	
	
	@RequestMapping(value="/cerrarSesion", method=RequestMethod.POST)
	public @ResponseBody Boolean cerrarSesion(){
		
		logger.info("Entro al metodo cerrar sesion de LoginController");
		
//		Util.setObjetoSesion(Constantes.USUARIO_SESION, null);
//		
//		Boolean flagRecordarUsuario = (Boolean)Util.getObjetoSesion(Constantes.FLAG_RECORDAR_USUARIO);
//		
//		if(flagRecordarUsuario!=null){			
//			if(!flagRecordarUsuario){
//				Util.setObjetoSesion(Constantes.USERNAME, null);
//				Util.setObjetoSesion(Constantes.PASSWORD, null);
//				Util.setObjetoSesion("tiempoActividadUltimo", null);
//				Util.setObjetoSesion(Constantes.Seguridad.MENSAJE_ES_SESION_EXPIRADA, null);
//			}			
//		}else{
//			Util.setObjetoSesion(Constantes.USERNAME, null);
//			Util.setObjetoSesion(Constantes.PASSWORD, null);
//			Util.setObjetoSesion("tiempoActividadUltimo", null);
//			Util.setObjetoSesion(Constantes.Seguridad.MENSAJE_ES_SESION_EXPIRADA, null);
//		}
		
		return true;
	}
		
	@RequestMapping(value="/validar", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> validarCredenciales(@RequestBody CredencialDto credencial) {

		logger.info("Entro al metodo ingresar de LoginController: " + credencial.getUsuario() + " / " + credencial.getContrasenia());
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		boolean esCredencialValida = false;
			
		try {
			esCredencialValida = seguridadApplication.autenticar(credencial);
			response.put("codigo", Constantes.TRANSACCION_EXITOSA);
			response.put("esCredencialValida", esCredencialValida);
		} catch (Exception e) {			
			response.put("codigo", Constantes.TRANSACCION_NO_EXITOSA);
			response.put("mensaje", "Error al validar las credenciales.");
			e.printStackTrace();
		} 
		
		return response;
	}
	
	
	
	
		
}
