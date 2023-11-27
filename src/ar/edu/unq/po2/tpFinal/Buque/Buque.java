	package ar.edu.unq.po2.tpFinal.Buque;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

import java.awt.geom.Point2D;
import java.util.ArrayList;


		
public class Buque {
 
	private String nombre;
	private FaseBuque fase;
	private Point2D  posicionActual = new Point2D.Double(0, 0);
	private List<Container> containers;
	
	private Viaje unViaje;
	
	
	
	public Buque(String nombre) {
		super();
		this.nombre = nombre;
		this.fase = new Outbound();
		this.containers = new ArrayList<Container>();
	}
	
	public void agregarContainer(Container container) {
		
		this.getContainers().add(container);
		
	}
	
	public void avisarPuerto(Puerto puerto) {
		puerto.notificarATodosLosConsignees();
		//puerto.darAvisoClientes(); cambiar nombre
		
	}


	public void cambiarPosicionBuque(Point2D posicion) {
		
		this.setPosicionActual(posicion);
		this.actualizarEstado();
	} 
	
	public void actualizarEstado() {
		this.getFase().actualizarEstado(this);
	}
	//SET Y GET

	public Point2D getPosicionActual() {
		return posicionActual;
	}



	public void setPosicionActual(Point2D posicionActual) {
		this.posicionActual = posicionActual;
	}


	public Viaje getUnViaje() {
		return unViaje;
	}



	public void setUnViaje(Viaje unViaje) {
		this.unViaje = unViaje;
	}
	
	public Puerto getPuertoDestino() {
		
		return this.unViaje.getPuertoDestino();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public FaseBuque getFase() {
		return fase;
	}
	public void setFase(FaseBuque fase) {
		this.fase = fase;
	}
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
	
}
