package ar.edu.unq.po2.tpFinal.Circuito;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Buque.Buque;

import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class Viaje {

	private Buque unBuque;
	private Circuito circuito;
	private LocalDateTime fechaSalida; 
	private LocalDateTime fechaLlegada; 
	private Puerto puertoOrigen;
	private Puerto puertoDestino; 
	
	
	public Viaje(Buque unBuque, Circuito circuito, LocalDateTime fechaSalida, LocalDateTime fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino) {
		super();
		this.unBuque = unBuque;
		this.circuito = circuito; 
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
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
		return this.fechaLlegada;
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
