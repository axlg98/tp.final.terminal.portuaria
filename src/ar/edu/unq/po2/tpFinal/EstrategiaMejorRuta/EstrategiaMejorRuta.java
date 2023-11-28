package ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Naviera.Naviera;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

import java.util.ArrayList;

public abstract class EstrategiaMejorRuta {

	public List<Circuito> losCircuitos(Puerto puertoOrigen, Puerto puertoDestino,List<Circuito> circuitos){
		
		//List<Naviera> empresasPortuarias = empresasPortuariasDe(puertoOrigen);
		
		//List<Circuito> circuitos = todosLosCircuitosDe(empresasPortuarias);
		
		List<Circuito> circuitosFiltradosPorDestino = circuitos.stream().filter(c->c.contieneA(puertoDestino)).collect(Collectors.toList());
		
		return circuitosFiltradosPorDestino;
		
	}
	
	
	public List<Naviera> empresasPortuariasDe(Puerto puerto){
		
		return puerto.getEmpresasNavieras();
		
	}
	
	public List<Circuito> todosLosCircuitosDe(List<Naviera> empresasPortuarias){
		
		List<Circuito> circuitos = new ArrayList<Circuito>();
		
		for (Naviera empresa : empresasPortuarias) {
			
			circuitos.addAll(empresa.getCircuitos());
			
		}
		
		return circuitos;
		
	}
	
	public abstract Circuito elMejorCircuito(Puerto puertoOrigen, Puerto puertoDestino,List<Circuito> circuitos);
	
	
	
}
