package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Cliente {
	
	private List<Orden> ordenes;
	private Container carga;
	
	
	public void agregarOrden(Orden orden) {
		
		this.ordenes.add(orden);
		
	}
	
	//GET Y SET
	 
	public List<Orden> getOrdenes() {
		return ordenes;
	}


	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}


	public Container getCarga() {
		return carga;
	}


	public void setCarga(Container carga) {
		this.carga = carga;
	}
	
}
