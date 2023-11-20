package ar.edu.unq.po2.tpFinal;

public class Departing implements FaseBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		if (this.distanciaMayorA1KM(buque)) {
			
			buque.avisarPuerto(buque.getUnViaje().getPuertoOrigen());
			buque.setFase(new Outbound());
			
		}
		
		
	}

	private boolean distanciaMayorA1KM(Buque buque) {
		
		return GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) > 1;
		
	}
	
	
	
}
