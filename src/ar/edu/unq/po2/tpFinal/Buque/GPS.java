package ar.edu.unq.po2.tpFinal.Buque;

import java.awt.geom.Point2D;

public class GPS {
	
	public GPS() {
		
	}
	
	public static double calcularDistancia(Point2D punto1, Point2D punto2) {
        double x1 = punto1.getX();
        double y1 = punto1.getY();
        double x2 = punto2.getX();
        double y2 = punto2.getY();

        // Calcula la distancia entre los dos puntos
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
	
	
	
	
}
