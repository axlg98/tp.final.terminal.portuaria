package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.Orden.Orden;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

public class OrdenDeExportacion extends Orden {

	private Puerto puertoDestino;	
	private LocalDateTime fechaYHoraSalida;
	
	public OrdenDeExportacion(Container unContainer, Cliente unCliente, Puerto puertoDestino, LocalDateTime fechaYHoraSalida) {
		super(unContainer, unCliente);
		this.puertoDestino = puertoDestino;
		this.fechaYHoraSalida = fechaYHoraSalida;
		
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
