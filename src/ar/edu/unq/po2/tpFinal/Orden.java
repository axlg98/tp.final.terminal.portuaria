package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Orden {

	private Viaje unViaje;
	private Container unContainer;
	private Cliente unCliente;
	private Puerto puerto;
	private List<Servicio> servicios;
	
	
	
	public Orden(Container unContainer, Cliente unCliente) {
		super();
		
		this.unContainer = unContainer;
		this.unCliente = unCliente;
		this.servicios = new ArrayList<Servicio>();
		
	}

	public LocalDateTime fechaSalidaDeLaCarga() {
		
		return unViaje.getFechaSalida();
		
	} 
	
	public LocalDateTime fechaLlegadaDeLaCarga() {
		
		return unViaje.getFechaLlegada();
		
	}
	
	public void agregarServicio(Servicio servicio) {
		
		this.servicios.add(servicio);
		
	}
	
	public Double costoTotalDeServicios() {
		
		Double costoTotal = 0d;

		for (Servicio servicio : servicios) {
			costoTotal += servicio.costoServicio(this);
		}
		
		return costoTotal;	
		
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

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
	
}
