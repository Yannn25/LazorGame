package Vue;

import Modele.*;
import Modele.Laser;
import Modele.Plateau;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import static java.lang.Math.abs;
import javax.swing.*;


public class Vue extends JFrame {


    protected Plateau plat;
    public Graphics2D g2;
    BlocOpaque bloc ;


    public Vue(Plateau p){
        super(" Vue ");
        super.setSize(1275, 800);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.g2 = (Graphics2D) this.getGraphics();
        this.plat = p;



    }

    public Plateau getPlat() {
        return plat;
    }
    public void setPlat(Plateau plat) {
        this.plat = plat;
    }

    @Override
    public void paint(Graphics g){
        Plateau();
        TraceLaser();
        //Pencher();
    }
    /**
     * Méthode qui permet de tracer la trajectoire de chaque laser
     * appartenant à notre plateau PLAT.
     */
    public void TraceLaser(){
        int i=0;
        for (Laser l : plat.getLasers()) {
            //on vérifie bien que l n'est pas null
            if(l != null){
                //on parcours l'ensemble des points de notre laser
                for(Point p : l.getPoints()){
                    if( i < l.getPoints().size()-1){//ici on vérifie que i n'est pas a la dernière position
                        if(l.getPoints().get(i+1) != null){//et la on vérifie que le point suivant n'est pas null
                            Point suiv = l.getPoints().get(i+1);
                            Line2D line = new Line2D.Float(50 + p.y*25,50 + p.x*25, 50 + suiv.y*25, 50 + suiv.x*25);
                            g2.setColor(Color.red);
                            g2.setStroke(new BasicStroke((float) 3.0,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
                            g2.draw(line);
                            i++;
                        }
                    }
                }
            }
        }
    }



    public void Plateau() {
        // plat.init2();
        for(int i=1; i <= plat.getHeight(); i++){
            for(int j=1; j <= plat.getWidth(); j++){
                if(plat.getCase(i-1, j-1) instanceof CaseVisible){
                    g2.setColor(Color.gray.brighter());
                    g2.drawRect(i*50, j*50, 50, 50);
                    if(plat.getCase(i-1, j-1).BlocPresent()){
                        g2.fill3DRect(i*50, j*50, 50, 50, rootPaneCheckingEnabled);
                    }
                }
            }
        }

    }


    public void Cible() {

    }


}
