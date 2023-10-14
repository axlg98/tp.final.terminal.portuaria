package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Puerto {
	private String nombre; // nombre del puerto en un determinado pais
	private List<Empresa> empresas; //Lista de Empresa.
	
	
	public Puerto(String nombre,List<Empresa> emps) {
		this.setNombre(nombre);
		this.setEmpresas(emps);
	}
	
	//GET Y SET.
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	
}
