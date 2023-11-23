package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	
	private List<Turno> turnos;
	private Container carga;
	 
	public Cliente(Container carga) {
		this.carga = carga;
		turnos = new ArrayList<Turno>();
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


	public List<Turno> getTurnos() {
		return turnos;
	}


	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	
	 
}
