package pe.cpsaa.sac.concreto.application;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.presentation.viewmodel.ClienteViewModel;

@Component
public interface ClienteApplication {
	
	List<ClienteViewModel> obtenerCliente(ClienteViewModel clienteViewModel);
	List<ClienteViewModel> obtenerClienteCombo();
	ClienteViewModel obtenerClientePorId(ClienteViewModel clienteViewModel);
	Map<String, Object> registrarCliente(ClienteViewModel clienteViewModel) throws Exception ;
	Map<String, Object> modificarCliente(ClienteViewModel clienteViewModel) throws Exception ;
	Map<String, Object> eliminarCliente(ClienteViewModel clienteViewModel) throws Exception ;
	List<String> obtenerCodigoClienteComienzaCon(String valorInicio) throws Exception;
	List<String> obtenerNombreClienteComienzaCon(String valorInicio) throws Exception;
	List<String> obtenerRucClienteComienzaCon(String valorInicio) throws Exception;
	List<ClienteViewModel> obtenerContratistaPorCliente(Long idCliente);
}
