package Modele;

import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class Rectangle extends JPanel {
    protected Plateau plat;
    public static JPanel bloc =new JPanel();



    public  Rectangle(Plateau p){

        bloc.setBackground(Color.BLACK);
        bloc.setLayout(null);
        bloc.setBounds(500, 160, 50, 50);
        bloc.setName("Label22");
        setComponentZOrder(bloc, 0);

        this.plat = p;
        setLayout(null);
        this.setFocusable(true);
        this.setLayout(null);

    }

    public Plateau getPlat() {
        return plat;
    }
    public void setPlat(Plateau plat) {
        this.plat = plat;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw(g);
        Plateau(g);
        TraceLaser(g);
    }


    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++) {
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillRect(50+j*55, 50+i*55, 50, 50);
            }
        }
    }


    public void TraceLaser(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
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




    public void Plateau(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // plat.init2();
        for(int i=1; i <= plat.getWidth(); i++){
            for(int j=1; j <= plat.getHeight(); j++){
                if(plat.getCase(i-1, j-1) instanceof CaseVisible){
                    g2.setColor(Color.gray.brighter());
                    g2.drawRect(i*50, j*50, 50, 50);
                    if(plat.getCase(i-1, j-1).BlocPresent()){
                        g2.fillRect(i*50, j*50, 50, 50);
                    }
                }
            }
        }

    }

}

