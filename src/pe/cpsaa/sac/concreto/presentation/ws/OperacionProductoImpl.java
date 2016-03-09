package pe.cpsaa.sac.concreto.presentation.ws;

import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.cpsaa.sac.concreto.application.ProductoApplication;
import pe.cpsaa.sac.concreto.presentation.ws.bean.Producto;

@WebService(
		endpointInterface = "pe.cpsaa.sac.concreto.presentation.ws.OperacionProducto",
		name = "Producto",
		portName = "ProductoPort",
		serviceName = "Producto",
		targetNamespace = "http://sac.cpsaa.com.pe/Producto/",
		wsdlLocation = "WEB-INF/wsdl/Producto.wsdl"
	)
public class OperacionProductoImpl implements OperacionProducto{

	protected static Logger logger = Logger.getLogger(OperacionProductoImpl.class);

	@Autowired
	private ProductoApplication productoApplication;

	@Override
	public Producto[] obtenerProducto(String idCliente) {
		Long id = new Long(idCliente);
		
		Producto productoVM = new Producto();
		productoVM.setIdCliente(idCliente);
		List<Producto> producto = productoApplication.obtenerProductoByCliente(productoVM);
		return producto.toArray(new Producto[producto.size()]);
	}
	
}
