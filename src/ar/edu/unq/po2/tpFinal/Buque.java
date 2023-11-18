package ar.edu.unq.po2.tpFinal;

import java.util.List;
import java.awt.geom.Point2D;
import java.util.ArrayList;


		
public class Buque {
 
	private String nombre;
	private FaseDeBuque fase;
	private Point2D  posicionActual = new Point2D.Double(0, 0);
	private List<Container> containers;
	
	private Viaje unViaje;
	
	
	
	public Buque(String nombre) {
		super();
		this.nombre = nombre;
		this.fase = FaseDeBuque.Outbound; // Fase inicial del buque
		this.containers = new ArrayList<Container>();
	}
	 
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public FaseDeBuque getFase() {
		return fase;
	}
	public void setFase(FaseDeBuque fase) {
		this.fase = fase;
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
	
	public void cambiarDeFase(FaseDeBuque fase) {
		
		if (fase == FaseDeBuque.Inbound) {
			
			// dar aviso de cambio de fase
			this.setFase(fase);
		}
		
		
		
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
	
	
	
	
	
}
