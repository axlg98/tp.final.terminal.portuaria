package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class EstrategiaMenorCantidadDeTerminales extends EstrategiaMejorRuta {

	@Override
	public Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino) {
		// TODO Auto-generated method stub
		
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
