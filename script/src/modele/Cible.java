package modele;

import java.awt.Point;
//import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;

public class Cible implements Serializable{


    private static final long serialVersionUID = 7073363957831599093L;

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
