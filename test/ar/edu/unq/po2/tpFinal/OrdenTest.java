package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.Circuito.Tramo;
import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Cliente.Turno;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.Container.ContainerDry;
import ar.edu.unq.po2.tpFinal.Container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.Container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.Orden.Orden;
import ar.edu.unq.po2.tpFinal.Orden.OrdenExportacion;
import ar.edu.unq.po2.tpFinal.Orden.OrdenImportacion;
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
	Viaje viaje2;
	
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
	Circuito circuito1;
	
	Camion camion1;
	
	Chofer chofer1;
	Chofer chofer2;
	
	Turno turno;
	
	
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
		circuito = new Circuito(2, tramos, LocalDateTime.of(2024, 1,5, 10, 30));
		
		viaje1 = new Viaje(buque,circuito,LocalDateTime.now(),LocalDateTime.of(2023, 12, 23, 18,12),roma, canarias);
		orden1.setUnViaje(viaje1);
		
		viaje2 = new Viaje(buque,circuito,LocalDateTime.now(),LocalDateTime.of(2024, 1, 3, 9,12),buenosAires, chile);
		
		chofer1 = new Chofer("Primer chofer");
		
		turno = new Turno(orden2,LocalDateTime.now());
		
		camion1 = new Camion(chofer1,container1);
		
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
		assertEquals(orden1.costoTotalDeServicios(),897200D);
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
	

	@Test
	void unaOrdenCambiaTodoLoQueTeniaTest() {
		orden1.setCamionAsignado(camion1);
		assertEquals(orden1.getCamionAsignado(),camion1);
		
		orden1.setChoferaAsignado(chofer2);
		assertEquals(orden1.getChoferaAsignado(),chofer2);
		
		orden1.setEntregaContainer(LocalDateTime.of(2024,1,2,5,55));
		assertEquals(orden1.getEntregaContainer(),LocalDateTime.of(2024,1,2,5,55));
		
		orden1.setPuerto(canarias);
		assertEquals(orden1.getPuerto(),canarias);
		
		orden1.setTurno(turno);
		assertEquals(orden1.getTurno(),turno);
		
		orden1.setUnCliente(cliente2);
		assertEquals(orden1.getUnCliente(),cliente2);
		
		orden1.setUnContainer(container2);
		assertEquals(orden1.getUnContainer(),container2);
		
		orden1.setUnViaje(viaje2);
		assertEquals(orden1.getUnViaje(),viaje2);
		
	}
	
	@Test
	void determinarLaFechaDeLlegadaDeUnaOrdeDeImportacion() {
		OrdenImportacion ordenImp = new OrdenImportacion(LocalDate.of(2023, 12, 5),LocalTime.of(20, 15),container1,cliente1);
		ordenImp.horaDeLlegadaCamion(LocalDate.of(2023, 12, 5),camion1,chofer1);
		assertEquals(ordenImp.getFechaLlegada(),LocalDate.of(2023, 12, 5));
		assertEquals(ordenImp.getHoraLlegada(),LocalTime.of(20, 15));
		assertEquals(ordenImp.getCamionAsignado(),camion1);
		assertEquals(ordenImp.getChoferaAsignado(),chofer1);
	}
	
	@Test
	void determinarLaFechaDeSalidaUnContainerYMasCosasDeLaOrdenDEExportacionTest() {
		OrdenExportacion ordenExp = new OrdenExportacion(container1,cliente1,madrid,circuito,LocalDateTime.of(2023, 11, 22, 10, 10));
		ordenExp.setCamion(camion1);
		assertEquals(ordenExp.getCamion(),camion1);
		
		ordenExp.setChofer(chofer2);
		assertEquals(ordenExp.getChofer(),chofer2);
		
		ordenExp.setCircuito(circuito1);
		assertEquals(ordenExp.getCircuito(),circuito1);
		
		ordenExp.setFechaYHoraSalida(LocalDateTime.of(2023, 11, 28, 17, 25));
		assertEquals(ordenExp.getFechaYHoraSalida(),LocalDateTime.of(2023,11,28,17,25));
		
		ordenExp.setPuertoDestino(canarias);
		assertEquals(ordenExp.getPuertoDestino(),canarias);
		
	}
	
}
