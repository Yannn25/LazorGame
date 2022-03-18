package Vue;

import Modele.*;
import Modele.Laser;
import Modele.Plateau;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;


public class Vue extends JFrame {

    
    protected Plateau plat;
    private Graphics2D g2;
    
    public Vue(Plateau p){ 
        super(" Vue ");
        super.setSize(1200, 700);
        super.setVisible(true);
        //super.setLayout(null);
        //super.setLocationRelativeTo(null);
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
        //setBackground(Color.white);
    }
    /**
     * Méthode qui permet de tracer la trajectoire de chaque laser
     * appartenant à notre plateau PLAT.
     * @param g
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
                            Line2D line = new Line2D.Float(p.x*98, p.y*98, suiv.x*44, suiv.y*44);
                            g2.setColor(Color.red);
                            g2.setStroke(new BasicStroke((float) 2.0,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
                            g2.draw(line);
                            i++;
                        }
                    }
                }
            }
        }   
    }
    


    public void Plateau(){
        plat.init2();
        for(int i=8; i <= 8*plat.getWidth(); i+=8){
            for(int j=8; j <= 8*plat.getHeight(); j+=8){
                //    if(plat.getCase(i/10, j/10) instanceof CaseVisible){
                    g2.setColor(Color.gray.brighter());
                    g2.drawRect(13*i, 13*j, 100, 100);
                  //  if(plat.getCase(i/10, j/10).BlocPresent()){
                    //    g2.fill3DRect(15*i, 15*j, 100, 100, rootPaneCheckingEnabled);
                    //}
                //}                    
            }
        }
    }
    
    public void Cible() {
        
    }
    
    
}