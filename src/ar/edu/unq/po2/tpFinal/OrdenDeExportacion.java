package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class OrdenDeExportacion extends Orden {

	private Puerto puertoDestino;	
	private LocalDateTime fechaYHoraSalida;
	
	public OrdenDeExportacion(Container unContainer, Cliente unCliente, Puerto puertoDestino, LocalDateTime fechaYHoraSalida) {
		super(unContainer, unCliente);
		this.puertoDestino = puertoDestino;
		this.fechaYHoraSalida = fechaYHoraSalida;
		
		// TODO Auto-generated constructor stub
	}

	public Puerto getPuertoDestino() {
		return puertoDestino;
	}

	public void setPuertoDestino(Puerto puertoDestino) {
		this.puertoDestino = puertoDestino;
	}

	public LocalDateTime getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}

	
	
}
