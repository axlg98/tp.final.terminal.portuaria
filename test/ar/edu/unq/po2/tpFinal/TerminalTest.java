package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Buque.Inbound;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Cliente.Consignee;
import ar.edu.unq.po2.tpFinal.Cliente.Mail;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.Container.ContainerDry;
import ar.edu.unq.po2.tpFinal.Container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.Container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta.EstrategiaMejorRuta;
import ar.edu.unq.po2.tpFinal.Naviera.Naviera;
import ar.edu.unq.po2.tpFinal.Orden.Orden;
import ar.edu.unq.po2.tpFinal.Servicio.AlmacenamientoExcedente;
import ar.edu.unq.po2.tpFinal.Servicio.Electricidad;
import ar.edu.unq.po2.tpFinal.Servicio.Pesado;
import ar.edu.unq.po2.tpFinal.Servicio.Servicio;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Terminal;

import org.junit.jupiter.api.Test;

class TerminalTest {
	
	Terminal terminal1;
	
	Puerto p;
	 Puerto puerto1;
	
	//Puerto Destino
	
	 Puerto chile;
	 Puerto mexico;
	
	 Container container1;
	 Container container2;
	//Container para Cliente
	 Container cargaCliente;
	 Container cargaCliente2;
	///////////////////////
	 Consignee consignee1;
	 Consignee consignee2;
	
	 Observador obsGeneral1;
	 Observador obsGeneral2;
	
	 Naviera empPortuaria1;
	 Naviera empPortuaria2;
	 Naviera empPortuaria3;
	 Naviera empPortuaria4;
	
	 EstrategiaMejorRuta mejorRuta;
	
	 Orden orden1;
	 Orden orden2;
	 Orden orden3;
	 Orden orden4;
	
	 Cliente cliente1; //por el newOrden
	 Cliente cliente2;
	 
	 Chofer chofer1;
	 Camion camion1;
	 Chofer chofer2;
	 Camion camion2;
	 
	 Circuito circuito;
	 
	 Tramo tramo1;
	 Tramo tramo2;
	 
	 Buque buque1;
	 Buque buqueC1;
	 Buque buqueC2;
	 
	 
	
	 Mail mail1;
	 Mail mail2;
	 Mail mail3;
	 
	 //Observador de Consignee
	 Observador agenteExterno;
	 /////////////////////////
	 
	@BeforeEach
	void setUp() {
		p = mock(Puerto.class);
		p.setUbicacion(new Point2D.Double(8.0,4.0));
		
		puerto1 = new Puerto("Buenos Aires");
		puerto1.setUbicacion(new Point2D.Double(12D,35.0));
		
		//PUERTO DESTINO
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(16.0,24.0));
		
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(18.0,24.0));
		/////////////////////////////
		List<Container> containers = new ArrayList<Container>();
		container1 = new ContainerTanque(20,40,60,80);
		container2 = new ContainerReefer(25,50,75,100,200D);	//modificar por new Container(...)
		containers.add(container1);
		containers.add(container2);
		puerto1.setContainers(containers);
		buque1 = new Buque("Buque 1");
		List<Mail> mails = new ArrayList<Mail>();
		mail1 = new Mail(buque1,"mail1", "Mi primer mail");
		mail2 = new Mail(buqueC1,"mail2", "Mi segundo mail");
		mail2 = new Mail(buqueC2,"mail3", "Mi tercer mail");
		mails.add(mail1);
		mails.add(mail2);
		mails.add(mail3);
		
		//Buque para Consignee
		List<Buque> buques = new ArrayList<Buque>();
		buqueC1 = new Buque("Primer Buque Consignee");
		buqueC2 = new Buque("Segundo Buque Consignee");
		buqueC1.setFase(new Inbound());
		buqueC2.setFase(new Inbound());
		buques.add(buqueC1);
		buques.add(buqueC2);
		/////////////////////////////////////
		
		List<Consignee> consignees = new ArrayList<Consignee>();
		consignee1 = mock(Consignee.class);
		consignee2 = mock(Consignee.class);
		consignees.add(consignee1);
		consignees.add(consignee2);
		puerto1.setConsignees(consignees);
		puerto1.setBuquesInbound(buques);
		consignee1.setMails(mails);
		consignee1.setBuquesDeInteres(buques);
		
		
		
		//Observer de Consingee
		consignee1.setAgenteExterno(agenteExterno);
		///////////////////////
		
		List<Observador> observers = new ArrayList<Observador>();
		obsGeneral1 = mock(Observador.class);
		obsGeneral2 = mock(Observador.class);
		observers.add(obsGeneral1);
		observers.add(obsGeneral2);
		puerto1.setObserversGenerales(observers);
		
		List<Naviera> empPortuarias = new ArrayList<Naviera>();
		empPortuaria1 = new Naviera();
		empPortuaria2 = new Naviera();
		empPortuarias.add(empPortuaria1);
		empPortuarias.add(empPortuaria2);
		puerto1.setEmpresasNavieras(empPortuarias);
		empPortuaria3 = new Naviera();
		empPortuaria4 = new Naviera();
		
		mejorRuta = mock(EstrategiaMejorRuta.class);
		
		cargaCliente = new ContainerDry(15,50,80,105);
		cargaCliente2 = mock(Container.class);
		
		cliente1 = new Cliente(cargaCliente);
		cliente2 = new Cliente(cargaCliente2);
		
		
		List<Chofer> choferes = new ArrayList<Chofer>();
		chofer1 = new Chofer("Chofer1");
		chofer2 = new Chofer("Chofer2");
		choferes.add(chofer1);
		choferes.add(chofer2);
		puerto1.setChoferesHabilitados(choferes);
		
		camion1 = new Camion(chofer1,container1);
		camion2 = new Camion(chofer2,container2);
		
		List<Orden> ordenes = new ArrayList<Orden>();
		orden1 = new Orden(container1,cliente1);
		orden2 = new Orden(container2,cliente2);
		orden3 = new Orden(container1,cliente2);
		orden4 = new Orden(container2,cliente1);
		ordenes.add(orden1);
		ordenes.add(orden2);
		puerto1.setOrdenes(ordenes);
		
		
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramo1 = new Tramo(puerto1,chile,45D,700D,LocalDateTime.now());
		tramo2 = new Tramo(chile,mexico,70D,500D,LocalDateTime.now());
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		circuito.setFechaYHoraDeSalida(LocalDateTime.now());
		
		terminal1 = new Terminal();
		
		List<Puerto> puertos = new ArrayList<Puerto>();
		puertos.add(p);
		puertos.add(puerto1);
		terminal1.setPuertos(puertos);	
	}

	@Test
	void validarEntregaTerrestreExpTest() throws Exception {
//		orden1.setCamionAsignado(camion1);
//		terminal1.validarEntregaTerrestreExp(orden1,camion1,chofer1);
	}
	
	@Test
	void cantidadDePuertoDeLaTerminalTest() {
		assertEquals(terminal1.getPuertos().size(),2);
	}
	
	//Esta un poco raro el resultado y no sé si es así exactamente, esto esta en Naviera.
	@Test
	void cantidadDeLoQueTardaUnaNavieraDeUnaTerminalAOtraTest() {
		empPortuaria1.agregarCircuito(circuito);
		assertEquals(empPortuaria1.cantidadDeLoQueTardaUnaNavieraDeTerminalATerminal(), 13.704699910719626);
	}

}
