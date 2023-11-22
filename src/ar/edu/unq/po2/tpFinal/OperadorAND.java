package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class OperadorAND implements OperadorLogico{

	@Override
	public List<Viaje> juntarListas(List<Viaje> xs, List<Viaje> ys) {
		// TODO Auto-generated method stub
		
		xs.retainAll(ys);
		
		return xs;
	}

	
	
}
 