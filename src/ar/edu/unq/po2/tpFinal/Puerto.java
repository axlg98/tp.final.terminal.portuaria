package ar.edu.unq.po2.tpFinal;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Puerto {
	
	private String nombre; // nombre del puerto en un determinado pais
	private List<Empresa> empresas;
	private List<Container> containers;
	private List<Chofer> choferesHabilitados;
	
	private List<Consignee> consignees;
	private List<Observador> observersGenerales;
	
	private Point2D ubicacion = new Point2D.Double(0, 0);
	
	private List<EmpresaPortuaria> empresasNavieras;
	
	private EstrategiaMejorRuta mejorRuta;
	
	
	public Puerto(String nombre) {
		super();
		this.nombre = nombre;
		this.empresasNavieras = new ArrayList<EmpresaPortuaria>();
		this.choferesHabilitados = new ArrayList<Chofer>();
		this.containers = new ArrayList<Container>();
		
	}
	
	public void crearOrdenExportacion(Cliente cliente, Container container, Puerto puertoDestino, LocalDateTime fechaYHoraSalida) {

		OrdenExportacion ordenExportacion = new OrdenExportacion(fechaYHoraSalida,container, cliente, puertoDestino);
        cliente.agregarOrden(ordenExportacion);
    
        
    }
	
	
	public void agregarNaviera(EmpresaPortuaria empresaPortuaria) {
		
		this.getEmpresasNavieras().add(empresaPortuaria);
		
	}

	
	public void almacenarContainer(Camion unCamion) {
		
		if (this.getChoferesHabilitados().contains(unCamion.getChofer())) {
			
			this.getContainers().add(unCamion.getContainer());
			
		}
	
		
	}
	
	
	public void agregarContainer(Container container) {
		containers.add(container);
	}
	
	/*
	 * DEBE PODER ENVIAR UNA CARGA DE UN PUERTO A OTRO PUERTO, SIEMPRE Y CUANDO SE PUEDA ENCONTRAR
	   SU CIRCUITO DE ALGUNA NAVIERA QUE TENGA PUERTOS DE ORIGEN Y DESTINO.
    */
	//Arreglar esta parte.
	public void enviarCarga(EmpresaPortuaria emp, Circuito c,Container container) { // DUDA
		if(emp.contieneCircuito(c)  /*&& (this.mismoDestino(emp, c) && this.mismaLlegada(emp, c))*/) {
			this.agregarContainer(container);
		}
	}

	
	public void notificarATodosLosConsignees(Buque buque) {
		
		for (Consignee consignee : consignees) {
			consignee.notificarBuqueA50Km(buque);
		}
	
	}
	
	
	// Mejor Ruta
	public Circuito elMejorCircuito(Puerto puertoDestino) {
		
		return this.mejorRuta.elMejorCircuito(this, puertoDestino);
		
	}
	public void darAvisoClientes() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public void ubicacionDelPuerto(int x, int y){
		
		this.setUbicacion(new Point2D.Double(x, y));
	}
	
	//GET Y SET
	
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
	
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public List<Chofer> getChoferesHabilitados() {
		return choferesHabilitados;
	}
	public void setChoferesHabilitados(List<Chofer> choferesHabilitados) {
		this.choferesHabilitados = choferesHabilitados;
	}
	
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
	public List<Observador> getObserversGenerales() {
		return observersGenerales;
	}
	public void setObserversGenerales(List<Observador> observersGenerales) {
		this.observersGenerales = observersGenerales;
	}
	
	public List<EmpresaPortuaria> getEmpresasNavieras() {
		return empresasNavieras;
	}
	public void setEmpresasNavieras(List<EmpresaPortuaria> empresasNavieras) {
		this.empresasNavieras = empresasNavieras;
	}
	public Point2D getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Point2D ubicacion) {
		this.ubicacion = ubicacion;
	}

	
}
