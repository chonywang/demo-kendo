package pe.cpsaa.sac.concreto.application.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.application.ClienteApplication;
import pe.cpsaa.sac.concreto.domain.model.Cliente;
import pe.cpsaa.sac.concreto.domain.service.ClienteService;
import pe.cpsaa.sac.concreto.presentation.viewmodel.ClienteViewModel;
@Component
public class ClienteApplicationImpl implements ClienteApplication {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	Mapper mapper;

	@Override
	public List<ClienteViewModel> obtenerCliente(ClienteViewModel clienteViewModel) {
		List<Cliente> listacliente = null;
		List<ClienteViewModel> listaViewModel = null;
		
		Cliente cliente = mapper.map(clienteViewModel, Cliente.class);	
		
		listacliente = clienteService.obtenerCliente(cliente);
		listaViewModel = new ArrayList<ClienteViewModel>();			
		for (Cliente model : listacliente) {
			listaViewModel.add(mapper.map(model, ClienteViewModel.class));		
		}
		
		
		return listaViewModel;
	}
	
	@Override
	public List<ClienteViewModel> obtenerClienteCombo() {
		List<ClienteViewModel> listaViewModel = null;
		List<Cliente> listacliente = null;
		listacliente = clienteService.obtenerClienteCombo();
		listaViewModel = new ArrayList<ClienteViewModel>();			
		for (Cliente model : listacliente) {
			listaViewModel.add(mapper.map(model, ClienteViewModel.class));		
		}
		return listaViewModel;
	}

	@Override
	public ClienteViewModel obtenerClientePorId(ClienteViewModel clienteViewModel) {
		ClienteViewModel viewModel = null;
		Cliente model = null;
		
		Cliente cliente = new Cliente();
		cliente = mapper.map(clienteViewModel, Cliente.class);
		model = clienteService.obtenerClientePorId(cliente);
		viewModel = new ClienteViewModel();
		viewModel = mapper.map(model, ClienteViewModel.class);
		return viewModel;
	}
	
	@Override
	public Map<String, Object> registrarCliente(ClienteViewModel clienteViewModel) throws Exception {
		Map<String, Object> response = null;
		Cliente cliente = mapper.map(clienteViewModel, Cliente.class);	
		
		response = clienteService.registrarCliente(cliente);
		return response;
	}

	@Override
	public Map<String, Object> modificarCliente(
			ClienteViewModel clienteViewModel) throws Exception {
		Map<String, Object> response = null;
		Cliente cliente = mapper.map(clienteViewModel, Cliente.class);	
		
		response = clienteService.modificarCliente(cliente);
		return response;
	}

	@Override
	public Map<String, Object> eliminarCliente(ClienteViewModel clienteViewModel)
			throws Exception {
		Map<String, Object> response = null;
		Cliente cliente = mapper.map(clienteViewModel, Cliente.class);	
		
		response = clienteService.eliminarCliente(cliente);
		return response;
	}

	@Override
	public List<String> obtenerCodigoClienteComienzaCon(String valorInicio) throws Exception {
		return clienteService.obtenerCodigoClienteComienzaCon(valorInicio);
	}

	@Override
	public List<String> obtenerNombreClienteComienzaCon(String valorInicio) throws Exception {
		return clienteService.obtenerNombreClienteComienzaCon(valorInicio);
	}

	@Override
	public List<String> obtenerRucClienteComienzaCon(String valorInicio) throws Exception {
		return clienteService.obtenerRucClienteComienzaCon(valorInicio);
	}

	@Override
	public List<ClienteViewModel> obtenerContratistaPorCliente(Long idCliente) {
		
		List<ClienteViewModel> listaViewModel = null;
		List<Cliente> listacliente = null;
		listacliente = clienteService.obtenerContratistaPorCliente(idCliente);
		listaViewModel = new ArrayList<ClienteViewModel>();			
		for (Cliente model : listacliente) {
			listaViewModel.add(mapper.map(model, ClienteViewModel.class));		
		}
		return listaViewModel;
	}

}
