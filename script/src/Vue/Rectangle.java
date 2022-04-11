package Vue;

import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Rectangle extends JPanel {
    protected Plateau plat;
    public JLabel[][] bloc;
    public MouseAdapter ma;
    public FinDePartie fin;


    public Rectangle(Plateau p){

            ma = new MouseAdapter() {
            JLabel selectionPanel = null;
            Point selectionlabelposition = null;
            Point panelClickposition = null;
            //coordonnées en pixels de la nouvelle position du bloc quand il est déplacé avec la souris
            int newX, newY;
            //coordonnées dans le tableau de la nouvelle position du bloc quand il est déplacé avec la souris
            int newI, newJ;

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
                if(newI > 0 && newJ > 0 && newJ <= p.getWidth() && newI <= p.getHeight()){
                    selectionPanel.setLocation((newJ)*50, (newI)*50);
                    plat.deplacerBloc(selectionlabelposition.y/50, selectionlabelposition.x/50, newI, newJ);
                    plat.initLaser();
                    selectionlabelposition.y = newI*50;
                    selectionlabelposition.x = newJ*50;
                    repaint();
                }

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectionPanel != null
                        && selectionlabelposition != null
                        && panelClickposition != null && selectionPanel.getName() != "null") {

                    Point newPanelClickPoint = e.getPoint();

                    newX = selectionlabelposition.x + (newPanelClickPoint.x - panelClickposition.x);
                    newY = selectionlabelposition.y + (newPanelClickPoint.y - panelClickposition.y);
                    newI = newY/50;
                    newJ = newX/50;
                    if(newI > 0 && newJ > 0 && newJ <= p.getWidth() && newI <= p.getHeight()){
                        selectionPanel.setLocation((newJ)*50, (newI)*50);
                    }

                }
            }
        };

        bloc = new JLabel[p.getHeight()][p.getWidth()];

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
        Cible(g);
        if(plat.isWin()){
            fin = new FinDePartie();
        }
    }
    
    public void TerminerPartie(Graphics g) {
      
    }
    public void paintFin(Graphics g) {
        //super.paintComponent(g);
        Plateau(g);
        TraceLaser(g);
        Cible(g);
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
        for(int i=1; i < plat.getHeight(); i++){
            for(int j=1; j < plat.getWidth(); j++){
                if(plat.getCase(i, j) instanceof CaseVisible){
                    g2.setColor(Color.gray.brighter());
                    g2.drawRect(j*50, i*50, 50, 50);
                    if(plat.getCase(i, j).BlocPresent()){
                        g2.fillRect(j*50, i*50, 50, 50);
                    }
                }
            }
        }

    }
    
    public void Cible(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < plat.getCibles().length; i++) {
            int x = plat.getCibles()[i].getPoint().x;
            int y = plat.getCibles()[i].getPoint().y;
            int diametre = 7;
            if(plat.getCibles()[i].isAtteint()) {
                g2.setColor(Color.GREEN);
                g2.fillOval(50-diametre/2+y*25, 50-diametre/2+x*25, diametre, diametre);
            } else {
                 g2.setColor(Color.red);
                 g2.fillOval(50-diametre/2+y*25, 50-diametre/2+x*25, diametre, diametre);
            }
               
        }  
    }

}

