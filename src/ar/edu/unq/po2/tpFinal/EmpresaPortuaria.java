package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class EmpresaPortuaria extends Empresa{
	private List<Buque> buques;
	
	public EmpresaPortuaria(List<Buque> buques) {
		this.setBuques(buques);
	}
	
	//GET Y SET
	
	public List<Buque> getBuques() {
		return buques;
	}
	public void setBuques(List<Buque> buques) {
		this.buques = buques;
	}
	
	public void agregarBuque(Buque buque) {
		buques.add(buque);
	}
	
}
