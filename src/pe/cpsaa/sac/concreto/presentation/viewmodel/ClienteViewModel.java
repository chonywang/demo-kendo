package pe.cpsaa.sac.concreto.presentation.viewmodel;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import pe.cpsaa.sac.concreto.util.CustomDateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ClienteViewModel {
	
	private Integer idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String sexoCliente;
	private String tipoCliente;
	private String estadoCivilCliente;
	private String correoCliente;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getSexoCliente() {
		return sexoCliente;
	}
	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getEstadoCivilCliente() {
		return estadoCivilCliente;
	}
	public void setEstadoCivilCliente(String estadoCivilCliente) {
		this.estadoCivilCliente = estadoCivilCliente;
	}
	public String getCorreoCliente() {
		return correoCliente;
	}
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
	
		
}
