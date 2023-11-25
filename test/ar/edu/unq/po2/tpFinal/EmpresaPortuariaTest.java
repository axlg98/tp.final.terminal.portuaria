package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EmpresaPortuariaTest {
	
	EmpresaPortuaria empPortuaria1;
	EmpresaPortuaria empPortuaria2;
	
	Buque buque1;
	Buque buque2;
	Buque buque3;
	Buque buque4;
	
	//BUQUE PARA VIAJE
	Buque buqueViaje;
	////
	
	Tramo tramo1;
	Tramo tramo2;
	Tramo tramo3;
	Tramo tramo4;
	Tramo tramo5;
	Tramo tramo6;
	
	Circuito circuito1;
	Circuito circuito2;
	
	//PUERTO ORIGEN
	 Puerto buenosAires;
	 Puerto barcelona;
	 Puerto sanLuis;
	//////////////
	 
	 //Puerto origen viaje
	 Puerto cordoba;
	 Puerto laRioja;
	 ////7
	 
	 //Puerto destino viaje
	 Puerto rioDeJaneiro;
	 Puerto laPampa;
	 //////
		
	//PUERTO DESTINO
	 Puerto chile;
	 Puerto mexico;
	 Puerto miami;
	///////////////
	
	//Circuito de VIaje
	Circuito circuitoViaje;
	//////////////
	
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
	
	@BeforeEach
	void setUp() {
		empPortuaria1 = new EmpresaPortuaria();
		empPortuaria2 = new EmpresaPortuaria();
		
		List<Buque> buques = new ArrayList<Buque>();
		buque1 = new Buque("Primer Buque");
		buque2 = new Buque("Segundo Buque");
		buques.add(buque1);
		buques.add(buque2);
		empPortuaria1.setBuques(buques);
		buque3 = new Buque("Tercer Buque");
		buque4 = new Buque("Cuarto Buque");
		
		//puerto origen
		buenosAires = new Puerto("Buenos Aires");
		buenosAires.setUbicacion(new Point2D.Double(05.0,50.0));
		barcelona 	= new Puerto("Barcelona");
		barcelona.setUbicacion(new Point2D.Double(30.0,65.0));
		sanLuis 	= new Puerto("San Luis");
		sanLuis.setUbicacion(new Point2D.Double(13.0,87.0));
		////////////////
		
		//Puerto destino
		miami = new Puerto("Chile");
		miami.setUbicacion(new Point2D.Double(20.0,15.0));
		
		chile = new Puerto("Chile");
		chile.setUbicacion(new Point2D.Double(16.0,24.0));
		
		
		mexico = new Puerto("mexico");
		mexico.setUbicacion(new Point2D.Double(18.0,24.0));
		//////////////////
		
		//BUQUE PARA VIAJE
		buqueViaje = new Buque("Buque de Viaje");
		////
		
		//Puerto origen viaje
		cordoba = new Puerto("Cordoba");
		laRioja = new Puerto("La Rioja");
		///////77//////////
		
		//Puerto destino viaje
		rioDeJaneiro = new Puerto("Rio de Janeiro");
		laPampa      = new Puerto("La Pampa");
		//////////////////////
		
		
		tramo1 = new Tramo(buenosAires, chile, 20d, 500d, LocalDateTime.now());
		tramo2 = new Tramo(barcelona, mexico, 20d, 500d, LocalDateTime.now());
		tramo3 = new Tramo(sanLuis, miami, 20d, 500d, LocalDateTime.now());
		tramo4 = new Tramo(buenosAires, chile, 20d, 500d, LocalDateTime.now());
			
		List<Circuito> circuitos = new ArrayList<Circuito>();
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos.add(tramo1);
		tramos.add(tramo2);
		circuito1 = new Circuito(1, tramos, LocalDateTime.now());
		
		List<Tramo> tramos1 = new ArrayList<Tramo>();
		tramos1.add(tramo3);
		tramos1.add(tramo4);
		circuito2 = new Circuito(2, tramos1, LocalDateTime.now());
		circuitos.add(circuito1);
		empPortuaria1.setCircuitos(circuitos);
		
		List<Tramo> tramos2 = new ArrayList<Tramo>();
		tramos2.add(tramo5);
		tramos2.add(tramo6);
		circuitoViaje = new Circuito(3,tramos2,LocalDateTime.now());
		
		List<Viaje> viajes = new ArrayList<Viaje>();
		viaje1 = new Viaje(buqueViaje,circuitoViaje,LocalDateTime.now(),LocalDateTime.of(2023, 11, 27, 15, 45),cordoba,rioDeJaneiro);
		viaje2 = new Viaje(buqueViaje,circuitoViaje,LocalDateTime.of(2023, 12, 02, 15, 45),LocalDateTime.of(2023, 12, 05, 05, 45),laRioja,laPampa);
		viaje3 = new Viaje(buqueViaje,circuitoViaje,LocalDateTime.now(),LocalDateTime.of(2023, 12, 05, 05, 45),cordoba,laPampa);
		viajes.add(viaje1);
		viajes.add(viaje2);
		empPortuaria1.setViajes(viajes);
	}

	@Test
	void laEmpPortuariaContieneElCircuitoTest() {
		assertTrue(empPortuaria1.contieneCircuito(circuito1));
	}
	
	@Test
	void cantidadDeBuqueDeLaEmpPortuariaTest() {
		assertEquals(empPortuaria1.getBuques().size(),2);
	}
	
	@Test
	void cantidadDeBuquesEnTotalConLosBuquesAgregadosTest() {
		empPortuaria1.agregarBuque(buque3);
		empPortuaria1.agregarBuque(buque4);
		assertEquals(empPortuaria1.getBuques().size(),4);
	}
	
	@Test
	void cantidadDeCircuitosDeLaEmpPortuariaTest() {
		assertEquals(empPortuaria1.getCircuitos().size(),1);
	}
	
	@Test
	void cantidadDeCircuitosEnTotalConLosCircuitosAgregadosTest() {
		empPortuaria1.agregarCircuito(circuito2);
		assertEquals(empPortuaria1.getCircuitos().size(),2);
	}
	
	@Test
	void cantidadDeViajesDeLaEmpPortuariaTest() {
		assertEquals(empPortuaria1.getViajes().size(),2);
	}
	
	@Test
	void cantidadDeViajesEnTotalConLosViajesAgregadosTest() {
		empPortuaria1.agregarViaje(viaje3);
		assertEquals(empPortuaria1.getViajes().size(),3);
	}
}
