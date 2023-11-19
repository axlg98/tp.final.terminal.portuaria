package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class EstrategiaMenorTiempo extends EstrategiaMejorRuta{

	@Override
	public Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino) {
		// TODO Auto-generated method stub
		
		
		List<Circuito> circuitos = this.losCircuitos(puertoOrigen, puertoDestino);
		Circuito elDeMenorTiempo = circuitos.get(0);
		
		for (Circuito circuito : circuitos) {
			
			if (circuito.duracionDeTodoElCircuito() < elDeMenorTiempo.duracionDeTodoElCircuito()) {
				
				elDeMenorTiempo = circuito;
				
			}
				
		}
		
		
		return elDeMenorTiempo;
		
		
		
	}

	
	
	
}
