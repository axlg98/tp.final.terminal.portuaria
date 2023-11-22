package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class OrdenExportacion extends Orden {

	private Puerto puertoDestino;	
	private LocalDateTime fechaYHoraSalida;
	private Circuito circuito;
	private Camion camion;
	private Chofer chofer;
	 
	
	
	public OrdenExportacion(Container unContainer, Cliente unCliente, Puerto puertoDestino, Circuito circuito) {
		super(unContainer, unCliente);
		this.puertoDestino = puertoDestino;
		this.circuito = circuito;
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

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	
	
}
