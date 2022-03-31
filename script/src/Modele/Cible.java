package Modele;

import java.awt.Point;

public class Cible {

	protected final Point p;
        protected boolean atteint;
	
	public Cible(int x, int y) {
		
		this.p=new Point(x,y);
		
	}
	
}
