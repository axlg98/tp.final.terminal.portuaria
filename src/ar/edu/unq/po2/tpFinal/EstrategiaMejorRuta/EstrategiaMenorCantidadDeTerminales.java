package ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class EstrategiaMenorCantidadDeTerminales extends EstrategiaMejorRuta {

	@Override
	public Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino) {
		
		List<Circuito> circuitosConPuertoDestino = this.losCircuitos(puertoOrigen, puertoDestino);
		
		Circuito elMejor = circuitosConPuertoDestino.get(0);
		
		for (Circuito circuito : circuitosConPuertoDestino) {
			
			if (circuito.cantidadTramos() < elMejor.cantidadTramos()) {
				
				elMejor = circuito; // en caso de que tenga menos escalas cambia el circuito
				
			}
			
			// caso contrario no hace nada
			
		}
		 
		
		return elMejor;
	}

	
	
	
}
