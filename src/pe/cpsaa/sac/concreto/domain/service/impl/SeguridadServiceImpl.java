package pe.cpsaa.sac.concreto.domain.service.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.service.SeguridadService;
import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;
import pe.cpsaa.sac.concreto.util.Constantes;

@Service
public class SeguridadServiceImpl implements SeguridadService{

//	@Override
//	public User autenticar(CredencialDto credencial) throws ServiceException, RemoteException {
//		
//		User userEndPoint = null;
//		String urlWebServiceAutenticacion = Constantes.URL_WEB_SERVICE_AUTENTICACION;
//		
//		JaxRpcSecurityServiceLocator locator;
//		JaxRpcSecurity security;
//		
//		locator = new JaxRpcSecurityServiceLocator();		
//		locator.setSecurityService_address(urlWebServiceAutenticacion);
//		
//		security = locator.getSecurityService();
//		
//		userEndPoint = security.authenticate(credencial.getUsuario(), credencial.getContrasenia());
//		
//		return userEndPoint;
//		
//	}
	
}
