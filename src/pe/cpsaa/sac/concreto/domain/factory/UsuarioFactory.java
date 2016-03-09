package pe.cpsaa.sac.concreto.domain.factory;

import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.domain.model.Usuario;

@Component
public interface UsuarioFactory {
	
	Usuario obtenerUsuarioSesion();
	
}
