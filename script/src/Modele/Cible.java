package Modele;

import java.awt.Point;
import java.util.LinkedList;

public class Cible {

	protected final Point p;
	protected boolean atteint;

    public Point getPoint() {
        return p;
    }

    public boolean isAtteint() {
        return atteint;
    }
        
    public Cible(int x, int y) {
        atteint = false;
        this.p=new Point(x,y);	
    }
	
}
