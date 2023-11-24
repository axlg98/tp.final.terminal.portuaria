package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.List;

public class FiltroFechaSalida implements Filtro {

	private LocalDateTime fechaSalida;
	
	
	
	@Override
	public List<Viaje> buscarEn(List<Viaje> viajes) {
		return viajes.stream().filter(v->v.getFechaSalida().equals(this.getFechaSalida())).toList();
		//return viajes.stream().filter(v->v.getFechaSalida() == this.getFechaSalida()).toList();
	}



	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}



	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	
	
	 
	
}
