package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Puerto {
	private String nombre; // nombre del puerto en un determinado pais
	private List<Empresa> empresas; //Lista de Empresa.
	private List<Chofer> choferesHabilitados;
	private List<Container> containers;


	public Puerto(String nombre,List<Empresa> emps,List<Chofer> cs,List<Container> crs) {
		this.setNombre(nombre);
		this.setEmpresas(emps);
		this.setChoferesHabilitados(cs);
		this.setContainers(crs);		
	}

	public void almacenarContainer(Camion camion) {
		if(this.getChoferesHabilitados().contains(camion.getChofer())) {
			this.agregarContainer(camion.getContainer());
		}
	}
	
	public void agregarContainer(Container container) {
		containers.add(container);
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
	
	public List<Chofer> getChoferesHabilitados() {
		return choferesHabilitados;
	}

	public void setChoferesHabilitados(List<Chofer> choferesHabilitados) {
		this.choferesHabilitados = choferesHabilitados;
	}
	
	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
	
}
