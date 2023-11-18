package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenExportacion extends Orden{
	private LocalDate fechaEnvio;
	private LocalTime horaDeEnvio;
	
	public OrdenExportacion(LocalDate fecha, LocalTime hora) {
		this.setFechaEnvio(fecha);
		this.setHoraDeEnvio(hora);
	}
	
	public void enviar(Container container /*, Cliente cliente*/) {
		
	}
	
	@Override
	public void horaDeLlegadaCamion(LocalDate time,Camion camion,Chofer chofer) {
		
	}
	
	//SET Y GET
	
	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public LocalTime getHoraDeEnvio() {
		return horaDeEnvio;
	}
	public void setHoraDeEnvio(LocalTime horaDeEnvio) {
		this.horaDeEnvio = horaDeEnvio;
	}
	
	

}
