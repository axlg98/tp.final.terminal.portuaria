package ar.edu.unq.po2.tpFinal;

public abstract class Container {

	private int ancho;
	private int largo;
	private int altura;
	private int peso;
	
	//CONSTRUCTOR
	
	public Container(int ancho, int largo, int altura, int peso) {
		super();
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
		this.peso = peso;
	}
	///////////////////////////
	
	public int volumenDelContainer() {
		
		return this.ancho * this.largo * this.altura;
		
	}

	
	//SET Y GET
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}
