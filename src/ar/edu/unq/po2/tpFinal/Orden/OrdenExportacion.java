package ar.edu.unq.po2.tpFinal.Orden;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

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
