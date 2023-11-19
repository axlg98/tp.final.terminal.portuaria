package ar.edu.unq.po2.tpFinal;

public class ContainerReefer extends Container {

	private int consumoPorHora;
	
	
	public ContainerReefer(int ancho, int largo, int altura, int peso, int consumoPorHora) {
		super(ancho, largo, altura, peso);
		this.consumoPorHora = consumoPorHora;
	}

	public int getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(int consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	
	
}
