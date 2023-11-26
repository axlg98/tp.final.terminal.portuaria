package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.EmpresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.Orden.Orden;

public class Terminal {

	private List<Puerto> puertos;

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}
	
	
	private void validarEntregaTerrestreExp(Orden orden, Camion camion, Chofer chofer) throws Exception {
		this.validarCamion(camion, orden);
		this.validarChofer(chofer, orden);
		this.validarHoraDeEntrega(orden);
		orden.entregaContainer();
	}
	
	
	
	private void validarChofer(Chofer chofer, Orden orden) throws Exception {
		// TODO Auto-generated method stub
		
		if (chofer.getNombre() != orden.getChoferaAsignado().getNombre()) {
			
			throw new Exception ("Chofer no valido");
			
		}
		
	}

	private void validarHoraDeEntrega(Orden orden) throws Exception {
		
		if ( orden.getTurno().getFechaYHora().getHour() - LocalDateTime.now().getHour() > 3 ) {
			
			throw new Exception ("Llegaste tarde");
			
		}
		
		
	}
	
	
	private void validarCamion(Camion camion, Orden orden) throws Exception {
		if ( camion != orden.getCamionAsignado() ) {
			
			throw new Exception ("Camion no valido");
			
		}
	}
	
	
	
	
	
	
	
	
	
}
