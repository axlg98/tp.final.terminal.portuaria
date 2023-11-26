package ar.edu.unq.po2.tpFinal.Servicio;

import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class AlmacenamientoExcedente implements Servicio{
	
	private Double costoPorDia = 30d;
	
	@Override
	public Double costoServicio(Orden orden) {
		return this.getCostoPorDia() * ChronoUnit.HOURS.between(orden.fechaSalidaDeLaCarga(), orden.fechaLlegadaDeLaCarga());
	}
	
	//GET Y SET
	

	public Double getCostoPorDia() {
		return costoPorDia;
	}

	public void setCostoPorDia(Double costoPorDia) {
		this.costoPorDia = costoPorDia;
	}
	
	
	
	
}
