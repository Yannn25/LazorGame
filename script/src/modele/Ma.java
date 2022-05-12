package modele;

import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.JLabel;


import vue.Rectangle;

import java.awt.event.*;


public class Ma extends MouseAdapter{
    Rectangle rect;
    Plateau plat;
    JLabel selectionPanel = null;
    Point selectionlabelposition = null;
    Point panelClickposition = null;
        //coordonnées en pixels de la nouvelle position du bloc quand il est déplacé avec la souris
    int newX, newY;
            //coordonnées dans le tableau de la nouvelle position du bloc quand il est déplacé avec la souris
    int newI, newJ;

    public Ma(Plateau p,Rectangle r){
        this.plat = p;
        this.rect = r;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Component pressedComp = rect.findComponentAt(e.getX(), e.getY());
                if (pressedComp != null && pressedComp instanceof JLabel && "Bloc".equals(pressedComp.getName())) {

                    selectionPanel = (JLabel) pressedComp;
                    selectionlabelposition = selectionPanel.getLocation();
                    panelClickposition = e.getPoint();
                    super.mousePressed(e);
                }
        
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        if(newI > 0 && newJ > 0 && newJ < plat.getWidth() && newI < plat.getHeight() &&
        plat.deplacementPossible(selectionlabelposition.y/50, selectionlabelposition.x/50, newI, newJ)){
        selectionPanel.setLocation((newJ)*50, (newI)*50);
        plat.deplacerBloc(selectionlabelposition.y/50, selectionlabelposition.x/50, newI, newJ);
        plat.initLaser();
        selectionlabelposition.y = newI*50;
        selectionlabelposition.x = newJ*50;
        rect.repaint();
}
    }

    

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectionPanel != null && selectionlabelposition != null && panelClickposition != null && selectionPanel.getName() != "null") {
            Point newPanelClickPoint = e.getPoint();

            newX = selectionlabelposition.x + (newPanelClickPoint.x - panelClickposition.x);
            newY = selectionlabelposition.y + (newPanelClickPoint.y - panelClickposition.y);
            newI = newY/50;
            newJ = newX/50;
            if(newI > 0 && newJ > 0 && newJ < plat.getWidth() && newI < plat.getHeight() && plat.deplacementPossible(selectionlabelposition.y/50, selectionlabelposition.x/50, newI, newJ)){
                selectionPanel.setLocation((newJ)*50, (newI)*50);
            }else {
                newX = selectionlabelposition.x;
                newY = selectionlabelposition.y;
                newI = newY / 50;
                newJ = newX / 50;

                selectionPanel.setLocation((newJ) * 50, (newI) * 50);
                }
        }       
        
    
    
    }
}
