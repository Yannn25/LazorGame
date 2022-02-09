package Modele;

import java.awt.Point;
import java.util.LinkedList;

public class Laser {

	protected final int x,y;
	// Orientation en degr� ?
	// Ou orientation avec un vecteur ? Vx, Vy ?
	protected final int orientation;
	
	protected LinkedList<Point> points; //LinkedList des points parcouru par le laser
	
	public Laser(int x,int y, int orientation) {
		
		this.x=x;
		this.y=y;
		this.orientation=orientation;
		
	}
	
}
