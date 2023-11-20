package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class Viaje {

	private Buque unBuque;
	private Circuito circuito;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	private Puerto puertoOrigen;
	private Puerto puertoDestino;
	
	
	public Viaje(Buque unBuque, Circuito circuito, LocalDateTime fechayHoraSalida) {
		super();
		this.unBuque = unBuque;
		this.circuito = circuito;
		this.fechaSalida = fechayHoraSalida;
		this.puertoOrigen = circuito.puertoOrigen();
		this.puertoDestino = circuito.puertoDeDestino();
	}
	
	
	public Buque getUnBuque() {
		return unBuque;
	}
	public void setUnBuque(Buque unBuque) {
		this.unBuque = unBuque;
	}
	public Circuito getCircuito() {
		return circuito;
	}
	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
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
	
	
	
	
	
}
