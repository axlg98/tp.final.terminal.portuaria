package ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class EstrategiaMenorPrecio extends EstrategiaMejorRuta {


	@Override
	public Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino,List<Circuito> cs) {
		// TODO Auto-generated method stub
		
		
		List<Circuito> circuitos = this.losCircuitos(puertoOrigen, puertoDestino,cs);
		Circuito elDeMenorPrecio = circuitos.get(0);
		
		for (Circuito circuito : cs) {
			
			if (circuito.getCostoCircuito() < elDeMenorPrecio.getCostoCircuito()) {
				
				elDeMenorPrecio = circuito;
				
			}
				
		}
		
		
		return elDeMenorPrecio;
		
		 
		
	}
	
	public boolean tieneMenorPrecio(Circuito primerCircuito, Circuito segundoCircuito) {
		return primerCircuito.getCostoCircuito() < segundoCircuito.getCostoCircuito();
	}
	
	
	
}
