package ar.edu.unq.po2.tpFinal.Filtros;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;
 
public class FiltroCombinado implements Filtro{

	private OperadorLogico conector;
	private Filtro filtro1;
	private Filtro filtro2;
	 
	
	
	@Override
	public List<Viaje> buscarEn(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		
		List<Viaje> resultadoFiltro1 = this.getFiltro1().buscarEn(viajes);
		List<Viaje> resultadoFiltro2 = this.getFiltro2().buscarEn(viajes);
		
		
		
		return this.getConector().juntarListas(resultadoFiltro1, resultadoFiltro2);
	}



	public OperadorLogico getConector() {
		return conector;
	}



	public void setConector(OperadorLogico conector) {
		this.conector = conector;
	}



	public Filtro getFiltro1() {
		return filtro1;
	}



	public void setFiltro1(Filtro filtro1) {
		this.filtro1 = filtro1;
	}



	public Filtro getFiltro2() {
		return filtro2;
	}



	public void setFiltro2(Filtro filtro2) {
		this.filtro2 = filtro2;
	}
	
	
	
	
	
}
