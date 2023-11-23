package ar.edu.unq.po2.tpFinal;

public class Mail {

	private Buque buque;
	private String nombre;
	private String descripcion;
	
	
	
	
	public Mail(Buque buque, String nombre, String descripcion) {
		super();
		this.buque = buque;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	public Buque getBuque() {
		return buque;
	}
	public void setBuque(Buque buque) {
		this.buque = buque;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
	
	
}
