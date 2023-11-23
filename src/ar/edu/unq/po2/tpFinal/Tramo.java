package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class Tramo {

	private Puerto puertoOrigen;
	private Puerto puertoDestino;
	private Double duracionTramo;
	private Double costoTramo;
	
	private LocalDateTime fechaYHoraSalida;

	public Tramo(Puerto puertoOrigen, Puerto puertoDestino, Double duracionTramo, Double costoTramo,
			LocalDateTime fechaYHoraSalida) {
		super();
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.duracionTramo = GPS.calcularDistancia(puertoOrigen.getUbicacion(), puertoDestino.getUbicacion());
		this.costoTramo = costoTramo;
		this.fechaYHoraSalida = fechaYHoraSalida;
	}

	
	public Puerto getPuertoOrigen() {
		return puertoOrigen;
	}

	public void setPuertoOrigen(Puerto puertoOrigen) {
		this.puertoOrigen = puertoOrigen;
	}

	public Puerto getPuertoDestino() {
		return puertoDestino;
	}

	public void setPuertoDestino(Puerto puertoDestino) {
		this.puertoDestino = puertoDestino;
	}

	public Double getDuracionTramo() {
		return duracionTramo;
	}

	public void setDuracionTramo(Double duracionTramo) {
		this.duracionTramo = duracionTramo;
	}

	public Double getCostoTramo() {
		return costoTramo;
	}

	public void setCostoTramo(Double costoTramo) {
		this.costoTramo = costoTramo;
	}

	public LocalDateTime getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}
	
	
	
	
	 
	
}
