package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.List;

public class FiltroFechaDestino implements Componente{

	private LocalDateTime fechaDestino;
	
	@Override
	public void agregar(Componente componente) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void eliminar(Componente componente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Viaje> viajes(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v->v.getFechaLlegada() == this.fechaDestino).toList();
	}

	
	
}
