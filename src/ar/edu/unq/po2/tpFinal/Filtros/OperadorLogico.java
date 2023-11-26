package ar.edu.unq.po2.tpFinal.Filtros;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;

public interface OperadorLogico {

	public List<Viaje> juntarListas(List<Viaje> xs, List<Viaje> ys);
	
	
}
 