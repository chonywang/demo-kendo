package pe.cpsaa.sac.concreto.presentation.viewmodel;

public class ComboMaestroViewModel {

	private Long id;
	private String nombre;
	
	public ComboMaestroViewModel() {
		super();
	}
	
	public ComboMaestroViewModel(Long id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
}
