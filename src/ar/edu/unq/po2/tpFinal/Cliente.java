package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Cliente {
	
	private List<Orden> ordenes;
	
	
	public void agregarOrden(Orden orden) {
		
		this.ordenes.add(orden);
		
	}
	
	 
}
