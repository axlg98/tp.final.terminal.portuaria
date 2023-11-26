package ar.edu.unq.po2.tpFinal.Filtros;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;

public class FiltroFechaLlegada implements Filtro {

	private LocalDateTime fechaLlegada;

	@Override
	public List<Viaje> buscarEn(List<Viaje> viajes) {
		return viajes.stream().filter(v ->v.getFechaLlegada().equals(this.getFechaLlegada())).toList();
		//return viajes.stream().filter(v->v.getFechaLlegada() == this.getFechaLlegada()).toList();
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	
	
	
}
