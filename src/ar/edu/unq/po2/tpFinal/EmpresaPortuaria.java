package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmpresaPortuaria {

	private List<Circuito> circuitos;
	private List<Viaje> viajes;
	private List<Buque> buques;
	

	
	public void agregarCircuito(Circuito circuito) {
		
		this.circuitos.add(circuito);
		
	}
	
	public void agregarBuque(Buque buque) {
		
		this.buques.add(buque);
		
	}
	
	public List<Circuito> losCircuitosConDestinoEn(Puerto puerto){
		
		return this.getCircuitos().stream().filter(c->c.puertoDeDestino() == puerto).collect(Collectors.toList());
		
	}
	
	
	public void generarViaje(Buque buque, Circuito circuito, LocalDateTime fechaYHora) {
		
		if (esCircuitoValido(circuito) && esBuqueValido(buque)) {
			
			this.viajes.add(new Viaje(buque, circuito, fechaYHora));
			
		}
		
	}
	
	
	public boolean esCircuitoValido(Circuito circuito) {
		
		return this.circuitos.contains(circuito);
		
	}
	
	public boolean esBuqueValido(Buque buque) {
		
		return this.buques.contains(buque);
		
	}
	
	
	
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

	//Verifica si el puerto contiene el Circuito dado.
		public boolean contieneCircuito(Circuito circuito) {
			return circuitos.contains(circuito);
		}
	
	
	
	
}
