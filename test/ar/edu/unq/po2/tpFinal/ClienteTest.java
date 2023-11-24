package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	

}
