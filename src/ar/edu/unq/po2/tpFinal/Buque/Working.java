package ar.edu.unq.po2.tpFinal.Buque;

public class Working implements FaseBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		// TODO Auto-generated method stub
		
		
		buque.setFase(new Departing());
		buque.getPuertoDestino().buquePartiendoA1Km(buque);
		buque.avisarPuertoBuqueA50km(buque.getUnViaje().getPuertoDestino());
		 
	} 

	
	
}
