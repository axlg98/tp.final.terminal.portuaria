package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Consignee implements Observador {

	private List<Buque> buquesDeInteres;
	private Observador agenteExterno;
	
	
	public List<Buque> getBuquesDeInteres() {
		return buquesDeInteres;
	}

	public void setBuquesDeInteres(List<Buque> buquesDeInteres) {
		this.buquesDeInteres = buquesDeInteres;
	}

	public Observador getAgenteExterno() {
		return agenteExterno;
	}


	public void setAgenteExterno(Observador agenteExterno) {
		this.agenteExterno = agenteExterno;
	}



	@Override
	public void notificarBuqueA50Km(Buque buque) {
		// TODO Auto-generated method stub
		
		if (buquesDeInteres.contains(buque)) {
			agenteExterno.notificarBuqueA50Km(buque);
		}
		
	}

	
	
}
