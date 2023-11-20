package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Circuito {
	private String lugarOrigen;
	private String lugarDestino;
	private LocalDateTime fecha;
	private Integer distancia;
	private List<Tramo> tramos;
	
	public Circuito(Integer distancia,List<Tramo> tramos,LocalDateTime fecha) {
//		this.lugarOrigen = origen;
//		this.lugarDestino = destino;
		this.fecha = fecha;
		this.distancia = distancia;
		this.tramos = new ArrayList<Tramo>();
	}
	
	public Puerto puertoDeDestino() {
		
		int ultimoTramo = tramos.size();
		
		return tramos.get(ultimoTramo).getPuertoDestino();
		
	}
		
	//SET Y GET

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getLugarDestino() {
		return lugarDestino;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	
	public List<Tramo> getTramos() {
		return tramos;
	}

	public void setTramos(List<Tramo> tramos) {
		this.tramos = tramos;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	
	
	
}
