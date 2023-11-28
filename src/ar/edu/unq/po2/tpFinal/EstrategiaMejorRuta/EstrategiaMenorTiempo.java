package ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class EstrategiaMenorTiempo extends EstrategiaMejorRuta{

	@Override
	public Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino,List<Circuito> cs) {
		// TODO Auto-generated method stub
		
		
		List<Circuito> circuitos = this.losCircuitos(puertoOrigen, puertoDestino,cs);
		Circuito elDeMenorTiempo = circuitos.get(0);
		
		for (Circuito circuito : cs) {
			
			if (circuito.duracionDeTodoElCircuito() < elDeMenorTiempo.duracionDeTodoElCircuito()) {
				
				elDeMenorTiempo = circuito;
				
			}
				
		}
		
		
		return elDeMenorTiempo;
		
		
		
	}

	public boolean tieneMenorTiempo(Circuito primerCircuito, Circuito segundoCircuito) {
		return primerCircuito.duracionDeTodoElCircuito() < segundoCircuito.duracionDeTodoElCircuito();
	}
	
	
}
