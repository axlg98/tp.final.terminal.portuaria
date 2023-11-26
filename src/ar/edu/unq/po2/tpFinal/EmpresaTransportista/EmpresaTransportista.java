package ar.edu.unq.po2.tpFinal.EmpresaTransportista;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class EmpresaTransportista {
	
	private List<Camion> camiones;
	private LocalTime unaHora;
	private Puerto puerto;
	
	public EmpresaTransportista(LocalTime unaHora, Puerto puerto) {
		this.camiones = new ArrayList<Camion>();
		this.unaHora = unaHora;
		this.puerto = puerto;
	}
	
	public void dejarCargas() {
		
		for (Camion camion : camiones) {
			camion.dejarCargaEnPuerto(this.getPuerto());
		}
		
	}
	
	public void agregarCamion(Camion camion) {
		this.camiones.add(camion);
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
