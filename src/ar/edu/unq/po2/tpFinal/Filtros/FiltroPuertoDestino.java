package ar.edu.unq.po2.tpFinal.Filtros;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class FiltroPuertoDestino implements Filtro{

	private Puerto puerto;

	public FiltroPuertoDestino(Puerto puerto) {
		super();
		this.puerto = puerto;
	}

	public Puerto getPuerto() {
		return puerto;
	}

	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}

	@Override
	public List<Viaje> buscarEn(List<Viaje> viajes) {
		
		return viajes.stream().filter(v -> v.getPuertoDestino().equals(this.getPuerto())).toList();
		//return viajes.stream().filter(v->v.getPuertoDestino() == this.getPuerto()).toList();
	}
	
	
	
	
	 
	
	
}
