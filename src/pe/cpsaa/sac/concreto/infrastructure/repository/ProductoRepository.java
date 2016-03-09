package pe.cpsaa.sac.concreto.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.cpsaa.sac.concreto.domain.model.Producto;

@Repository
public interface ProductoRepository {
	
	List<Producto> obtenerNombreProductosByLineaNegocio(Long id);
	Producto obtenerProductoByCodSap(String CodProducto);
	List<Producto> obtenerProductosByPlanta(Long idPlanta);
	List<Producto> obtenerProductosByProceso(Long idProceso);
	Producto obtenerFCProducto(Long idProducto);
	Producto obtenerDatosProductoCartaControl(Long idProducto);
	Producto obtenerProductoById(Producto producto);
	List<Producto> obtenerProducto(Producto producto);
	void registrarProducto(Producto producto);
	void modificarProducto(Producto producto);
	void eliminarProducto(Producto producto);
	List<Producto> obtenerProductoByCliente(Producto producto);

}
