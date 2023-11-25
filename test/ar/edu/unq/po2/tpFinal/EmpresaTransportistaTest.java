package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTransportistaTest {
	
	EmpresaTransportista empTransportista;
	
	Camion camion1;
	Camion camion2;
	Camion camion3;
	Camion camion4;
	
	Chofer chofer1;
	Chofer chofer2;
	Chofer chofer3;
	Chofer chofer4;
	
	Container container1;
	Container container2;
	Container container3;
	Container container4;
	
	Puerto buenosAires;
	Puerto cordoba;
	
	@BeforeEach
	void setUp() {
		buenosAires = new Puerto("Buenos Aires");
		cordoba = new Puerto("Cordoba");

		empTransportista = new EmpresaTransportista(LocalTime.now(),buenosAires);
		
		chofer1 = new Chofer("Chofer 1");
		chofer2 = new Chofer("Chofer 2");
		chofer3 = new Chofer("Chofer 3");
		chofer4 = new Chofer("Chofer 4");
		
		container1 = new ContainerDry(10,20,30,40);
		container2 = new ContainerReefer(15,30,45,60,1000D);
		container3 = new ContainerTanque(40,50,60,70);
		container4 = new ContainerReefer(80,90,100,110,1500D);
		
		List<Camion> camiones = new ArrayList<Camion>();
		camion1 = new Camion(chofer1,container1);
		camion2 = new Camion(chofer2,container2);
		camiones.add(camion1);
		camiones.add(camion2);
		empTransportista.setCamiones(camiones);
		camion3 = new Camion(chofer3,container3);
		camion4 = new Camion(chofer4,container4);
		
	}
	
	@Test
	void dejarCargaEnPuertoTest() {
		empTransportista.dejarCargas();
		assertEquals(empTransportista.getPuerto().getContainers().size(),0);
	}
	
	@Test
	void cantidadDeCamionesDeLaEmpTransportistaTest() {
		assertEquals(empTransportista.getCamiones().size(),2);
	}
	
	@Test
	void cantidadDeCamionesTotalesConLosCamionesAgregadosDeLaEmpTransportistaTest() {
		empTransportista.agregarCamion(camion3);
		empTransportista.agregarCamion(camion4);
		assertEquals(empTransportista.getCamiones().size(),4);
	}
	
	@Test
	void cambiarElChoferDelCamionDeLaEmpTransportistaTest() {
		camion1.setChofer(chofer2);
		assertEquals(camion1.getChofer(),chofer2);
	}
	
	@Test
	void cambiarDelContainerDelCamionDeLaEmpresaTransportistaTest() {
		camion1.setContainer(container2);
		assertEquals(camion1.getContainer(),container2);
	}
	
	@Test
	void cambiarLaHoraDeLaEmpresaTransportista() {
		empTransportista.setUnaHora(LocalTime.of(22, 10));
		assertEquals(empTransportista.getUnaHora(),LocalTime.of(22,10));
	}
	
	@Test
	void nombreDelChoferDelCamionDeLaEmpresaTransportistaTest() {
		assertEquals(camion1.getChofer().getNombre(),"Chofer 1");
	}
	
	@Test
	void cambioDeNombreDelChoferDelCamionDeLaEmpresaTransportistaTet() {
		camion1.setChofer(chofer2);
		assertEquals(camion1.getChofer().getNombre(),"Chofer 2");
	}
}
