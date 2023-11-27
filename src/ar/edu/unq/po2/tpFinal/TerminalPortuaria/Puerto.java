package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Observador;
import ar.edu.unq.po2.tpFinal.Buque.Buque;
import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Cliente.Consignee;
import ar.edu.unq.po2.tpFinal.Cliente.Mail;
import ar.edu.unq.po2.tpFinal.Cliente.Turno;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta.EstrategiaMejorRuta;
import ar.edu.unq.po2.tpFinal.Naviera.Naviera;
import ar.edu.unq.po2.tpFinal.Orden.Orden;
import ar.edu.unq.po2.tpFinal.Orden.OrdenExportacion;

import java.util.ArrayList;

public class Puerto {
	
	private String nombre; // nombre del puerto en un determinado pais
	
	private List<Container> containers;
	private List<Chofer> choferesHabilitados;
	
	private List<Consignee> consignees;
	private List<Observador> observersGenerales;
	
	private Point2D ubicacion = new Point2D.Double(0, 0);
	
	private List<Naviera> empresasNavieras;
	
	private EstrategiaMejorRuta mejorRuta;
	
	private List<Orden> ordenes;
	
	private List<Buque> buquesInbound;
	
	
	public Puerto(String nombre) {
		super();
		this.nombre = nombre;
		this.empresasNavieras = new ArrayList<Naviera>();
		this.choferesHabilitados = new ArrayList<Chofer>();
		this.containers = new ArrayList<Container>();
		this.buquesInbound = new ArrayList<Buque>();
		this.consignees = new ArrayList<Consignee>();
		this.ordenes = new ArrayList<Orden>();
	}
	
	 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public List<Naviera> getEmpresasNavieras() {
		return empresasNavieras;
	}
	public void setEmpresasNavieras(List<Naviera> empresasNavieras) {
		this.empresasNavieras = empresasNavieras;
	}
	public Point2D getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Point2D ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void crearOrdenExportacion(Cliente cliente, Container container, Puerto puertoDestino, Camion Camion) {

		Circuito circuito = this.mejorRuta.elMejorCircuito(this, puertoDestino);
		OrdenExportacion ordenExportacion = new OrdenExportacion(container, cliente, puertoDestino, circuito);
		ordenExportacion.setFechaYHoraSalida(circuito.getFechaYHoraDeSalida());
		ordenExportacion.setCamion(Camion);
		ordenExportacion.setChofer(Camion.getChofer());
        
		
        cliente.setTurno(new Turno(ordenExportacion, ordenExportacion.getFechaYHoraSalida()));
        
        this.agregarOrden(ordenExportacion);
        
        
    }
	
	
	public void agregarNaviera(Naviera empresaPortuaria) {
		
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
//	public void enviarCarga(EmpresaPortuaria emp, Circuito c,Container container) { // DUDA
//		if(emp.contieneCircuito(c)  /*&& (this.mismoDestino(emp, c) && this.mismaLlegada(emp, c))*/) {
//			this.agregarContainer(container);
//		}
//	}

	
	
	
	public void notificarATodosLosConsignees() {
		
		for (Consignee consignee : consignees) {
			
			
			for (Buque buqueInbound : buquesInbound) {
				
				
				consignee.notificarBuqueA50Km(new Mail(buqueInbound, buqueInbound.getNombre(), "El buque se encuentra proximo a arribar"));
				
			}
			
		}
	
	}
	
	
	// Mejor Ruta
	public Circuito elMejorCircuito(Puerto puertoDestino) {
		
		return this.mejorRuta.elMejorCircuito(this, puertoDestino);
		
	}
	
	
	public void ubicacionDelPuerto(int x, int y){
		
		this.setUbicacion(new Point2D.Double(x, y));
	}



	public EstrategiaMejorRuta getMejorRuta() {
		return mejorRuta;
	}



	public void setMejorRuta(EstrategiaMejorRuta mejorRuta) {
		this.mejorRuta = mejorRuta;
	}



	public List<Orden> getOrdenes() {
		return ordenes;
	}



	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public void agregarOrden(Orden orden) {
		
		this.getOrdenes().add(orden);
		
	}

	

	



	public List<Buque> getBuquesInbound() {
		return buquesInbound;
	}



	public void setBuquesInbound(List<Buque> buquesInbound) {
		this.buquesInbound = buquesInbound;
	}



	public void buqueAMenosDe50km(Buque buque) {
		
		this.getBuquesInbound().add(buque);
		
	}



	public void darAvisoClientes() {
		
	}



	public void trabajoCargaYDescarga(Buque buque1) {
		// TODO Auto-generated method stub
		
		buque1.actualizarEstado();
		
	}
	
	
	
	
}
