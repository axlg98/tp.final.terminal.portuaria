package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuqueTest {

	 Buque buque1;
	 Buque buque2;
	
	 Container container1;
	 Container container2;
	 Container container3;
	 Container container4;
	 Container container5;
	
	 Puerto buenosAires;
	 Puerto barcelona;
	
	 Puerto chile;
	 Puerto mexico;
	
	 Viaje viaje;
	 Circuito circuito;
	
	 Tramo tramo1;
	 Tramo tramo2;

	
	
	@BeforeEach
	void setUp() {
		
		buenosAires = new Puerto("BuenosAires");
		buenosAires.setUbicacion(new Point2D.Double(16,24));
		
		
		barcelona = new Puerto("Barcelona");
		barcelona.setUbicacion(new Point2D.Double(18D,24D));
		
		
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(16.0,24.0));
		
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(18.0,24.0));
		
		
		
		tramo1 = new Tramo(buenosAires, barcelona, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(chile, mexico, 20d, 500d, LocalDateTime.now());
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		
		List<Container> containers = new ArrayList<Container>();
		container1 = mock(Container.class);
		container2 = mock(Container.class);
		container3 = mock(Container.class);
		container4 = mock(Container.class);
		container5 = mock(Container.class);
		containers.add(container1);
		containers.add(container2);
		containers.add(container3);
		containers.add(container4);
		containers.add(container5);
		
		buque1 = new Buque("buque1");
		buque2 = new Buque("buque2");
		buque1.setContainers(containers);
														/*ver como hacer max fecha*/
																//	^ ^
																//	| |
		viaje = new Viaje(buque1, circuito, LocalDateTime.now(),LocalDateTime.MAX,chile,mexico);
		buque1.setPosicionActual(new Point2D.Double(16.0,24.0));
		buque2.posicionActualDelBuque(8, 43);
		
		buque1.setUnViaje(viaje);
		
		
		
	}
	
	
	@Test
	void testDistanciaEntreBuques() {
		assertEquals(GPS.calcularDistancia(buque1.getPosicionActual(), buque2.getPosicionActual()),28.844410203711913);
		
		
	}
	
	@Test
	void testNombreBuque() {
		
		assertEquals(buque1.getNombre(), "buque1");
		
	}
	@Test
	void cambioDeNombre() {
		buque1.setNombre("buqueAleatorio");
		assertEquals(buque1.getNombre(), "buqueAleatorio");
	}
	
	@Test 
	void agregarContainerYCantidadDeContainersAgregadosTest() {
		
		buque1.agregarContainer(container1);
		buque1.agregarContainer(container2);
		buque1.agregarContainer(container3);
		buque1.agregarContainer(container4);
		buque1.agregarContainer(container5);
		
		
		assertEquals(buque1.getContainers().size(), 10);
		
	}
	
	
	@Test
	void testFaseInicialDelBuqueOutBound() {
		
		
		assertTrue(buque1.getFase() instanceof Outbound);
		
	}
	@Test
	void buquePuertoDestino() {
		assertEquals(buque1.getPuertoDestino().getNombre(),"mexico");
	}
	
	@Test
	void testFaseDeBuquePasaAArrived() {
		assertTrue(buque1.getFase() instanceof Outbound);
		buque1.getFase().actualizarEstado(buque1);
		assertTrue(buque1.getFase() instanceof Inbound);
		buque1.setPosicionActual(new Point2D.Double(18.0,24.0));
		buque1.getFase().actualizarEstado(buque1);
		assertTrue(buque1.getFase() instanceof Arrived);	
	}
	
	@Test
	void testPuertoDestinoDelBuqueCoincideConAlgunoDeLosTramosDelCircuito() {
		
		buque1.setFase(new Inbound()); // lo seteo en Inbound
		buque1.setPosicionActual(new Point2D.Double(18,24));
		buque1.actualizarEstado(); // le pido a esa fase que se actualice
		assertTrue(buque1.getPuertoDestino() == viaje.getPuertoDestino()); // los puertos son los mismos
		assertEquals(buque1.getPuertoDestino().getUbicacion(), new Point2D.Double(18,24)); // la ubicacion es la misma

		assertEquals(buque1.getPosicionActual(), new Point2D.Double(18,24));
		assertTrue(buque1.getFase() instanceof Arrived); 

	}
	
	@Test
	void cantidadDeContainersDelBuque() {
		assertEquals(buque1.getContainers().size(),5);
	}
	
	

}
