package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class EstrategiaMenorPrecio extends EstrategiaMejorRuta {


	@Override
	public Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino) {
		// TODO Auto-generated method stub
		
		
		List<Circuito> circuitos = this.losCircuitos(puertoOrigen, puertoDestino);
		Circuito elDeMenorPrecio = circuitos.get(0);
		
		for (Circuito circuito : circuitos) {
			
			if (circuito.getCostoCircuito() < elDeMenorPrecio.getCostoCircuito()) {
				
				elDeMenorPrecio = circuito;
				
			}
				
		}
		
		
		return elDeMenorPrecio;
		
		
		
	}
	
	
}
