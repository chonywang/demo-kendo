package pe.cpsaa.sac.concreto.domain.model;

public class TablaGeneral {

	private String id;
	private String nombre;
	
	public TablaGeneral() {
		super();
	}
	
	public TablaGeneral(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
