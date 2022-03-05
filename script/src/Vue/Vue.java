package Vue;

import Modele.Laser;
import Modele.Plateau;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.JFrame;

public class Vue extends JFrame{
  
    protected Plateau plat;
    
    public Vue(){
        super(" Vue ");
        super.setSize(900, 600);
        super.setVisible(true);
        super.setLayout(null);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Plateau getPlat() {
        return plat;
    }
    public void setPlat(Plateau plat) {
        this.plat = plat;
    }
    
    /**
     * Méthode qui permet de tracer la trajectoire de chaque laser
     * appartenant à notre plateau PLAT.
     * @param g
     */
    public void TraceLaser(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int i=0;
        for (Laser l : plat.getLasers()) {
            if(l != null){
                for(Point p : l.getPoints()){
                    if( i < l.getPoints().size()-1){
                        if(l.getPoints().get(i+1) != null){
                            Point suiv = l.getPoints().get(i+1);
                            Line2D line = new Line2D.Float(p.x, p.y, suiv.x, suiv.y);
                            g2.setColor(Color.red);
                            g2.setStroke(new BasicStroke((float) 2.0));
                            g2.draw(line);                           
                            i++;
                        }
                    }
                }
            }
        }
        
    }
    
    
    
}