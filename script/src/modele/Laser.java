package modele;

import java.awt.Point;
//import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;


public class Laser implements Serializable{

   // @Serial
    private static final long serialVersionUID = 3296324048652923361L;

    protected final int x,y;
    // Orientation en degré ?
    // Ou orientation avec un vecteur ? Vx, Vy ?
    protected int orientation;

    protected LinkedList<Point> points; //LinkedList des points parcouru par le laser

    /*   CONSTRUCTEUR  */
    //Il ne peut que y qvoir des lasers à des positions (paire, impaire) où (impaire, paire)
    public Laser(int x,int y, int orientation){
        if(((x%2 == 0) && (y%2==0)) || ((x%2 == 1) && (y%2==1))){
            throw new IllegalArgumentException("Il ne peut pas y avoir de laser à cet endroit là: " + x + ", " + y);
        }
        this.x=x;
        this.y=y;
        this.orientation=orientation;
        this.points = new LinkedList<>();

    }

    /*   GETTER ET SETTER   */
    public LinkedList<Point> getPoints() {
        return points;
    }
    public void setPoints(LinkedList<Point> points) {
        this.points = points;
    }
    
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}
