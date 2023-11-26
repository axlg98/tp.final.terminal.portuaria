package ar.edu.unq.po2.tpFinal;

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
