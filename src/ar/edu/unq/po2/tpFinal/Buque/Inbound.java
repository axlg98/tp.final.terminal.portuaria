package ar.edu.unq.po2.tpFinal.Buque;

public class Inbound implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		if (this.estaEnElPuerto(buque)) {
			
			buque.setFase(new Arrived());
			
		}
		
		
	}

	public boolean estaEnElPuerto(Buque buque) {
		return  GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) == 0;
		//return buque.getPosicionActual() == buque.getPuertoDestino().getUbicacion();
		
	}
	
//	public boolean distanciaigualACero(Buque buque) {
//		
//		return GPS.calcularDistancia(buque.getPosicionActual(), buque.getPuertoDestino().getUbicacion()) == 0;
//		
//	}
	
	
}
