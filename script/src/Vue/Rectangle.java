package Vue;

import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Rectangle extends JPanel {
    protected Plateau plat;
    public static JLabel bloc =new JLabel();
    public static  JLabel pp[]=new JLabel[50];
    public BlocReflechissant br;



    public  Rectangle(Plateau p){



        MouseAdapter ma = new MouseAdapter() {
            JLabel selectionPanel = null;
            Point selectionlabelposition = null;
            Point panelClickposition = null;

            @Override
            public void mousePressed(MouseEvent e) {
                Component pressedComp = findComponentAt(e.getX(), e.getY());
                if (pressedComp != null && pressedComp instanceof JLabel) {

                    selectionPanel = (JLabel) pressedComp;
                    selectionlabelposition = selectionPanel.getLocation();
                    panelClickposition = e.getPoint();
                    super.mousePressed(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("x bloc "+selectionPanel.getX());
                System.out.println("y bloc "+selectionPanel.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectionPanel != null
                        && selectionlabelposition != null
                        && panelClickposition != null && selectionPanel.getName() != "null") {

                    Point newPanelClickPoint = e.getPoint();

                    final int newX = selectionlabelposition.x + (newPanelClickPoint.x - panelClickposition.x),
                            newY = selectionlabelposition.y + (newPanelClickPoint.y - panelClickposition.y);
                    selectionPanel.setLocation(newX, newY);
                    String labelname = this.selectionPanel.getName();
                    switch (labelname) {
                        case "Label22":

                            if (this.selectionPanel.getX() <= 80 && this.selectionPanel.getY() <= 80
                                    || this.selectionPanel.getX() ==130  && this.selectionPanel.getY() <=70
                                    || this.selectionPanel.getX() <=100  && this.selectionPanel.getY() <=90
                            ) {
                                selectionPanel.setLocation(100, 100);

                            }


                            if (this.selectionPanel.getX() == 110 && this.selectionPanel.getY() ==  0
                                    || this.selectionPanel.getY()<=-10 ||
                                    this.selectionPanel.getX()<=80 && this.selectionPanel.getY()<=0
                            ) {
                                selectionPanel.setLocation(100, 0);
                            }
                    }

                }
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);

        bloc.setOpaque(true);
        bloc.setBackground(Color.BLACK);
        bloc.setLayout(null);
        bloc.setBounds(50, 50, 50, 50);
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
        Plateau(g);
        TraceLaser(g);
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
                            Graphics gpl=(Graphics)g2;

                            Line2D line = new Line2D.Float(50 + p.y*25,50 + p.x*25, 50 + suiv.y*25, 50 + suiv.x*25);
                            g2.setColor(Color.red);
                            g2.setStroke(new BasicStroke((float) 4.0,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
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
        for(int i=0; i < plat.getHeight(); i++){
            for(int j=0; j < plat.getWidth(); j++){
                if(plat.getCase(i, j) instanceof CaseVisible){
                    g2.setColor(Color.gray.brighter());
                    g2.drawRect(50+j*50, 50+i*50, 50, 50);
                    if(plat.getCase(i, j).BlocPresent()){
                        g2.fillRect(j*50, i*50, 50, 50);
                    }
                }
            }
        }

    }

}

