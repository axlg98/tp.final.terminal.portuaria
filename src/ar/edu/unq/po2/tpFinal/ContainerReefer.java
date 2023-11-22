package ar.edu.unq.po2.tpFinal;

public class ContainerReefer extends Container {

	private Double consumoPorHora;
	
	
	public ContainerReefer(int ancho, int largo, int altura, int peso, Double consumoPorHora) {
		super(ancho, largo, altura, peso);
		this.consumoPorHora = consumoPorHora;
	}
	
	@Override
	public Double costoDelContainer() {
		return this.getConsumoPorHora();
	}
	
	//SET Y GET

	public Double getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(Double consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	
	
}
