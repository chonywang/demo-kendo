package pe.cpsaa.sac.concreto.presentation.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import pe.cpsaa.sac.concreto.presentation.ws.bean.Producto;

@WebService(name = "Producto", targetNamespace = "http://sac.cpsaa.com.pe/Producto/")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface OperacionProducto {
	
	@WebMethod(operationName = "obtenerProducto", action = "http://sac.cpsaa.com.pe/Producto/obtenerProducto")
	@WebResult(name="ListaProducto", partName="ListaProducto")
	public Producto[] obtenerProducto(@WebParam(name = "IdCliente", partName = "IdCliente") String idCliente);
	

}
