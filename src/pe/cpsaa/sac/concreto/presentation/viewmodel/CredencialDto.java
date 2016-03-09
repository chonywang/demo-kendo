package pe.cpsaa.sac.concreto.presentation.viewmodel;

public class CredencialDto {
	
	String usuario;
	String contrasenia;
	boolean recordarUsuario;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public boolean isRecordarUsuario() {
		return recordarUsuario;
	}
	public void setRecordarUsuario(boolean recordarUsuario) {
		this.recordarUsuario = recordarUsuario;
	}
	
}
