package pe.cpsaa.sac.concreto.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.factory.UsuarioFactory;
import pe.cpsaa.sac.concreto.domain.model.Cliente;
import pe.cpsaa.sac.concreto.domain.service.ClienteService;
import pe.cpsaa.sac.concreto.infrastructure.repository.ClienteRepository;
import pe.cpsaa.sac.concreto.util.Constantes;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	UsuarioFactory usuarioFactory;
	
	@Override
	public List<Cliente> obtenerCliente(Cliente cliente) {
		List<Cliente> listaCliente = null;
		listaCliente = clienteRepository.obtenerCliente(cliente);
		return listaCliente;
	}
	
	@Override
	public List<Cliente> obtenerClienteCombo() {
		List<Cliente> listaCliente = null;
		listaCliente = clienteRepository.obtenerClienteCombo();
		return listaCliente;
	}

	@Override
	public List<Cliente> obtenerContratistaObra(Map<String, Object> parametros) {
		List<Cliente> listaCliente = null;
		listaCliente = clienteRepository.obtenerContratistaObra(parametros);
		return listaCliente;
	}
	
	@Override
	public Cliente obtenerClientePorId(Cliente cliente) {
		Cliente model = null;
		model = clienteRepository.obtenerClientePorId(cliente);
		return model;
	}
	
	@Override
	public Map<String, Object> registrarCliente(Cliente cliente) throws Exception {
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		clienteRepository.registrarCliente(cliente);
		response.put("codigo", Constantes.TRANSACCION_EXITOSA);
		
		
		return response;
		
	}

	@Override
	public Map<String, Object> modificarCliente(Cliente cliente)
			throws Exception {
		Map<String, Object> response = null;
		//cliente.setUsuario(usuarioFactory.obtenerUsuarioSesion());
		clienteRepository.modificarCliente(cliente);
		return response;
	}

	@Override
	public Map<String, Object> eliminarCliente(Cliente cliente) throws Exception {
		Map<String, Object> response = null;
		
		clienteRepository.eliminarCliente(cliente);
		response = new HashMap<String,Object>();
		response.put("codigo", Constantes.TRANSACCION_EXITOSA);
		return response;
	}

	@Override
	public List<String> obtenerCodigoClienteComienzaCon(String valorInicio) throws Exception {
		return clienteRepository.obtenerCodigoClienteComienzaCon(valorInicio);
	}

	@Override
	public List<String> obtenerNombreClienteComienzaCon(String valorInicio) throws Exception {
		return clienteRepository.obtenerNombreClienteComienzaCon(valorInicio);
	}

	@Override
	public List<String> obtenerRucClienteComienzaCon(String valorInicio) throws Exception {
		return clienteRepository.obtenerRucClienteComienzaCon(valorInicio);
	}

	@Override
	public List<Cliente> obtenerContratistaPorCliente(Long idCliente) {		
		return clienteRepository.obtenerContratistaPorCliente(idCliente);
	}
	
}
