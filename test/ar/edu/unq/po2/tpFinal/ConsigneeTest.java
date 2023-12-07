package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Cliente.Consignee;
import ar.edu.unq.po2.tpFinal.Cliente.Mail;

class ConsigneeTest {

	Consignee consignee;
	
	Observador agenteExterno;
	Observador agenteExterno2;
	
	Mail mail1;
	Mail mail2;
	Mail mail3;
	
	//Buque de Mail
	Buque buque1;
	Buque buque2;
	Buque buque3;
	////////////////////////////
	
	
	//Buque de interes de consignee
	Buque buqueInt1;
	Buque buqueInt2;
	Buque buqueInt3;
	Buque buqueInt4;
	Buque buqueInt5;
	Buque buqueInt6;
	////////////////////////////
	
	@BeforeEach
	void setUp(){
		buque1 = new Buque("Buque1");
		buque2 = new Buque("Buque2");
		buque3 = new Buque("Buque3");
		
		agenteExterno = mock(Observador.class);
		agenteExterno2 = mock(Observador.class);
		consignee = new Consignee(agenteExterno);

		List<Buque> buquesInts = new ArrayList<Buque>();
		buqueInt1 = new Buque("BuqueInt1");
		buqueInt2 = new Buque("BuqueInt2");
		buqueInt3 = new Buque("BuqueInt3");
		buqueInt4 = new Buque("BuqueInt4");
		buqueInt5 = new Buque("BuqueInt5");
		buqueInt6 = new Buque("BuqueInt6");
		buquesInts.add(buqueInt1);
		buquesInts.add(buqueInt2);
		buquesInts.add(buqueInt3);
		consignee.setBuquesDeInteres(buquesInts);
		
		List<Mail> mails = new ArrayList<Mail>();
		mail1 = new Mail(buque1,"Mail1", "Mi primer mail");
		mail2 = new Mail(buque2,"Mail2", "Mi segundo mail");
		mail3 = new Mail(buqueInt3,"Mail3", "Mi tercer mail");
		mails.add(mail1);
		mails.add(mail2);
		consignee.setMails(mails);
		
	}
	
	
	@Test
	void notificarBuqueA50KMTest() {
		consignee.notificarBuqueA50Km(mail3);
		assertEquals(consignee.getMails().size(),3);
	}
	
	@Test
	void cambioDeAgenteExternoTest() {
		consignee.setAgenteExterno(agenteExterno2);
		assertEquals(consignee.getAgenteExterno(), agenteExterno2);
	}
	
	@Test
	void cantidadDeBuquesDeInteresDeConsigneeTest() {
		assertEquals(consignee.getBuquesDeInteres().size(),3);
	}
	
	@Test
	void cantidadDeBuquesDeInteresEnTotalConLosAgregadosAlConsigneeTest() {
		consignee.agregarBuqueDeIntere(buqueInt4);
		consignee.agregarBuqueDeIntere(buqueInt5);
		consignee.agregarBuqueDeIntere(buqueInt6);
		assertEquals(consignee.getBuquesDeInteres().size(),6);
	}
	
	@Test
	void cantidadDeMailsConElMailAgregadoEnElConsigneeTest() {
		consignee.agregarMail(mail3);
		assertEquals(consignee.getMails().size(),3);
	}
	
	@Test
	void cambioDeNombreDelMailTest() {
		mail1.setNombre("Nuevo Nombre");
		assertEquals(mail1.getNombre(),"Nuevo Nombre");
	}
	
	@Test
	void modificandoNombreDescripcionYBuqueDeUnMailDelConsigneeDeNuevoTest() {
		mail3.setBuque(buque2);
		assertEquals(mail3.getBuque(),buque2);
		mail3.setDescripcion("Nueva Descripcion del buque 3");
		assertEquals(mail3.getDescripcion(),"Nueva Descripcion del buque 3");
		mail3.setNombre(mail2.getNombre());
		assertEquals(mail3.getNombre(),"Mail2");
		consignee.agregarMail(mail3);
		assertEquals(consignee.getMails().size(),3);
	}
}
