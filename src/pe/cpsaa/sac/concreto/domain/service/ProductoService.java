package pe.cpsaa.sac.concreto.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.model.Producto;

@Service
public interface ProductoService {
	
	Producto obtenerProductoById(Producto producto);
	List<Producto> obtenerProducto(Producto producto);
	Map<String, Object> registrarProducto(Producto producto) throws Exception;
	Map<String, Object> modificarProducto(Producto producto) throws Exception;
	Map<String, Object> eliminarProducto(Producto producto) throws Exception;
	List<Producto> obtenerProductoByCliente(Producto producto);

}
