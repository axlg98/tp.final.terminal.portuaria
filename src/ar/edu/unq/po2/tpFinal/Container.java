package ar.edu.unq.po2.tpFinal;

public abstract class Container {

	public Container(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
