package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.Container.ContainerDry;
import ar.edu.unq.po2.tpFinal.Container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.Container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.Orden.Orden;
import ar.edu.unq.po2.tpFinal.Servicio.AlmacenamientoExcedente;
import ar.edu.unq.po2.tpFinal.Servicio.Electricidad;
import ar.edu.unq.po2.tpFinal.Servicio.Pesado;
import ar.edu.unq.po2.tpFinal.Servicio.Servicio;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

import org.junit.jupiter.api.Test;

class OrdenTest {
	
	Orden orden1;
	Orden orden2;
	
	//Container para Orden
	Container container1;
	Container container2;
	//////////////////////
	
	//CARGAR CLIENTE
	Container cargaCliente;
	////////////////
	
	Cliente cliente1;
	Cliente cliente2;
	
	Servicio servicio1;
	Servicio servicio2;
	Servicio servicio4;
	
	Puerto buenosAires;
	
	Viaje viaje1;
	
	//PUERTO ORIGEN
	
	Puerto roma;
	Puerto torino;
	Puerto chile;
	
	///////////////
	
	// PUERTO DESTINO
	Puerto mexico;
	Puerto madrid;
	Puerto canarias;
	Puerto barcelona;
	
	/////////////////
	
	Buque buque;
	
	Tramo tramo1;
	Tramo tramo2;
	Circuito circuito;
	
	
	@BeforeEach
	void setUp() {
		cargaCliente = new ContainerDry(55,45,21,80);
		cliente1 = new Cliente(cargaCliente);
		
		container1 = new ContainerTanque(75,100,125,150);
		container2 = new ContainerReefer(15,30,45,60,150D);
		orden1 = new Orden(container1,cliente1);
		
		List<Servicio> servicios = new ArrayList<Servicio>();
		servicio1 =  new Electricidad(1500D);
		servicio2 =  new Pesado();
		
		servicios.add(servicio1);
		servicios.add(servicio2);
		orden1.setServicios(servicios);
		
		//Puerto de Orden
		buenosAires = new Puerto("Buenos Aires");
		/////////////////
		
		//PUERTO ORIGEN
		roma   = new Puerto("Roma");
		torino = new Puerto("Torino");
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(8,28));
		/////////////////////////////////////////////
		
		//PUERTO DESTINO
		
		madrid   = new Puerto("Madrid");
		canarias = new Puerto("Canarias");
		
		buque = new Buque("Buque");
		
		barcelona = new Puerto("Barcelona");
		barcelona.setUbicacion(new Point2D.Double(15,18));
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(54,14));
		////////////////////////////////////////////////
		
		tramo1 = new Tramo(buenosAires, barcelona, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(chile, mexico, 20d, 500d, LocalDateTime.now());
		
		
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito = new Circuito(1, tramos, LocalDateTime.now());
		
		viaje1 = new Viaje(buque,circuito,LocalDateTime.now(),LocalDateTime.of(2023, 12, 23, 18,12),roma, canarias);
		orden1.setUnViaje(viaje1);
		
	}

	@Test
	void cantidadDeServiciosDeLaOrdenTest() {
		assertEquals(orden1.getServicios().size(), 2);
	}
	
	@Test
	void agregandoServicioYCantidadTotal() {
		Servicio servicio3 = mock(AlmacenamientoExcedente.class);
		orden1.agregarServicio(servicio3);
		assertEquals(orden1.getServicios().size(), 3);
	}
	
	@Test
	void costoTotalDeServiciosTest() {
		assertEquals(orden1.costoTotalDeServicios(),922700D);
	}
	
	@Test
	void elOrdenTieneElPuertoTest() {
		orden1.setPuerto(buenosAires);
		assertEquals(orden1.getPuerto(),buenosAires);
	}
	
	@Test
	void clienteActualTeste() {
		assertEquals(orden1.getUnCliente(),cliente1);
	}
	
	@Test
	void cambioDeClienteTest() {
		orden1.setUnCliente(cliente2);
		assertEquals(orden1.getUnCliente(),cliente2);
	}
	
	@Test
	void containerActualTeste() {
		assertEquals(orden1.getUnContainer(),container1);
	}
	
	@Test
	void cambioDeContainerTest() {
		orden1.setUnContainer(container2);
		assertEquals(orden1.getUnContainer(),container2);
	}
	
	@Test
	void viajeDeLaOrdenDadaTest() {
		assertEquals(orden1.getUnViaje(),viaje1);
	}
	
	@Test
	void fechaDeLlegadaDeLaCargaDelAvionTest() {
		assertEquals(orden1.fechaLlegadaDeLaCarga(),LocalDateTime.of(2023, 12, 23, 18,12));
	}
	
	@Test
	void cambioDeFechaDeLlegadaDeLaCargaDeUnViaje() {
		viaje1.setFechaLlegada(LocalDateTime.of(2023, 12, 30,23,30));
		assertEquals(orden1.fechaLlegadaDeLaCarga(),LocalDateTime.of(2023, 12, 30,23,30));
	}
	
	@Test 
	void cambioDeFechaDeSalidaDeLaCargaDelAvionTest() {
		orden1.getUnViaje().setFechaSalida(LocalDateTime.of(2023, 12, 22,18,12));
		assertEquals(orden1.fechaSalidaDeLaCarga(),LocalDateTime.of(2023, 12, 22,18,12));
	}
	
	@Test
	void nuevoChoferAsignadoParaLaOrdenTest() {
		orden1.setChoferaAsignado(new Chofer("nuevo Chofer asignado"));
		assertEquals(orden1.getChoferaAsignado().getNombre(), "nuevo Chofer asignado");
	}
	
	

}
