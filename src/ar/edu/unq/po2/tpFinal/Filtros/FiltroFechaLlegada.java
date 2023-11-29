package ar.edu.unq.po2.tpFinal.Filtros;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;

public class FiltroFechaLlegada implements Filtro {
 
	private LocalDateTime fecha;
	
  
	@Override
	public List<Viaje> buscarEn(List<Viaje> viajes) {
		
		/*return viajes.stream()
	            .filter(v -> v != null &&
	                    v.getFechaLlegada() != null &&
	                    (this.getFecha() == null || v.getFechaLlegada().equals(this.getFecha())))
	            .toList();*/
		
		
		return viajes.stream().filter(v ->v.getFechaLlegada().equals(this.getFecha())).toList();
		//return viajes.stream().filter(v->v.getFechaLlegada() == this.getFechaLlegada()).toList();
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
