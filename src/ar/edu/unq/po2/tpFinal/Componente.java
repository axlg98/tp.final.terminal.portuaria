package ar.edu.unq.po2.tpFinal;

import java.util.List;

public interface Componente {

	
	public abstract void agregar(Componente componente);
	public abstract void eliminar(Componente componente);
	public abstract List<Viaje> viajes(List<Viaje> viajes);
	
	
	
}
