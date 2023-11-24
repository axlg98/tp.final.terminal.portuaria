package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.List;

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
