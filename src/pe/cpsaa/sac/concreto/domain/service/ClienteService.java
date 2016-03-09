package pe.cpsaa.sac.concreto.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.model.Cliente;

@Service
public interface ClienteService {
	
	List<Cliente> obtenerCliente(Cliente cliente);
	List<Cliente> obtenerClienteCombo();
	List<Cliente> obtenerContratistaObra(Map<String, Object> parametros);
	Cliente obtenerClientePorId(Cliente cliente);
	Map<String, Object> registrarCliente(Cliente cliente) throws Exception ;
	Map<String, Object> modificarCliente(Cliente cliente) throws Exception ;
	Map<String, Object> eliminarCliente(Cliente cliente) throws Exception ;
	List<String> obtenerCodigoClienteComienzaCon(String valorInicio) throws Exception;
	List<String> obtenerNombreClienteComienzaCon(String valorInicio) throws Exception;
	List<String> obtenerRucClienteComienzaCon(String valorInicio) throws Exception;
	List<Cliente> obtenerContratistaPorCliente(Long idCliente);
	
}
