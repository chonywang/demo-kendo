package pe.cpsaa.sac.concreto.presentation.ws.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Producto", namespace ="http://sac.cpsaa.com.pe/Producto/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Producto", propOrder = {
    "idProducto",
    "idCliente",
    "nombreProducto",
	"cantidad",
    "precio"}
)
public class Producto {
	
	@XmlElement(name="IdProducto")
	private String idProducto;
	@XmlElement(name="IdCliente")
	private String idCliente;
	@XmlElement(name="NombreProducto")
	private String nombreProducto;
	@XmlElement(name="Cantidad")
	private String cantidad;
	@XmlElement(name="Precio")
	private String precio;
	
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
	
}
