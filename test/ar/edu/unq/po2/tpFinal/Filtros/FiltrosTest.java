package ar.edu.unq.po2.tpFinal.Filtros;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

class FiltrosTest {
	
	FiltroFechaLlegada filtroFechaLlegada;
	FiltroFechaSalida filtroFechaSalida;
	FiltroPuertoDestino filtroPuertoDestino;
	FiltroCombinado filtroCombinado;
	
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
	
	 Viaje viaje1;
	 Viaje viaje2;
	 Viaje viaje3;
	 
	 Circuito circuito;
	
	 Buque buque1;
	
	 OperadorAND operadorAND;
	 OperadorOR operadorOR;
	 
	 
	@BeforeEach
	void setUp() {
		
		buque1 = mock(Buque.class);
		
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
		
		
		
		viaje1 = new Viaje(buque1, circuito, LocalDateTime.of(2023, 2, 20, 13, 50), LocalDateTime.of(2023, 3, 5, 9, 50), buenosAires, barcelona);
		
		viaje2 = new Viaje(buque1, circuito, LocalDateTime.of(2023, 5, 14, 12, 45), LocalDateTime.of(2023, 3, 5, 9, 50), buenosAires, miami);
		
		viaje3 = new Viaje(buque1, circuito, LocalDateTime.of(2023, 2, 20, 13, 50), LocalDateTime.of(2023, 3, 18, 16, 50), buenosAires, mexico);
		
		
		filtroFechaLlegada = new FiltroFechaLlegada(); 
		filtroFechaSalida = new FiltroFechaSalida();
		filtroPuertoDestino = new FiltroPuertoDestino();
		filtroCombinado = new FiltroCombinado();
		
		operadorAND = new OperadorAND();
		operadorOR = new OperadorOR();
	}
	
	
	@Test
	void testFiltroFechaLlegada() {
		
		filtroFechaLlegada.setFecha(LocalDateTime.of(2023, 3, 5, 9, 50)); // seteo el filtro en la fecha que quiero filtrar
		
		List<Viaje> viajes = new ArrayList<Viaje>(); // genero la lista de viajes la cual voy a filtrar
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);
		
		
		assertEquals(filtroFechaLlegada.buscarEn(viajes).size(), 2);
		
		
	}
	
	@Test
	void testFiltroFechaSalida() {
		
		filtroFechaSalida.setFechaSalida(LocalDateTime.of(2023, 5, 14, 12, 45)); // setep el filtro en la fecha que quiero filtrar
		
		
		List<Viaje> viajes = new ArrayList<Viaje>(); // genero la lista de viajes la cual voy a filtrar
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);
		
		
		assertEquals(filtroFechaSalida.buscarEn(viajes).size(), 1);
		 
		 
		
		
	}
	
	
	@Test
	void testFiltroPuertoDestino() {
		
		filtroPuertoDestino.setPuerto(barcelona);
		
		List<Viaje> viajes = new ArrayList<Viaje>(); // genero la lista de viajes la cual voy a filtrar
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);
		
		
		assertEquals(filtroPuertoDestino.buscarEn(viajes).size(), 1);
		
		 
	}
	
	@Test
	void testFiltroCombinadoOperadorAND() {
		
		filtroFechaLlegada.setFecha(LocalDateTime.of(2023, 3, 5, 9, 50));
		filtroPuertoDestino.setPuerto(barcelona);
		
		
		filtroCombinado.setConector(operadorAND);
		filtroCombinado.setFiltro1(filtroFechaLlegada);
		filtroCombinado.setFiltro2(filtroPuertoDestino);
		
		List<Viaje> viajes = new ArrayList<Viaje>(); // genero la lista de viajes la cual voy a filtrar
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);
		
		
		assertEquals(filtroCombinado.buscarEn(viajes).size(), 1);
		assertTrue(filtroCombinado.buscarEn(viajes).contains(viaje1));
		
	}
	
	
	@Test
	void testFiltroCombinadoOperadorOR() {
		
		filtroFechaSalida.setFechaSalida(LocalDateTime.of(2023, 5, 14, 12, 45)); 
		filtroPuertoDestino.setPuerto(barcelona);
		
		filtroCombinado.setConector(operadorOR);
		filtroCombinado.setFiltro1(filtroFechaSalida);
		filtroCombinado.setFiltro2(filtroPuertoDestino);
		
		List<Viaje> viajes = new ArrayList<Viaje>(); // genero la lista de viajes la cual voy a filtrar
		viajes.add(viaje1);
		viajes.add(viaje2);
		viajes.add(viaje3);
		
		
		assertEquals(filtroCombinado.buscarEn(viajes).size(), 2);
		
		assertTrue(filtroCombinado.buscarEn(viajes).contains(viaje1));
		assertTrue(filtroCombinado.buscarEn(viajes).contains(viaje2));
		
	}
	
	
	 
	

}
