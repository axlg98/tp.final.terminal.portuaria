package ar.edu.unq.po2.tpFinal.Filtros;

import java.util.List;
import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.Circuito.Viaje;

public class OperadorAND implements OperadorLogico{

	@Override
	public List<Viaje> juntarListas(List<Viaje> xs, List<Viaje> ys) {
		// TODO Auto-generated method stub
		
		List<Viaje> resultado = new ArrayList<>(xs);
        resultado.retainAll(ys);
        return resultado;
	}

	
	
}
 