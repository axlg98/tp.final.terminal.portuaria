package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Buque {
private List <Container> containers;
	
	public Buque(List<Container> cs) {
		this.setContainers(cs);
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
}
