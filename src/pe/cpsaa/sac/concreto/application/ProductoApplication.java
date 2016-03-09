package pe.cpsaa.sac.concreto.application;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.presentation.viewmodel.ProductoViewModel;
import pe.cpsaa.sac.concreto.presentation.ws.bean.Producto;

@Component
public interface ProductoApplication {
	
	
	ProductoViewModel obtenerProductoById(ProductoViewModel productoViewModel);
	List<ProductoViewModel> obtenerProducto(ProductoViewModel productoViewModel);
	Map<String, Object> registrarProducto(ProductoViewModel productoViewModel) throws Exception;
	Map<String, Object> modificarProducto(ProductoViewModel productoViewModel) throws Exception;
	Map<String, Object> eliminarProducto(ProductoViewModel productoViewModel) throws Exception;
	List<Producto> obtenerProductoByCliente(Producto producto);
	
}
