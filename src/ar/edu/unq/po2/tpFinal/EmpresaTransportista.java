package ar.edu.unq.po2.tpFinal;

import java.time.LocalTime;
import java.util.List;

public class EmpresaTransportista {
	private List<Camion> camiones;
	private LocalTime unaHora;
	private Puerto puerto;
	
	public void dejarCargas() {
		
		for (Camion camion : camiones) {
			camion.dejarCargaEnPuerto(this.getPuerto());
		}
		
	}
	
	public List<Camion> getCamiones() {
		return camiones;
	}
	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}

	public LocalTime getUnaHora() {
		return unaHora;
	}
	public void setUnaHora(LocalTime unaHora) {
		this.unaHora = unaHora;
	}
	public Puerto getPuerto() {
		return puerto;
	}
	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}
	
}
