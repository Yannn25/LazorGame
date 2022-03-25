package Modele;

import java.awt.List;
import java.awt.Point;
import java.util.LinkedList;


public class Laser {

    protected final int x,y;
    // Orientation en degré ?
    // Ou orientation avec un vecteur ? Vx, Vy ?
    protected final int orientation;

    protected LinkedList<Point> points; //LinkedList des points parcouru par le laser

    public Laser(int x,int y, int orientation) {

        this.x=x;
        this.y=y;
        this.orientation=orientation;
        this.points = new LinkedList<>();
        
    }

    public LinkedList<Point> getPoints() {
        return points;
    }
    public void setPoints(LinkedList<Point> points) {
        this.points = points;
    }
    
    public void CalculTrajectoire(){
        
    }
}
