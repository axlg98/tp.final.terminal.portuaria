package ar.edu.unq.po2.tpFinal.Orden;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpFinal.Cliente.Cliente;
import ar.edu.unq.po2.tpFinal.Container.Container;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLlegada;
	private LocalTime horaLlegada;
	
	public OrdenImportacion(LocalDate fecha,LocalTime hora,Container container,Cliente cliente) {
		super(container,cliente);
		this.setFechaLlegada(fecha);
		this.setHoraLlegada(hora);
	}
	
	public void recibir(Container container,Cliente cliente) {
		
	}
	
	//@Override
	public void horaDeLlegadaCamion(LocalDate time,Camion camion,Chofer chofer) {
		this.setFechaLlegada(time);
		this.setCamionAsignado(camion);
		this.setChoferaAsignado(chofer);
	}
	
	//SET Y GET
	
	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(LocalDate fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	
}
