package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircuitoTest {

	private Tramo tramo1;
	private Tramo tramo2;
	
	private Puerto buenosAires;
	private Puerto barcelona;
	
	private Puerto chile;
	private Puerto mexico;
	
	private Viaje viaje;
	private Circuito circuito;
	
	
	@BeforeEach
	void setUp() {
		

		buenosAires = new Puerto("BuenosAires");
		buenosAires.setUbicacion(new Point2D.Double(16,24));
		
		
		barcelona = new Puerto("Barcelona");
		barcelona.setUbicacion(new Point2D.Double(15,18));
		
		
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(8,28));
		
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(54,14));
		
		tramo1 = new Tramo(buenosAires, barcelona, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(chile, mexico, 20d, 500d, LocalDateTime.now());
		
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		
	}
	
	
	@Test
	void testCualEsElUltimoPuertoDelCircuito() {
		
		
		assertEquals(circuito.puertoDeDestino().getNombre(), "mexico");
		
	}
	
	@Test
	void testCantidadDeTramosDelCircuito(){
		
		assertEquals(circuito.cantidadTramos(), 2);
		
	}
	

}
