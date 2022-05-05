package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenuBar;


import vue.Rectangle;


public class MenuBar extends JMenuBar{
    ButtonMenu retour;
    ButtonMenu sound;
    Rectangle rec;

    public MenuBar(Rectangle rect) {
        this.rec = rect;
        setLayout(null);
        this.setForeground(Color.black);
        this.setBackground(Color.black);
        this.setBounds(0, 0, rect.getWidth(), 50);
        this.retour = new ButtonMenu(0, 0, 4, this);
        add(retour);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());

    }
    
}
