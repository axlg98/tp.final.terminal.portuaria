package ar.edu.unq.po2.tpFinal;

public class AlmacenamientoExcedente implements Servicio{
	public Double diaDemorado;
	public Consignee consignee;
	
	@Override
	public Double costoServicio(Orden orden) {
		return this.getDiaDemorado()/** VER COMO HACER */ ;
	}
	
	//GET Y SET
	
	public Double getDiaDemorado() {
		return diaDemorado;
	}
	public void setDiaDemorado(Double diaDemorado) {
		this.diaDemorado = diaDemorado;
	}
}
