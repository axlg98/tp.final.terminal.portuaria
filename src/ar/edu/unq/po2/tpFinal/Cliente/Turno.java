package ar.edu.unq.po2.tpFinal.Cliente;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Turno {

	private Orden orden;
	private LocalDateTime fechaYHora;
	
	
	
	public Turno(Orden orden, LocalDateTime fechaYHora) {
		super();
		this.orden = orden;
		this.fechaYHora = fechaYHora;
	}
	
	
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	
	
	
	
	
}
