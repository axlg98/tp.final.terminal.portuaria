package ar.edu.unq.po2.tpFinal;

public class Outbound implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		
		if (this.distanciaMenorA50(buque) && this.estaEnElPuerto(buque)) {
			
			buque.setFase(new Inbound());
			buque.avisarPuerto(buque.getUnViaje().getPuertoDestino());
			
		}
		
		
	}

	
	public boolean distanciaMenorA50(Buque buque) {
		
		return GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) < 50;
		
	}
	
	
	public boolean estaEnElPuerto(Buque buque) {
		
		return buque.getPosicionActual() != buque.getPuertoDestino().getUbicacion();
		
	}
	
}
