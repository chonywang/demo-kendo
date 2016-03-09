package pe.cpsaa.sac.concreto.domain.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.cpsaa.sac.concreto.domain.model.Producto;
import pe.cpsaa.sac.concreto.domain.service.ProductoService;
import pe.cpsaa.sac.concreto.infrastructure.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto obtenerProductoById(Producto producto) {
		return productoRepository.obtenerProductoById(producto);
	}

	@Override
	public List<Producto> obtenerProducto(Producto producto) {
		return productoRepository.obtenerProducto(producto);
	}


	@Override
	public Map<String, Object> registrarProducto(Producto producto) throws Exception {
		Map<String, Object> response =null;
		productoRepository.registrarProducto(producto);
		return response;
		
	}

	@Override
	public Map<String, Object> modificarProducto(Producto producto)
			throws Exception {
		Map<String, Object> response =null;
		productoRepository.modificarProducto(producto);
		return response;
	}
	
	@Override
	public Map<String, Object> eliminarProducto(Producto producto)
			throws Exception {
		Map<String, Object> response =null;
		productoRepository.eliminarProducto(producto);
		return response;
	}

	@Override
	public List<Producto> obtenerProductoByCliente(Producto producto) {
		return productoRepository.obtenerProductoByCliente(producto);
	}

	
	
}
