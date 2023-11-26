package ar.edu.unq.po2.tpFinal.Filtros;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;

public interface Filtro {

	public List<Viaje> buscarEn(List<Viaje> viajes);
	
}
 