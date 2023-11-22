package ar.edu.unq.po2.tpFinal;

public class Pesado implements Servicio{
	
	@Override
	public Double costoServicio(Orden orden) {
		return 500D;
	}
}
