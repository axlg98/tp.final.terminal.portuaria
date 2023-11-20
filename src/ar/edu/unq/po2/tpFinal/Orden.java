package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class Orden {

	private Viaje unViaje;
	private Container unContainer;
	private Cliente unCliente;
	private Puerto puerto;
	
	public Orden(Container unContainer, Cliente unCliente) {
		super();
		
		this.unContainer = unContainer;
		this.unCliente = unCliente;
		
	}

	public LocalDateTime fechaSalidaDeLaCarga() {
		
		return unViaje.getFechaSalida();
		
	}
	
	public LocalDateTime fechaLlegadaDeLaCarga() {
		
		return unViaje.getFechaLlegada();
		
	}
	
	
	// GET´S Y SET´S
	
	public Viaje getUnViaje() {
		return unViaje;
	}
	public void setUnViaje(Viaje unViaje) {
		this.unViaje = unViaje;
	}
	public Container getUnContainer() {
		return unContainer;
	}
	public void setUnContainer(Container unContainer) {
		this.unContainer = unContainer;
	}
	public Cliente getUnCliente() {
		return unCliente;
	}
	public void setUnCliente(Cliente unCliente) {
		this.unCliente = unCliente;
	}

	public Puerto getPuerto() {
		return puerto;
	}

	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}
	
	
	
	
	
}
