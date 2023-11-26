package ar.edu.unq.po2.tpFinal;

public class Electricidad implements Servicio{
	
	private Double kilowatt;	
	
	public Electricidad(Double kilowatt) {
		this.kilowatt = kilowatt;
	}
	
	@Override
	public Double costoServicio(Orden orden) {
		return this.getKilowatt() * orden.getUnContainer().costoDelContainer();
	}

	public Double getKilowatt() {
		return kilowatt;
	}

	public void setKilowatt(Double kilowatt) {
		this.kilowatt = kilowatt;
	}
}
