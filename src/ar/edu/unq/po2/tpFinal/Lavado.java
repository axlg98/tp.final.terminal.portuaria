package ar.edu.unq.po2.tpFinal;

public class Lavado implements Servicio {

	@Override
	public Double costoServicio(Orden orden) {
		// TODO Auto-generated method stub
		
		if (orden.getUnContainer().volumenDelContainer() > 70) {
			
			return 500d;
			
		}
		
		
		return 250d;
	}

	
	
}
