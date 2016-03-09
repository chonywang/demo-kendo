package pe.cpsaa.sac.concreto.domain.factory.impl;

import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.domain.factory.UsuarioFactory;
import pe.cpsaa.sac.concreto.domain.model.Usuario;
import pe.cpsaa.sac.concreto.util.Constantes;
import pe.cpsaa.sac.concreto.util.Util;

@Component
public class UsuarioFactoryImpl implements UsuarioFactory {
	
	@Override
	public Usuario obtenerUsuarioSesion() {
		
		return (Usuario) Util.getObjetoSesion(Constantes.USUARIO_SESION);
		
	}

	
	
}
