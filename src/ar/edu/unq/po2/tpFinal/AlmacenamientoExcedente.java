package ar.edu.unq.po2.tpFinal;

public class AlmacenamientoExcedente implements Servicio{
	public Double diaDemorado;
	public Cliente cliente;

	public AlmacenamientoExcedente(Double diaDemorado, Cliente cliente) {
		this.diaDemorado = diaDemorado;
		this.cliente = cliente;
	}
	
	@Override
	public Double costoServicio(Orden orden) {
		return this.getDiaDemorado() * cliente.getCarga().costoDelContainer() /** VER COMO HACER */ ;
	}
	
	//GET Y SET
	
	public Double getDiaDemorado() {
		return diaDemorado;
	}
	public void setDiaDemorado(Double diaDemorado) {
		this.diaDemorado = diaDemorado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente consignee) {
		this.cliente = cliente;
	}
}
