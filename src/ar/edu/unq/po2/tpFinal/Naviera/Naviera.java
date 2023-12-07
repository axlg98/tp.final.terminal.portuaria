package ar.edu.unq.po2.tpFinal.Naviera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Circuito.Viaje;

public class Naviera{
	private List<Buque> buques;
	private List<Circuito> circuitos;
    private List<Viaje> viajes;
	
	public Naviera() {
		buques = new ArrayList<Buque>();
		circuitos = new ArrayList<Circuito>();
		viajes = new ArrayList<Viaje>();
	}
	
	//Verifica si el puerto contiene el Circuito dado.
	public boolean contieneCircuito(Circuito circuito) {
		return circuitos.contains(circuito);
	}
	
	//AGREGAR A LA LISTA DE CADA CLASE.
	
	public void agregarBuque(Buque buque) {
		buques.add(buque);
	}

	public void agregarCircuito(Circuito circuito) {
		
		this.circuitos.add(circuito);
		
	}
	
	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}
	
	public Double cantidadDeLoQueTardaUnaNavieraDeTerminalATerminal() {
		return circuitos.stream().mapToDouble(c -> c.duracionDeTodoElCircuito()).sum();
	}

	//GET Y SET
	
	public List<Circuito> getCircuitos() {
		return circuitos;
	}

	public void setCircuitos(List<Circuito> circuitos) {
		this.circuitos = circuitos;
	}

	public List<Buque> getBuques() {
		return buques;
	}
	public void setBuques(List<Buque> buques) {
		this.buques = buques;
	}
	
	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	
}
