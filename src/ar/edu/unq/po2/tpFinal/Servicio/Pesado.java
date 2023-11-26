package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Pesado implements Servicio{
	
	private Double costo = 200d;
	
	@Override
	public Double costoServicio(Orden orden) {
		return this.costo;
		
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
	
	
}
