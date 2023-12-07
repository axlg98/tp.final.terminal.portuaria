package ar.edu.unq.po2.tpFinal.Circuito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unq.po2.tpFinal.TerminalPortuaria.Puerto;

 
public class Circuito {  

	private int id;
	private List<Tramo> tramos = new ArrayList<Tramo>();
	private Puerto puertoOrigen;
	private LocalDateTime fechaYHoraDeSalida;

	public Circuito(int id, List<Tramo> tramos, LocalDateTime fechaYHoraDeSalida) {
		super();
		this.id = id;
		this.tramos = tramos;
		this.fechaYHoraDeSalida = fechaYHoraDeSalida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Tramo> getTramos() {
		return tramos;
	}

//	public void setTramos(List<Tramo> tramos) {
//		this.tramos = tramos;
//	}

	public LocalDateTime getFechaYHoraDeSalida() {
		return fechaYHoraDeSalida;
	}

	public void setFechaYHoraDeSalida(LocalDateTime fechaYHoraDeSalida) {
		this.fechaYHoraDeSalida = fechaYHoraDeSalida;
	}
	
	public Puerto getPuertoOrigen() {
		return puertoOrigen;
	}

	public void setPuertoOrigen(Puerto puertoOrigen) {
		this.puertoOrigen = puertoOrigen;
	}

	public Puerto puertoDeDestino() {
		
		int ultimoTramo = tramos.size()-1;
		
		return tramos.get(ultimoTramo).getPuertoDestino();
		
	}
	
	public Double duracionDeTodoElCircuito() {
		
		Double duracion = 0d;
		
		for (Tramo tramo : tramos) {
			
			duracion += tramo.getDuracionTramo();
			
		}
		
		return duracion;
		
	}
	
	
	public void agregarTramo(Tramo tramo) {
		
		int ultimo = tramos.size()-1;
		
		Tramo ultimoTramo = tramos.get(ultimo);
		
		if (ultimoTramo.getPuertoDestino().equals(tramo.getPuertoOrigen())) {
			
			tramos.add(tramo);
			
		}
		
		// caso contrario no hace nada
	}
	
	
	public int cantidadTramos() {
		
		return tramos.size();
		
	}
	
	
	public boolean contieneA(Puerto puertoDestino){
		return this.tramos.stream().anyMatch(t -> t.getPuertoDestino().equals(puertoDestino));
		
	}

	public Puerto puertoOrigen() {
		return this.getTramos().get(0).getPuertoOrigen();
	}
	
	
	public Double getCostoCircuito() {
		
		Double costo = 0d;
		
		for (Tramo tramo : tramos) {
			
			costo += tramo.getCostoTramo();
			
		}
		
		return costo;
		
	}

	
	public long tiempoDesdeTerminalHastaTerminal(Puerto puertoOrigen, Puerto puertoDestino) {
		
		long tiempoTotal = 0;
		
		Iterator<Tramo> iterator = tramos.iterator();
		
		while (iterator.hasNext()) {
			
			Tramo tramo = iterator.next();
			
			
			if (tramo.getPuertoOrigen().equals(puertoOrigen)) {
				
				tiempoTotal += tramo.getDuracionTramo(); 
				
			}else if (tramo.getPuertoDestino().equals(puertoDestino)) {
				break; // se sale del bucle en caso de que 
			}
			
			
		}
		
		return tiempoTotal;
		
		
	}
	
	
	
	
	
}

