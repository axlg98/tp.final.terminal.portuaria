package ar.edu.unq.po2.tpFinal.Buque;

public class Arrived implements FaseBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		// preguntar si puede descargar
		
		if (buque.isPuedeDescargar()) {
			buque.setFase(new Working());
			 
		}
		
		
	}
	
	

	
	
}
