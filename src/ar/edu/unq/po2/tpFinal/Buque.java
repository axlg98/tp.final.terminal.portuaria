package ar.edu.unq.po2.tpFinal;

import java.util.List;
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
	 
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
	
	public void agregarContainer(Container container) {
		
		this.getContainers().add(container);
		
	}
	

	
	public void avisarPuerto(Puerto puerto) {
		
		puerto.darAvisoClientes();
		
	}
	

	public void actualizarEstado() {
		this.getFase().actualizarEstado(this);
	}
	

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



	public FaseBuque getFase() {
		return fase;
	}



	public void setFase(FaseBuque fase) {
		this.fase = fase;
	}
	
	public void posicionActualDelBuque(int x, int y){
		
		this.posicionActual.setLocation(x, y);
	}
	
	
	
}
