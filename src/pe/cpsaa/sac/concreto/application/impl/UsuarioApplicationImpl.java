package pe.cpsaa.sac.concreto.application.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.application.UsuarioApplication;
import pe.cpsaa.sac.concreto.domain.service.UsuarioService;
import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;

@Component
public class UsuarioApplicationImpl implements UsuarioApplication{
	
	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public boolean autenticar(CredencialDto credencial) throws RemoteException, ServiceException {
		
		boolean esCredencialValida = false;
		
		esCredencialValida = usuarioService.autenticar(credencial);
		
		return esCredencialValida;
	}
	
}
