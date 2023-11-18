package ar.edu.unq.po2.tpFinal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public abstract class EstrategiaMejorRuta {

	public List<Circuito> losCircuitos(Puerto puertoOrigen, Puerto puertoDestino){
		
		List<EmpresaPortuaria> empresasPortuarias = empresasPortuariasDe(puertoOrigen);
		
		List<Circuito> circuitos = todosLosCircuitosDe(empresasPortuarias);
		
		List<Circuito> circuitosFiltradosPorDestino = circuitos.stream().filter(c->c.contieneA(puertoDestino)).collect(Collectors.toList());
		
		return circuitosFiltradosPorDestino;
		
	}
	
	
	public List<EmpresaPortuaria> empresasPortuariasDe(Puerto puerto){
		
		return puerto.getEmpresasNavieras();
		
	}
	
	public List<Circuito> todosLosCircuitosDe(List<EmpresaPortuaria> empresasPortuarias){
		
		List<Circuito> circuitos = new ArrayList<Circuito>();
		
		for (EmpresaPortuaria empresa : empresasPortuarias) {
			
			circuitos.addAll(empresa.getCircuitos());
			
		}
		
		return circuitos;
		
	}
	
	public abstract Circuito elMejorCircuito(Puerto puertoOrige, Puerto puertoDestino);
	
	
	
}
