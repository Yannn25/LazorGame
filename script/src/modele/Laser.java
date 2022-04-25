package modele;

import java.awt.List;
import java.awt.Point;
import java.util.LinkedList;


public class Laser {

    protected final int x,y;
    // Orientation en degré ?
    // Ou orientation avec un vecteur ? Vx, Vy ?
    protected int orientation;
    protected int indexlaser;

    protected LinkedList<Point> points; //LinkedList des points parcouru par le laser

    public Laser(int x,int y, int orientation,int indexLaser) {

        this.x=x;
        this.y=y;
        this.orientation=orientation;
        this.points = new LinkedList<>();
        this.indexlaser=indexLaser;

    }

    public LinkedList<Point> getPoints() {
        return points;
    }
    public void setPoints(LinkedList<Point> points) {
        this.points = points;
    }

    public void CalculTrajectoire(){

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getIndexlaser(){
        return this.indexlaser;
    }

    public void setIndexlaser(int index){
        this.indexlaser=index;
    }

    public void recupPointdeviation(int x ,int yCasVisible){
        for (Point pt: points){

        }
    }

}
