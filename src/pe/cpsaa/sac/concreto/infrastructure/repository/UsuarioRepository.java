package pe.cpsaa.sac.concreto.infrastructure.repository;

import org.springframework.stereotype.Repository;

import pe.cpsaa.sac.concreto.domain.model.Usuario;
import pe.cpsaa.sac.concreto.presentation.viewmodel.CredencialDto;

@Repository
public interface UsuarioRepository {
	
	Usuario obtenerAutenticacionUsuario(CredencialDto credencialDto);
	
}
