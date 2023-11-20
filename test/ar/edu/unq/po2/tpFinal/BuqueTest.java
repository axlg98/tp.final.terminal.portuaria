package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuqueTest {

	private Buque buque1;
	private Buque buque2;
	
	private Container container1;
	private Container container2;
	private Container container3;
	private Container container4;
	private Container container5;
	
	private Puerto buenosAires;
	private Puerto barcelona;
	
	private Puerto chile;
	private Puerto mexico;
	
	private Viaje viaje;
	private Circuito circuito;
	
	private Tramo tramo1;
	private Tramo tramo2;

	
	
	@BeforeEach
	void setUp() {
		
		
		
		
		buenosAires = new Puerto("BuenosAires");
		buenosAires.setUbicacion(new Point2D.Double(16,24));
		
		
		barcelona = new Puerto("Barcelona");
		barcelona.setUbicacion(new Point2D.Double(16,24));
		
		
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(16,24));
		
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(16,24));
		
		
		
		tramo1 = new Tramo(buenosAires, barcelona, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(chile, mexico, 20d, 500d, LocalDateTime.now());
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		
		container1 = mock(Container.class);
		container2 = mock(Container.class);
		container3 = mock(Container.class);
		container4 = mock(Container.class);
		container5 = mock(Container.class);
		
		buque1 = new Buque("buque1");
		buque2 = new Buque("buque2");
														/*ver como hacer max fecha*/
																//	^ ^
																//	| |
		viaje = new Viaje(buque1, circuito, LocalDateTime.now(),LocalDateTime.MAX,chile,mexico);
		buque1.setPosicionActual(new Point2D.Double(16,24));
		buque2.posicionActualDelBuque(8, 43);
		
		buque1.setUnViaje(viaje);
		
		
		
	}
	
	
	@Test
	void testDistanciaEntreBuques() {
	
		assertEquals(GPS.calcularDistancia(buque1.getPosicionActual(), buque2.getPosicionActual()), 20.615528128088304);
		
		
	}
	
	@Test
	void testNombreBuque() {
		
		assertEquals(buque1.getNombre(), "buque1");
		
	}
	
	@Test 
	void testCantidadDeContainersEnBuque() {
		
		buque1.agregarContainer(container1);
		buque1.agregarContainer(container2);
		buque1.agregarContainer(container3);
		buque1.agregarContainer(container4);
		buque1.agregarContainer(container5);
		
		
		assertEquals(buque1.getContainers().size(), 5);
		
	}
	
	
	@Test
	void testFaseInicialDelBuqueOutBound() {
		
		
		assertTrue(buque1.getFase() instanceof Outbound);
		
	}
	
	/*@Test
	void testFaseDeBuquePasaAArrived() {
		
		buque1.getFase().actualizarEstado(buque1);
		assertTrue(buque1.getFase() instanceof Arrived);
		
		
	}*/
	
	@Test
	void testPuertoDestinoDelBuqueCoincideConAlgunoDeLosTramosDelCircuito() {
		
		buque1.setFase(new Inbound()); // lo seteo en Inbound
		buque1.actualizarEstado(); // le pido a esa fase que se actualice
		
		assertTrue(buque1.getPuertoDestino() == viaje.getPuertoDestino()); // los puertos son los mismos
		
		assertEquals(buque1.getPuertoDestino().getUbicacion(), new Point2D.Double(16,24)); // la ubicacion es la misma
		assertEquals(buque1.getPosicionActual(), new Point2D.Double(16,24)); // 
		
		assertTrue(buque1.getFase() instanceof Arrived); 
		// no cambia el estado, cuando la posicion del buque es la misma que la del puerto
		// y le digo que se actualice deberia cambiar a Arrived, estando antes en Inbound
		
	}
	
	
	

}
