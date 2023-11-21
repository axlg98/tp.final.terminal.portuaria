package ar.edu.unq.po2.tpFinal;

public class Inbound implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		if (this.estaEnElPuerto(buque)) {
			
			buque.setFase(new Arrived());
			
		}
		
		
	}

	private boolean estaEnElPuerto(Buque buque) {
		return this.distanciaigualACero(buque);
		//return buque.getPosicionActual() == buque.getPuertoDestino().getUbicacion();
		
	}
	
private boolean distanciaigualACero(Buque buque) {
		
		return GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) == 0;
		
	}
	
	
}
