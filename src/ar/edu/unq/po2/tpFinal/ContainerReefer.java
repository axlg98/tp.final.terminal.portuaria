package ar.edu.unq.po2.tpFinal;

public class ContainerReefer extends Container {

	private int consumoPorHora;
	
	public ContainerReefer(String descripcion, int consumoPorHora) {
		super(descripcion);
		this.consumoPorHora = consumoPorHora;
		
		// TODO Auto-generated constructor stub
	}

	public int getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(int consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	
	
}
