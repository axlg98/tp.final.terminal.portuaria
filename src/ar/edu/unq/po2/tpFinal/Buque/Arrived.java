package ar.edu.unq.po2.tpFinal.Buque;

public class Arrived implements FaseBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		// preguntar si puede descargar
		
		buque.setFase(new Working());
		
	}
	
	

	
	
}
