package modele;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import vue.Rectangle;


public class MenuBar extends JPanel{
    ButtonMenu retour;
    ButtonMenu sound;
    Rectangle rec;

    public MenuBar(Rectangle rect) {
        setLayout(null);
        
        this.setBackground(Color.black);
        this.setBounds(0, 0, rect.getWidth(), 50);
        this.retour = new ButtonMenu(5, 5, 4, this);
        add(retour);
    }
    
}
