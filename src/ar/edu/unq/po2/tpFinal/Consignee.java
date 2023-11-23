package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Consignee implements Observador {

	private List<Buque> buquesDeInteres;
	private Observador agenteExterno;
	private List<Mail> mails;
	
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

	
	
	public List<Mail> getMails() {
		return mails;
	}

	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}

	
	public void agregarMail(Mail mail) {
		this.getMails().add(mail);
	}
	
	
	@Override
	public void notificarBuqueA50Km(Mail mail) {
		// TODO Auto-generated method stub
		
		if (buquesDeInteres.contains(mail.getBuque())) {
			this.agregarMail(mail);
		}
		
	}

	

	
	
}
