package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;

public class EmpresaPortuaria extends Empresa{
	private List<Buque> buques;
	private List<Circuito> circuitos;
//  private List<Viaje> viajes;
	
	public EmpresaPortuaria() {
		buques = new ArrayList<Buque>();
		circuitos = new ArrayList<Circuito>();
	}
	
	//Verifica si el puerto contiene el Circuito dado.
	public boolean contieneCircuito(Circuito circuito) {
		return circuitos.contains(circuito);
	}
	
	public void agregarBuque(Buque buque) {
		buques.add(buque);
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
	
}
