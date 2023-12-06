package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

class CircuitoTest {

	 Tramo tramo1; 
	 Tramo tramo2;
	 Tramo tramo3;
	
	//Puertos de origen
	 Puerto buenosAires;
	 Puerto barcelona;
	 Puerto sanLuis;
	
	//Puertos de destino
	 Puerto chile;
	 Puerto mexico;
	 Puerto miami;
	
	 Viaje viaje;
	 Circuito circuito;
	
	
	@BeforeEach
	void setUp() {
		

		buenosAires = new Puerto("BuenosAires");
		buenosAires.setUbicacion(new Point2D.Double(16,24));
		
		
		barcelona = new Puerto("Barcelona");
		barcelona.setUbicacion(new Point2D.Double(15,18));
		
		sanLuis = new Puerto("San Luis");
		sanLuis.setUbicacion(new Point2D.Double(12,42));
		
		
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(8,28));
		
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(54,14));
		
		miami = new Puerto("San Luis");
		miami.setUbicacion(new Point2D.Double(30,60));
		
		tramo1 = new Tramo(buenosAires, barcelona, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(chile, mexico, 20d, 500d, LocalDateTime.now());
		tramo3 = new Tramo(mexico,miami,40D,750D,LocalDateTime.now());
		
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		//circuito.setTramos(tramos);
		
	}
	
	
	@Test
	void testCualEsElUltimoPuertoDelCircuito() {
		
		
		assertEquals(circuito.puertoDeDestino().getNombre(), "mexico");
		
	}
	
	@Test
	void testCantidadDeTramosDelCircuito(){
		
		assertEquals(circuito.cantidadTramos(), 2);
		
	}
	
	@Test
	void duracionDeTodoElCircuitoTest() {
		assertEquals(circuito.duracionDeTodoElCircuito(), 54.16602365098345);
	}
	
	@Test
	void agregarTramoTest() {
		circuito.agregarTramo(tramo3);
		assertEquals(circuito.cantidadTramos(),3);
	}
	
	@Test
	void contieneATest() {
		tramo1.setPuertoDestino(buenosAires);
		assertTrue(circuito.contieneA(buenosAires));
	}
	
	@Test
	void puertoOrigenTest() {
		assertEquals(circuito.puertoOrigen(),tramo1.getPuertoOrigen());
	}
	
	@Test
	void getCostoCircuitoTest() {
		assertEquals(circuito.getCostoCircuito(),1000D);
	}
	
	@Test
	void getIdTest() {
		assertEquals(circuito.getId(), 1);
	}
	
	@Test
	void aumentoDeCostoTest() {
		tramo1.setCostoTramo(750D);	
		assertEquals(circuito.getCostoCircuito(),1250D);
	}
	
	@Test
	void cambioDeIdTest() {
		circuito.setId(2);
		assertEquals(circuito.getId(), 2);
	}
	
	@Test
	void fechaYHoraDeSalidaTest() {
		circuito.setFechaYHoraDeSalida(LocalDateTime.MAX);
		assertEquals(circuito.getFechaYHoraDeSalida(),LocalDateTime.MAX);
	}
	
	@Test
	void cambiandoElOrigenDelTramoDelCircuitoTest() {
		tramo1.setPuertoOrigen(miami);
		assertEquals(tramo1.getPuertoOrigen(),miami);
	}
	
	@Test
	void tramocambiaLaFechaYHoraDeSalidaDelCircuitoTest() {
		tramo1.setFechaYHoraSalida(LocalDateTime.of(2024, 01, 05, 20, 55));
		assertEquals(tramo1.getFechaYHoraSalida(),LocalDateTime.of(2024, 01, 05, 20, 55));
	}
	
	@Test
	void cambioDeDuracionDelTramoDelCircuitoTest() {
		tramo1.setDuracionTramo(1000D);
		assertEquals(tramo1.getDuracionTramo(),1000D);
	}
	
	@Test
	void tiempoDesdeTerminalHastaTerminal() {
		
		assertEquals(circuito.tiempoDesdeTerminalHastaTerminal(buenosAires, miami), 6);
		
		
	}
	
	@Test
	void cantidadDeTramos() {
		assertEquals(circuito.getTramos().size(),2);
	}
	
	@Test
	void cambiandoPueroDeOrigenDelCircuito() {
		circuito.setPuertoOrigen(mexico);
		assertEquals(circuito.getPuertoOrigen(),mexico);
	}
	
}
