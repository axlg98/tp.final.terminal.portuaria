package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GPSTest {

	private Puerto buenosAires;
	private Puerto barcelona;
	

	@BeforeEach

	void setUp() {
		
		
		buenosAires = new Puerto("BuenosAires");
		buenosAires.ubicacionDelPuerto(7, 8);
		barcelona = new Puerto("Barcelona");
		barcelona.ubicacionDelPuerto(5, 5);
		
	}
	
	@Test
	void testDistanciaEntrePuertos() {
		
		assertEquals(GPS.calcularDistancia(buenosAires.getUbicacion(), barcelona.getUbicacion()), 3.605551275463989);
		
		
		
	}
	
	
	

}
