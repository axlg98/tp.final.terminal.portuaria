package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Pesado implements Servicio{
	
	public Pesado() {
		
	}
	
	@Override
	public Double costoServicio(Orden orden) {
		return 500D;
	}
}
