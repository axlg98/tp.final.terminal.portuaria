package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrdenExportacion extends Orden{
	private LocalDateTime fechaYHoraSalida;
	private Container container;
	private Cliente cliente;
	private Puerto puertoDestino;
	
	
	
	public OrdenExportacion(LocalDateTime fechaYHoraSalida,Container container,Cliente cliente,Puerto puertoDestino) {
		super(container,cliente);
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.container = container;
		this.cliente = cliente;
		this.puertoDestino = puertoDestino;
	}
	
	public void enviar(Container container, Cliente cliente) {
		
	}
	
	//@Override
	public void horaDeLlegadaCamion(LocalDate time,Camion camion,Chofer chofer) {
		
	}
	
	//SET Y GET
	
	public LocalDateTime getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Puerto getPuertoDestino() {
		return puertoDestino;
	}

	public void setPuertoDestino(Puerto puertoDestino) {
		this.puertoDestino = puertoDestino;
	}
	

}
