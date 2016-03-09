package pe.cpsaa.sac.concreto.domain.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.model.Usuario;
import pe.cpsaa.sac.concreto.domain.service.SeguridadService;
import pe.cpsaa.sac.concreto.domain.service.UsuarioService;
import pe.cpsaa.sac.concreto.infrastructure.repository.UsuarioRepository;
import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;
import pe.cpsaa.sac.concreto.util.Constantes;
import pe.cpsaa.sac.concreto.util.Util;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	SeguridadService seguridadService;
	
	@Override
	public Boolean autenticar(CredencialDto credencial) throws RemoteException, ServiceException {
		
		Boolean respuesta = false;
		
		String cadena = credencial.getUsuario();

		
		Usuario usuario  =  usuarioRepository.obtenerAutenticacionUsuario(credencial);
		
		
		if(usuario != null){
			Util.setObjetoSesion(Constantes.USUARIO_SESION, usuario);
			Util.setObjetoSesion(Constantes.FLAG_RECORDAR_USUARIO, credencial.isRecordarUsuario());
			if(credencial.isRecordarUsuario()){
				Util.setObjetoSesion(Constantes.USERNAME, credencial.getUsuario());
				Util.setObjetoSesion(Constantes.PASSWORD, credencial.getContrasenia());
			}
			respuesta = true;
		}
//		if(userWebService!=null){
//			usuario = new Usuario();
//			PuestoTrabajo puestoTrabajo = new PuestoTrabajo();
//			List<Empresa> listaEmpresas = new ArrayList<Empresa>();
//			List<Permiso> listaPermisos = new ArrayList<Permiso>();
//			
//			
//			usuario.setCodigo(userWebService.getLogin());
//			usuario.setNombre("Juan");
//			usuario.setApellidoPaterno("Reyes");
//			usuario.setEmail("jreyes@demo.com.pe");
////			
//			puestoTrabajo = puestoTrabajoRepository.obtenerPuestoTrabajoPorUsuario(usuario);
//			
//			listaEmpresas = empresaRepository.obtenerEmpresasPorPuestoTrabajo(puestoTrabajo);
//			listaPermisos = permisoRepository.obtenerPermisosPorPuestoTrabajo(puestoTrabajo);
//			
//			
//			usuario.setPuestoTrabajo(puestoTrabajo);
//			usuario.setListaEmpresas(listaEmpresas);
//			usuario.setListaPermisos(listaPermisos);
//			
//			//Ponemos el usuario en la sesion
//			Util.setObjetoSesion(Constantes.USUARIO_SESION, usuario);
//			Util.setObjetoSesion(Constantes.FLAG_RECORDAR_USUARIO, credencial.isRecordarUsuario());
//			if(credencial.isRecordarUsuario()){
//				Util.setObjetoSesion(Constantes.USERNAME, credencial.getUsuario());
//				Util.setObjetoSesion(Constantes.PASSWORD, credencial.getContrasenia());
//			}
//			
//			respuesta = true;
//		}
		
		return respuesta;
	}
	
	
	
}
