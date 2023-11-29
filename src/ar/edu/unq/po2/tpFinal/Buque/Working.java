package ar.edu.unq.po2.tpFinal.Buque;

public class Working implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		
		
		buque.setFase(new Departing());
		
		 
	}

	
	
}
