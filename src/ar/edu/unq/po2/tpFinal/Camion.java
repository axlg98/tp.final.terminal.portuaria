package ar.edu.unq.po2.tpFinal;

public class Camion {

	private Chofer chofer;
	private Container container;

	//Crear un nuevo camion.
	public Camion(Chofer chofer, Container container) {
		super();
		this.chofer = chofer;
		this.container = container;
	}
	
	public void dejarCargaEnPuerto(Puerto unPuerto) {
		
		unPuerto.almacenarContainer(this);
		
	}

	/* GETTER´S Y SETTER´S*/

	public Chofer getChofer() {
		return chofer;
	}


	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}


	public Container getContainer() {
		return container;
	}


	public void setContainer(Container container) {
		this.container = container;
	}
	
}
