package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Circuito {

	private int id;
	private List<Tramo> tramos = new ArrayList<Tramo>();
	
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

	public void setTramos(List<Tramo> tramos) {
		this.tramos = tramos;
	}

	public LocalDateTime getFechaYHoraDeSalida() {
		return fechaYHoraDeSalida;
	}

	public void setFechaYHoraDeSalida(LocalDateTime fechaYHoraDeSalida) {
		this.fechaYHoraDeSalida = fechaYHoraDeSalida;
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
		
		if (ultimoTramo.getPuertoDestino() == tramo.getPuertoOrigen()) {
			
			tramos.add(tramo);
			
		}
		
		// caso contrario no hace nada
	}
	
	
	public int cantidadTramos() {
		
		return tramos.size();
		
	}
	
	
	public boolean contieneA(Puerto puertoDestino){
		
		return this.tramos.stream().anyMatch(t -> t.getPuertoDestino() == puertoDestino);
		
	}

	public Puerto puertoOrigen() {
		// TODO Auto-generated method stub
		return this.getTramos().get(0).getPuertoOrigen();
	}
	
	
	public Double getCostoCircuito() {
		
		Double costo = 0d;
		
		for (Tramo tramo : tramos) {
			
			costo += tramo.getCostoTramo();
			
		}
		
		return costo;
		
	}
	
	
	
	
}
//public class Circuito {
//	private String lugarOrigen;
//	private String lugarDestino;
//	private LocalDateTime fechaYHoraDeSalida;
//	private Integer distancia;
//	private List<Tramo> tramos;
//	
//	public Circuito(Integer distancia,List<Tramo> tramos,LocalDateTime fecha) {
////		this.lugarOrigen = origen;
////		this.lugarDestino = destino;
//		this.fechaYHoraDeSalida = fecha;
//		this.distancia = distancia;
//		this.tramos = new ArrayList<Tramo>();
//	}
//	
//	public Puerto puertoDeDestino() {
//		
//		int ultimoTramo = tramos.size();
//		
//		return tramos.get(ultimoTramo).getPuertoDestino();
//		
//	}
//	
//	public boolean contieneA(Puerto puertoDestino) {
//		return puertoDestino.getNombre().equals(lugarDestino);
//	}
//	
//	public int cantidadTramos() {
//		return tramos.size();
//	}
//	
//	public Double getCostoCircuito() {
//		return 0D;
//	}
//	
//	//SET Y GET
//
//	public String getLugarOrigen() {
//		return lugarOrigen;
//	}
//
//	public void setLugarOrigen(String lugarOrigen) {
//		this.lugarOrigen = lugarOrigen;
//	}
//
//	public String getLugarDestino() {
//		return lugarDestino;
//	}
//
//	public void setLugarDestino(String lugarDestino) {
//		this.lugarDestino = lugarDestino;
//	}
//
//	public Integer getDistancia() {
//		return distancia;
//	}
//
//	public void setDistancia(Integer distancia) {
//		this.distancia = distancia;
//	}
//	
//	public List<Tramo> getTramos() {
//		return tramos;
//	}
//
//	public void setTramos(List<Tramo> tramos) {
//		this.tramos = tramos;
//	}
//
//	public LocalDateTime getFechaYHoraDeSalida() {
//		return fechaYHoraDeSalida;
//	}
//
//	public void getFechaYHoraDeSalida(LocalDateTime fecha) {
//		this.fechaYHoraDeSalida = fecha;
//	}
//
//	
//	
//	
//}
