package pe.cpsaa.sac.concreto.domain.service;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;

@Service
public interface UsuarioService {

	Boolean autenticar(CredencialDto credencial) throws ServiceException, RemoteException;
	
}
