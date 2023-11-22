package ar.edu.unq.po2.tpFinal;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class OperadorOR implements OperadorLogico{

	@Override
	public List<Viaje> juntarListas(List<Viaje> xs, List<Viaje> ys) {
		// TODO Auto-generated method stub
		
		Set<Viaje> union = new HashSet<>();
		
		union.addAll(xs);
		union.addAll(ys);
		
		List<Viaje> resultado = new ArrayList<>(union);
		
		return resultado;
	}

	
	
}
 