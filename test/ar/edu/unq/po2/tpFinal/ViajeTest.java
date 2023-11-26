package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;


class ViajeTest {
	
	Viaje viaje;
	
	Tramo tramo1;
	Tramo tramo2;
	Tramo tramo3;
	Tramo tramo4;
	
	Circuito circuito;
	Circuito circuito1;
	
	//PUERTO ORIGEN
	 Puerto buenosAires;
	 Puerto barcelona;
	 Puerto sanLuis;
	//////////////
	
	//PUERTO DESTINO
	 Puerto chile;
	 Puerto mexico;
	 Puerto miami;
	////////////////
	 
	 Buque buque;
	 Buque otroBuque;
	
	@BeforeEach
	void setUp() {
		//Puerto origen
		buenosAires = new Puerto("Buenos Aires");
		barcelona 	= new Puerto("Barcelona");
		sanLuis 	= new Puerto("San Luis");
		////////////////////////////////////////
		
		//Puerto destino
		chile  = new Puerto("Chile");
		mexico = new Puerto("Mexico");
		miami  = new Puerto("Miami");
		////////////////////////////////////////
		
		tramo1 = new Tramo(buenosAires, chile, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(barcelona, mexico, 20d, 500d, LocalDateTime.now());
		tramo3 = new Tramo(sanLuis, miami, 20d, 500d, LocalDateTime.now());
		tramo4 = new Tramo(buenosAires, chile, 20d, 500d, LocalDateTime.now());
		
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		
		List<Tramo> tramos1 = new ArrayList<Tramo>();
		tramos1.add(tramo3);
		tramos1.add(tramo4);
		circuito1 = new Circuito(2, tramos1, LocalDateTime.now());
		
		buque = new Buque("Buque");
		otroBuque = new Buque("Nuevo buque");
		
		viaje = new Viaje(buque,circuito,LocalDateTime.now(),LocalDateTime.of(2023, 12, 23, 18,12),buenosAires, chile);
		
	}
	
	@Test
	void buqueActualDelViajeTest() {
		assertEquals(viaje.getUnBuque(),buque);
	}
	
	@Test
	void CambioDeBuqueEnElViajeDadoTest() {
		viaje.setUnBuque(otroBuque);
		assertEquals(viaje.getUnBuque(),otroBuque);
	}
	
	@Test
	void circuitoDeViajeTest() {
		assertEquals(viaje.getCircuito(),circuito);
	}
	
	@Test
	void cambioDeCircuitoDeUnViajeTest() {
		viaje.setCircuito(circuito1);
		assertEquals(viaje.getCircuito(),circuito1);
	}
	
	@Test
	void puertoDeOrigenDelViajeTest() {
		assertEquals(viaje.getPuertoOrigen(),buenosAires);
	}
	
	@Test
	void cambioDePuertoDeOrigenDelAvionTest() {
		viaje.setPuertoOrigen(barcelona);
		assertEquals(viaje.getPuertoOrigen(),barcelona);
	}
	
	@Test
	void puertoDeDestinoDelViajeTest() {
		assertEquals(viaje.getPuertoDestino(),chile);
	}
	
	@Test
	void cambioDePuertoDeDestinoDelAvionTest() {
		viaje.setPuertoDestino(miami);
		assertEquals(viaje.getPuertoDestino(),miami);
	}

}
