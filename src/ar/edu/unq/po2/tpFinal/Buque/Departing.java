package ar.edu.unq.po2.tpFinal.Buque;

public class Departing implements FaseBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		
		if (this.distanciaMayorA1KM(buque)) {
			
			buque.avisarPuertoBuquqA1km(buque.getUnViaje().getPuertoOrigen());
			buque.setFase(new Outbound());
			
		}
		
		
	}

	private boolean distanciaMayorA1KM(Buque buque) {
		
		return GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) > 1;
		
	}
	
	
	
}
