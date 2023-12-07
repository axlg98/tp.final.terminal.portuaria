package ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.Naviera.Naviera;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

class EstrategiaMejorRutaTest {
	
	EstrategiaMenorPrecio menorPrecio;
	EstrategiaMenorTiempo menorTiempo;
	EstrategiaMenorCantidadDeTerminales menorCantTerminales;
	
	
	Puerto bsas;
	Puerto saoPablo;
	
	Puerto shanghai;
	Puerto singapur;
	
	Naviera naviera1;
	Naviera naviera2;
	
	Circuito circuito1;
	
	Circuito circuito2;
	
	Circuito circuito3;
	
	
	Tramo tramo1;
	
	Tramo tramo2;
	
	Tramo tramo3;
	
	Tramo tramo4;

	Tramo tramo5;
	
	Tramo tramo6;
	
	List<Naviera> navieras;

	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;
	List<Circuito> circuitosN3;
	
	
	List<Circuito> todoCircuito;
	
	List<Tramo> tramosCir1;
	List<Tramo> tramosCir2;
	List<Tramo> tramosCir3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		// Estrategia 
		menorPrecio = new EstrategiaMenorPrecio();
		menorCantTerminales = new EstrategiaMenorCantidadDeTerminales();
		menorTiempo = new EstrategiaMenorTiempo();
		
		// TerminalPortuaria
		bsas = mock(Puerto.class);
		saoPablo = mock(Puerto.class);
		
		shanghai = mock(Puerto.class);
		singapur = mock(Puerto.class);
		
		
		//Naviera		
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		
		//Circuito
		List<Circuito> circuitos = new ArrayList<Circuito>();
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		circuitos.add(circuito1);
		circuitos.add(circuito2);
		circuitos.add(circuito3);
		
		
		//Tramo
		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		tramo3 = mock(Tramo.class);
		tramo4 = mock(Tramo.class);
		tramo5 = mock(Tramo.class);
		tramo6 = mock(Tramo.class);
		
		
		
		// Lista de Navieras
		navieras = Arrays.asList(naviera1, naviera2);
		
		// Lista de Circuitos
		circuitosN1 = Arrays.asList(circuito1, circuito2);
		circuitosN2 = Arrays.asList(circuito3); 
		
		todoCircuito = Arrays.asList(circuito1, circuito2, circuito3);
		
		// Lista de Tramos
		tramosCir1 = Arrays.asList(tramo1, tramo2,tramo3);
		tramosCir2 = Arrays.asList(tramo4, tramo5,tramo6);
		
		
		// Set un valor Mockito
		when(bsas.getNavieras()).thenReturn(navieras);
		when(naviera1.getCircuitos()).thenReturn(circuitosN1);
		when(naviera2.getCircuitos()).thenReturn(circuitosN2);
		
		when(circuito1.contieneA(bsas)).thenReturn(true);
		when(circuito2.contieneA(bsas)).thenReturn(true);
		when(circuito3.contieneA(bsas)).thenReturn(true);
		
		
		
		when(circuito1.contieneA(saoPablo)).thenReturn(true);
		
		
		when(circuito2.contieneA(shanghai)).thenReturn(true);
		when(circuito2.contieneA(singapur)).thenReturn(true);
		

		when(circuito3.contieneA(saoPablo)).thenReturn(true);
		
		
		
		when(circuito1.getCostoCircuito()).thenReturn(1250.0);
		when(circuito2.getCostoCircuito()).thenReturn(250.0);
		when(circuito3.getCostoCircuito()).thenReturn(350.0);
		
		when(circuito1.duracionDeTodoElCircuito()).thenReturn(8d);
		when(circuito2.duracionDeTodoElCircuito()).thenReturn(9d);
		when(circuito3.duracionDeTodoElCircuito()).thenReturn(10d);
		
		
	
	}

	
	@Test 
	void testMejorCircuitoMenorPrecio() {
		
		assertEquals(circuito2, menorPrecio.elMejorCircuito(bsas, saoPablo,circuitosN1));
		
	}
	
	@Test
	void testNavierasDelPuerto() {
		assertEquals(navieras, menorPrecio.empresasPortuariasDe(bsas));
	}

	@Test
	void testTodosLosCircuitosMaritimos() {
		assertEquals(todoCircuito, menorPrecio.todosLosCircuitosDe(navieras));
		// mmmmm
	}
	
	@Test
	void testListaDeCircuitos() {
		List<Circuito> circuitosASaoPablo= Arrays.asList(circuito1,circuito3);
		assertEquals(circuitosASaoPablo, menorPrecio.losCircuitos(bsas, saoPablo,circuitosASaoPablo));
		
		List<Circuito> circuitosAShanghai= Arrays.asList(circuito2);
		assertEquals(circuitosAShanghai, menorPrecio.losCircuitos(bsas, shanghai,circuitosAShanghai));
	}
	
	
	@Test
	void testElDeMenorPrecio() {
		
		assertTrue(menorPrecio.tieneMenorPrecio(circuito2, circuito3));
	}
	
	@Test
	void testElDeMenorTiempo() {
		assertTrue(menorTiempo.tieneMenorTiempo(circuito1, circuito3));
	}
	
	
	@Test
	void testMejorCircuitoMenorTiempo() {
		assertEquals(circuito1,menorTiempo.elMejorCircuito(bsas, singapur,circuitosN1)); 
	}
	
	@Test
	void testMejorCircuitoMenorCantidadTerminales() {
		
		assertEquals(circuito1, menorCantTerminales.elMejorCircuito(bsas, saoPablo,circuitosN1));
		
	}
	
	
	
	
}
