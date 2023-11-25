package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuertoTest {
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
	
	 EmpresaPortuaria empPortuaria1;
	 EmpresaPortuaria empPortuaria2;
	 EmpresaPortuaria empPortuaria3;
	 EmpresaPortuaria empPortuaria4;
	
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
	 Buque buque2;
	 Buque buque3;
	
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
		container1 = mock(Container.class); //modificar por new Container(...)
		container2 = mock(Container.class);	//modificar por new Container(...)
		containers.add(container1);
		containers.add(container2);
		puerto1.setContainers(containers);
		
		List<Consignee> consignees = new ArrayList<Consignee>();
		consignee1 = mock(Consignee.class);
		consignee2 = mock(Consignee.class);
		consignees.add(consignee1);
		consignees.add(consignee2);
		puerto1.setConsignees(consignees);
		
		List<Observador> observers = new ArrayList<Observador>();
		obsGeneral1 = mock(Observador.class);
		obsGeneral2 = mock(Observador.class);
		observers.add(obsGeneral1);
		observers.add(obsGeneral2);
		puerto1.setObserversGenerales(observers);
		
		List<EmpresaPortuaria> empPortuarias = new ArrayList<EmpresaPortuaria>();
		empPortuaria1 = new EmpresaPortuaria();
		empPortuaria2 = new EmpresaPortuaria();
		empPortuarias.add(empPortuaria1);
		empPortuarias.add(empPortuaria2);
		puerto1.setEmpresasNavieras(empPortuarias);
		empPortuaria3 = new EmpresaPortuaria();
		empPortuaria4 = new EmpresaPortuaria();
		
		mejorRuta = mock(EstrategiaMejorRuta.class); //Ver si es con mock.
		
		cargaCliente = mock(Container.class);
		cargaCliente2 = mock(Container.class);
		
		cliente1 = new Cliente(cargaCliente);
		cliente2 = new Cliente(cargaCliente2);
		
		List<Orden> ordenes = new ArrayList<Orden>();
		orden1 = new Orden(container1,cliente1);
		orden2 = new Orden(container2,cliente2);
		orden3 = new Orden(container1,cliente2);
		orden4 = new Orden(container2,cliente1);
		ordenes.add(orden1);
		ordenes.add(orden2);
		puerto1.setOrdenes(ordenes);
		
		List<Chofer> choferes = new ArrayList<Chofer>();
		chofer1 = new Chofer("Chofer1");
		chofer2 = new Chofer("Chofer2");
		choferes.add(chofer1);
		choferes.add(chofer2);
		puerto1.setChoferesHabilitados(choferes);
		
		camion1 = new Camion(chofer1,container2);
		camion2 = new Camion(chofer2,container1);
		
		buque1 = new Buque("Buque 1");
		
//		tramo1 = new Tramo(p, puerto1, 20d, 500d, LocalDateTime.now());
//		tramo2 = new Tramo(chile, mexico, 20d, 500d, LocalDateTime.now());
//		
//		List<Tramo> tramos = new ArrayList<Tramo>();
//		tramos.add(tramo1);
//		tramos.add(tramo2);
//		circuito = new Circuito(1, tramos, LocalDateTime.now());
	}
	
	@Test
	void cantidadDeOrdenesTest() {
//		puerto1.setMejorRuta(mejorRuta);
//		puerto1.crearOrdenExportacion(cliente1,container1,chile,camion1);
		assertEquals(puerto1.getOrdenes().size(),2);
	}
	
	@Test
	void cantidadDeNavierasAgregadasTest() {
		puerto1.agregarNaviera(empPortuaria3);
		puerto1.agregarNaviera(empPortuaria4);
		assertEquals(puerto1.getEmpresasNavieras().size(),4);
	}
	
	@Test
	void cantidadDeContainerDelCamionHabilitadoTest() {
		puerto1.almacenarContainer(camion1);
		assertEquals(puerto1.getContainers().size(),3);
	}
	
	@Test
	void agregarContainerTestYCantidad() {
		puerto1.agregarContainer(cargaCliente);
		puerto1.agregarContainer(cargaCliente2);
		assertEquals(puerto1.getContainers().size(),4);
	}
	
//	@Test
//	void notificarATodosLosConsigneesTest() {
//		puerto1.notificarATodosLosConsignees(buque1);
//		assertTrue(true);
//	}
	
	@Test
	void mejorRutaDelPuertoTest() {
		puerto1.setMejorRuta(mejorRuta);
		assertEquals(puerto1.getMejorRuta(),mejorRuta);
	}
	
	@Test
	void elMejorCircuitoTest() {
		puerto1.setMejorRuta(mejorRuta);
		assertEquals(puerto1.elMejorCircuito(puerto1),circuito);
	}
	
	@Test
	void cambioDeNombreDePuertoTest() {
		puerto1.setNombre("nuevo Nombre de Puerto");
		assertEquals(puerto1.getNombre(),"nuevo Nombre de Puerto");
	}
	
	@Test
	void cantidadDeContainersDelPuerto() {
		assertEquals(puerto1.getContainers().size(),2);
	}
	
	@Test
	void cantidadDeConsigneesdelPuertoTest() {
		assertEquals(puerto1.getConsignees().size(),2);
	}
	
	@Test
	void cantidadDeObserversDelPuertoTest() {
		assertEquals(puerto1.getObserversGenerales().size(),2);
	}
	
	@Test
	void cantidadDeEmpresasPortuariasDelPuertoTest() {
		assertEquals(puerto1.getEmpresasNavieras().size(),2);
	}
	
	@Test
	void cantidadDeOrdenesQueTieneElPuertTest() {
		assertEquals(puerto1.getOrdenes().size(),2);
	}
	
	@Test
	void cantidadDeOrdenesAgregadosEnTotalQueTieneElPuertoTest() {
		puerto1.agregarOrden(orden3);
		puerto1.agregarOrden(orden4);
		assertEquals(puerto1.getOrdenes().size(),4);
	}
}
