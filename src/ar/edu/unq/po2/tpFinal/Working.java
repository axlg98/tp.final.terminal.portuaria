package ar.edu.unq.po2.tpFinal;

public class Working implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		// preguntar si ya termino con los trabajos de descarga
		
		buque.setFase(new Departing());
		
	}

	
	
}
