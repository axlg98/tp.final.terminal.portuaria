package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;

public abstract class Orden {
	private Viaje unViaje;
	
	public void horaDeLlegadaCamion(LocalDate time,Camion camion,Chofer chofer) {
		
	}
	
	//SET Y GET
	
	public Viaje getViaje() {
		return unViaje;
	}
	
	public void setViaje(Viaje unViaje) {
		this.unViaje = unViaje;
	}
}
