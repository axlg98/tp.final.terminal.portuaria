package ar.edu.unq.po2.tpFinal.Cliente;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Container.Container;

public class Shipper extends Cliente{

	private List<Mail> mails;
	
	public Shipper(Container carga) {
		super(carga);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public List<Mail> getMails() {
		return mails;
	}




	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}




	public void notificarBuqueA1km(Mail mail) {
		
		this.getMails().add(mail);
		
	}

	
	
}
