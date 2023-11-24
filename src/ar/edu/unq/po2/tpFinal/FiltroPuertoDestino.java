package ar.edu.unq.po2.tpFinal;

import java.util.List;

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
