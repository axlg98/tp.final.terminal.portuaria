package ar.edu.unq.po2.tpFinal.Servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.Orden.Orden;

class ServicioTest {

	
	
	Electricidad electricidad;
	AlmacenamientoExcedente almacenamientoExcedente;
	Lavado lavado;
	Pesado pesado;
	
	Container container;
	
	Orden orden1;
	LocalDateTime salidaContainer;
	LocalDateTime entregaContainer;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		
		electricidad = new Electricidad(50d);
		almacenamientoExcedente = new AlmacenamientoExcedente();
		lavado = new Lavado();
		pesado = new Pesado();
		container = mock(Container.class);

		orden1 = mock(Orden.class);
		
		
		
		
	}
	
	
	
	
	@Test
	void testServicioDeElectricidad() {
		
		assertEquals(50, electricidad.getKilowattCosto());
		
		salidaContainer = LocalDateTime.of(2023, 12, 18, 13, 00);
		entregaContainer = LocalDateTime.of(2023, 12, 28, 15, 00);
		
		when(orden1.fechaSalidaDeLaCarga()).thenReturn(salidaContainer);
		when(orden1.fechaLlegadaDeLaCarga()).thenReturn(entregaContainer);
		
		
		assertEquals(12100, electricidad.costoServicio(orden1));

	}

	
	@Test
	void testServicioAlmacenamientoExcedente() {
		
		assertEquals(30, almacenamientoExcedente.getCostoPorDia());
		
		
		salidaContainer = LocalDateTime.of(2023, 12, 18, 13, 00);
		entregaContainer = LocalDateTime.of(2023, 12, 28, 15, 00);
		
		when(orden1.fechaSalidaDeLaCarga()).thenReturn(salidaContainer);
		when(orden1.fechaLlegadaDeLaCarga()).thenReturn(entregaContainer);
		
		assertEquals(7260, almacenamientoExcedente.costoServicio(orden1));
		
	}
	
	
	@Test
	void testServicioLavadoMayor70() {
		
		when(orden1.getUnContainer()).thenReturn(container);
		
		when(container.tamañoDelContainer()).thenReturn(100); // es mayor a 70
		
		assertEquals(500,lavado.costoServicio(orden1));
			
	}
	
	
	@Test
	void testServicioLavadoMenorA70() {
		
		when(orden1.getUnContainer()).thenReturn(container);
		when(container.tamañoDelContainer()).thenReturn(40);
		assertEquals(250,lavado.costoServicio(orden1));
		
	}
	
	
	@Test
	void servicioDePesadoTest() {
		assertEquals(200d, pesado.getCosto());
		pesado.setCosto(300d);
		
		assertEquals(300d, pesado.getCosto());
		
		assertEquals(300d, pesado.costoServicio(orden1));
	}
	
	@Test
	void cambioDeCostoDelAlmacenamientoExcedenteTest() {
		almacenamientoExcedente.setCostoPorDia(1500D);
		assertEquals(almacenamientoExcedente.getCostoPorDia(),1500D);
	}
	
	@Test
	void cambioDeCostoDeKilowattEnServicioDeElectricidadTest() {
		electricidad.setKilowattCosto(100D);
		assertEquals(electricidad.getKilowattCosto(),100D);
	}
	
}
