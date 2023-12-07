package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


import ar.edu.unq.po2.tpFinal.Buque.Buque;

import ar.edu.unq.po2.tpFinal.Circuito.Circuito;
import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Cliente.Consignee;
import ar.edu.unq.po2.tpFinal.Cliente.Mail;
import ar.edu.unq.po2.tpFinal.Cliente.Shipper;
import ar.edu.unq.po2.tpFinal.Cliente.Turno;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.EstrategiaMejorRuta.EstrategiaMejorRuta;
import ar.edu.unq.po2.tpFinal.Naviera.Naviera;
import ar.edu.unq.po2.tpFinal.Orden.Orden;
import ar.edu.unq.po2.tpFinal.Orden.OrdenExportacion;
import ar.edu.unq.po2.tpFinal.Orden.OrdenImportacion;

import java.util.ArrayList;

public class Puerto {
	
	private String nombre; // nombre del puerto en un determinado pais
	
	private List<Container> containers;
	private List<Chofer> choferesHabilitados;
	
	private List<Consignee> consignees;
	private List<Shipper> shippers;
	
	
	private Point2D ubicacion = new Point2D.Double(0, 0);
	
	private List<Naviera> navieras;
	
	private EstrategiaMejorRuta mejorRuta;
	
	private List<Orden> ordenes;
	
	private List<Buque> buquesInbound;
	
	private List<Buque> buquesDeparting;
	
	
	
	public Puerto(String nombre) {
		super();
		this.nombre = nombre;
		this.navieras = new ArrayList<Naviera>();
		this.choferesHabilitados = new ArrayList<Chofer>();
		this.containers = new ArrayList<Container>();
		this.buquesInbound = new ArrayList<Buque>();
		this.buquesDeparting = new ArrayList<Buque>();
		this.consignees = new ArrayList<Consignee>();
		this.shippers = new ArrayList<Shipper>();
		
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
	
	public List<Shipper> getShippers() {
		return shippers;
	}

	public void setShippers(List<Shipper> shippers) {
		this.shippers = shippers;
	}

	public void agregarShipper(Shipper shipper) {
		
		this.getShippers().add(shipper);
		
	}
	

	public List<Naviera> getNavieras() {
		return navieras;
	}
	public void setNavieras(List<Naviera> navieras) {
		this.navieras = navieras;
	}
	public Point2D getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Point2D ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void crearOrdenExportacion(Cliente cliente, Container container, Puerto puertoDestino, Camion Camion,List<Circuito> circuitos) {

		Circuito circuito = this.getMejorRuta().elMejorCircuito(this,puertoDestino,circuitos);
		circuito.setFechaYHoraDeSalida(LocalDateTime.of(2023, 12, 3, 10, 30));
		OrdenExportacion ordenExportacion = new OrdenExportacion(container, cliente, puertoDestino, circuito,circuito.getFechaYHoraDeSalida());
		ordenExportacion.setFechaYHoraSalida(circuito.getFechaYHoraDeSalida());
		ordenExportacion.setCamion(Camion);
		ordenExportacion.setChofer(Camion.getChofer());
        
        cliente.setTurno(new Turno(ordenExportacion, ordenExportacion.getFechaYHoraSalida()));
        
        this.agregarOrden(ordenExportacion);
        
        
    }
	
	public void crearOrdenImportacion(Cliente cliente, Container container,LocalDate fecha,LocalTime time) {
		OrdenImportacion ordenImportacion = new OrdenImportacion(fecha, time,container,cliente);
		this.agregarOrden(ordenImportacion);;
		
	}
	
	public void agregarNaviera(Naviera naviera) {
		
		this.getNavieras().add(naviera);
		
	}

	
	public void almacenarContainer(Camion unCamion) {
		
		if (this.getChoferesHabilitados().contains(unCamion.getChofer())) {
			
			this.getContainers().add(unCamion.getContainer());
			
		}
	
		
	}
	
	
	public void agregarContainer(Container container) {
		containers.add(container);
	}
		
	
	public void darAvisoAClientesConsignee() {
		
		for (Consignee consignee : consignees) {
			
			
			for (Buque buqueInbound : buquesInbound) {
				
				
				consignee.notificarBuqueA50Km(new Mail(buqueInbound, buqueInbound.getNombre(), "El buque se encuentra proximo a arribar"));
				
			}
			
		}
	
	}
	
	public void darAvisoClientesShipper() {
		
		for (Shipper shipper : shippers) {
			
			for (Buque buque : buquesDeparting) {
				
				shipper.notificarBuqueA1km(new Mail(buque, buque.getNombre(), "El buque se encuentra partiendo ya a 1km de distancia"));
				
			}
			
		}
		
		
		
	}
	
	
	
	
	
	// Mejor Ruta
	public Circuito elMejorCircuito(Puerto puertoDestino,List<Circuito> circuitos) {
		
		return this.mejorRuta.elMejorCircuito(this, puertoDestino,circuitos);
		
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

	
	


	public List<Buque> getBuquesDeparting() {
		return buquesDeparting;
	}



	public void setBuquesDeparting(List<Buque> buquesDeparting) {
		this.buquesDeparting = buquesDeparting;
	}



	public void buqueAMenosDe50km(Buque buque) {
		
		this.getBuquesInbound().add(buque);
		
	}

	public void buquePartiendoA1Km(Buque buque) {
		
		this.getBuquesDeparting().add(buque);
		
	}


	public void trabajoCargaYDescarga(Buque buque1) {
		
		buque1.setPuedeDescargar(true);
		
	}

	

	
	
	
	
}
