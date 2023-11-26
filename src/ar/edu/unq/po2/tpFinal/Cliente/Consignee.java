package ar.edu.unq.po2.tpFinal.Cliente;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Observador;
import ar.edu.unq.po2.tpFinal.Buque.Buque;

public class Consignee implements Observador {

	private List<Buque> buquesDeInteres;
	private Observador agenteExterno;
	private List<Mail> mails;
	
	public Consignee(Observador agenteExterno) {
		this.agenteExterno = agenteExterno;
		buquesDeInteres = new ArrayList<Buque>();
		mails = new ArrayList<Mail>();
	}
	
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
		this.mails.add(mail);
	
	}
	
	public void agregarBuqueDeIntere(Buque buqueDeInteres) {
		this.buquesDeInteres.add(buqueDeInteres);
	}
	
	@Override
	public void notificarBuqueA50Km(Mail mail) {
		
		if (buquesDeInteres.contains(mail.getBuque())) {
			this.agregarMail(mail);
		}
		
	}

	

	
	
}
