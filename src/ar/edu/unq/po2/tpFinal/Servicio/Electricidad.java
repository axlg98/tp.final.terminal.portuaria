package ar.edu.unq.po2.tpFinal.Servicio;

import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Electricidad implements Servicio{
	
	private Double kilowattCosto;	
	
	public Electricidad(Double kilowatt) {
		this.kilowattCosto = kilowatt;
	}
	
	@Override
	public Double costoServicio(Orden orden) {
		return kilowattCosto *  ChronoUnit.HOURS.between( orden.fechaSalidaDeLaCarga(), orden.fechaLlegadaDeLaCarga());
	}

	public Double getKilowattCosto() {
		return kilowattCosto;
	}

	public void setKilowattCosto(Double i) {
		this.kilowattCosto = i;
	}
}
