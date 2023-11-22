package ar.edu.unq.po2.tpFinal;

public class AlmacenamientoExcedente implements Servicio{
	public int diaDemorado;
	public Consignee consignee;
	
	@Override
	public Double costoServicio(Orden orden) {
		return this.diaDemorado /** VER COMO HACER */ ;
	}
	
	//GET Y SET
	
	public int getDiaDemorado() {
		return diaDemorado;
	}
	public void setDiaDemorado(int diaDemorado) {
		this.diaDemorado = diaDemorado;
	}
}
