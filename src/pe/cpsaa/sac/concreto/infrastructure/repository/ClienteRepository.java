package pe.cpsaa.sac.concreto.infrastructure.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.cpsaa.sac.concreto.domain.model.Cliente;

@Repository
public interface ClienteRepository {
	
	List<Cliente> obtenerCliente(Cliente cliente);
	List<Cliente> obtenerClienteCombo();
	List<Cliente> obtenerContratistaObra(Map<String, Object> parametros);
	Cliente obtenerClientePorId(Cliente cliente);
	void registrarCliente(Cliente cliente);
	void modificarCliente(Cliente cliente);
	void eliminarCliente(Cliente cliente);
	void registrarClienteSAP(Cliente cliente);
	void registrarContratistaSAP(Cliente cliente);
	Cliente obtenerClientePorCodSAP(String codigoSap);
	void modificarFlagCliente(Map<String, Object> param);
	void modificarFlagContratista(Map<String, Object> param);
	Cliente obtenerClientePorRuc(String ruc);
	List<String> obtenerCodigoClienteComienzaCon(String valorInicio);
	List<String> obtenerNombreClienteComienzaCon(String valorInicio);
	List<String> obtenerRucClienteComienzaCon(String valorInicio);
	Integer obtenerCantidadObrasDeClienteContratista(Long id);
	Integer obtenerCantidadLotesDeClienteContratista(Long id);
	List<Cliente> obtenerContratistaPorCliente(Long id);
}
