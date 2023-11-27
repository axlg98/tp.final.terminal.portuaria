package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Cliente.Turno;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.Container.ContainerDry;
import ar.edu.unq.po2.tpFinal.Container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.Container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.Orden.Orden;

class ClienteTest {
	
	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente3;
	
	Container cargaCliente1;
	Container cargaCliente2;
	Container cargaCliente3;
	
	Turno turno1;
	Turno turno2;
	
	Orden orden1;
	Orden orden2;
	@BeforeEach
	void setUo() {
		
		cargaCliente1 = new ContainerDry(50,21,51,21);
		cargaCliente2 = new ContainerReefer(50,21,51,21,85D);
		cargaCliente3 = new ContainerTanque(50,21,51,21);
		
		cliente1 = new Cliente(cargaCliente1);
		cliente2 = new Cliente(cargaCliente2);
		cliente3 = new Cliente(cargaCliente3);
		
		orden1 = new Orden(cargaCliente1,cliente1);
		orden2 = new Orden(cargaCliente2,cliente2);
		
		List<Turno> turnos = new ArrayList<Turno>();
		turno1 = new Turno(orden1,LocalDateTime.now());
		turno2 = new Turno(orden2,LocalDateTime.now());
		turnos.add(turno1);
		turnos.add(turno2);
		cliente1.setTurnos(turnos);
		cliente1.setTurno(turno1);	
		turno1.setOrden(orden1);
	}
	
	@Test
	void cantidadDeTurnosConElTurnoAgregadoTest() {
		Turno turno3 = new Turno(orden2,LocalDateTime.now());
		cliente1.agregarTurno(turno3);
		assertEquals(cliente1.getTurnos().size(),3);
	}
	
	@Test
	void agregarContainers() {
		cliente1.setCarga(cargaCliente2);
		assertEquals(cliente1.getCarga(),cargaCliente2);
	}
	
	@Test
	void cambioDeTurnoDelCliente1Test() {
		cliente1.setTurno(turno2);
		assertEquals(cliente1.getTurno(),turno2);
	}
	
	@Test
	void cambioDeOrdenDelTurnoDelClienteTest() {
		cliente1.getTurno().setOrden(orden2);
		assertEquals(cliente1.getTurno().getOrden(),orden2);
	}
	
	@Test
	void cambioDeFechaYHoraDelTurnoDelClienteTest() {
		cliente1.getTurno().setFechaYHora(LocalDateTime.of(2024, 1, 15, 10, 30));
		assertEquals(cliente1.getTurno().getFechaYHora(),LocalDateTime.of(2024, 1, 15, 10, 30));
	}
	

}
