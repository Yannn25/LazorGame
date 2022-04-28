package vue;

import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class Rectangle extends JLabel {
    protected Plateau plat;
    public JLabel[][] bloc;
    public MouseAdapter ma;

    public static final String PATH="Icone\\";




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
                if (pressedComp != null && pressedComp instanceof JLabel && pressedComp.getName()=="Bloc") {

                    selectionPanel = (JLabel) pressedComp;
                    selectionlabelposition = selectionPanel.getLocation();
                    panelClickposition = e.getPoint();
                    super.mousePressed(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(newI > 0 && newJ > 0 && newJ < p.getWidth() && newI < p.getHeight() &&
                        p.deplacementPossible(selectionlabelposition.y/50, selectionlabelposition.x/50, newI, newJ)){
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
                    if(newI > 0 && newJ > 0 && newJ < p.getWidth() && newI < p.getHeight() &&
                            p.deplacementPossible(selectionlabelposition.y/50, selectionlabelposition.x/50, newI, newJ)){
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
    }

    public void TraceLaser(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //int i=0;
        for (Laser l : plat.getLasers()) {
            //on vérifie bien que l n'est pas null
            if(l != null){
                //on parcours l'ensemble des points de notre laser
                Point p, suiv;
                for(int i = 0; i<l.getPoints().size()-1; i++){
                    if(l.getPoints().get(i+1) != null){//et la on vérifie que le point suivant n'est pas null
                        p = l.getPoints().get(i);
                        suiv = l.getPoints().get(i+1);
                        Graphics gpl = (Graphics)g2;
                        Line2D line = new Line2D.Float(50 + p.y*25,50 + p.x*25, 50 + suiv.y*25, 50 + suiv.x*25);
                        g2.setColor(Color.red);
                        g2.setStroke(new BasicStroke((float) 4.0,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
                        g2.draw(line);

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
                    int thickness = 2;
                    Stroke oldStroke = g2.getStroke();
                    g2.setStroke(new BasicStroke(thickness));
                    //g2.fillRect(j*50, i*50, 47, 47);
                    //g2.drawRect(x, y, width, height);
                   Image img1 = Toolkit.getDefaultToolkit().getImage(PATH+"case.png");
                    g2.drawImage(img1, j*50, i*50, this);
                    if(plat.getCase(i, j).BlocPresent()){
                        g2.fillRect(j*50, i*50, 50, 50);

                    }
                }
            }
        }
    }

    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }


}

