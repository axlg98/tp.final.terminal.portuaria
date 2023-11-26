package ar.edu.unq.po2.tpFinal.Cliente;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Container.Container;

public class Cliente {
	
	
	private Turno turno;
	private Container carga;
	private List<Turno> turnos;
	 
	public Cliente(Container carga) {
		this.carga = carga;
		
	}
	
	public void agregarTurno(Turno turno) {
		
		this.getTurnos().add(turno);
		
	}
	
	
	
	public Container getCarga() {
		return carga;
	}



	public void setCarga(Container carga) {
		this.carga = carga;
	}



	public Turno getTurno() {
		return turno;
	}



	public void setTurno(Turno turno) {
		this.turno = turno;
	}



	public List<Turno> getTurnos() {
		return turnos;
	}



	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	
	
	
	
	
	 
}
