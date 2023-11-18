package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;

public class Circuito {
	private String lugarOrigen;
	private String lugarDestino;
	private Integer distancia;
	private List<Tramo> tramos;
	
	public Circuito(String origen, String destino, Integer distancia) {
		this.lugarOrigen = origen;
		this.lugarDestino = destino;
		this.distancia = distancia;
		this.tramos = new ArrayList<Tramo>();
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
}
