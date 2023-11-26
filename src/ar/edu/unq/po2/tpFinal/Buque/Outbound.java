package ar.edu.unq.po2.tpFinal.Buque;

public class Outbound implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		if (this.distanciaMenorA50(buque)) {
			
			buque.setFase(new Inbound());
			buque.getPuertoDestino().buqueAMenosDe50km(buque);
			buque.avisarPuerto(buque.getUnViaje().getPuertoDestino());
			
			
			
		}
		
		
	}

	
	private boolean distanciaMenorA50(Buque buque) {
		
		return GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) < 50;
		
	}
	
	
	
	
}
