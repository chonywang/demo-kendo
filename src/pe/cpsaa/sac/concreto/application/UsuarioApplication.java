package pe.cpsaa.sac.concreto.application;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;

@Component
public interface UsuarioApplication {

	boolean autenticar(CredencialDto credencial) throws ServiceException, RemoteException; 
	
}
