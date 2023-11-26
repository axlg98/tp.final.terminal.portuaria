package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Lavado implements Servicio {
	

	@Override
	public Double costoServicio(Orden orden) {
		
		if (orden.getUnContainer().tamañoDelContainer() > 70) {
			
			return 500d;
			
		}
		
		
		return 250d;
	}

	
	
}
