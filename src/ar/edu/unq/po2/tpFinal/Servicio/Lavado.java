package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Lavado implements Servicio {
	
	public Lavado() {
		
	}

	@Override
	public Double costoServicio(Orden orden) {
		
		if (orden.getUnContainer().volumenDelContainer() > 70) {
			
			return 500d;
			
		}
		
		
		return 250d;
	}

	
	
}
