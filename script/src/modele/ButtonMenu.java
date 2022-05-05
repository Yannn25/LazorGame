package modele;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import vue.Rectangle;

public class ButtonMenu extends JButton implements ActionListener{
    private int CommandNumber; /* 1-play,2-continue,3-son,4-retour */
    Rectangle rect;

    public ButtonMenu(int x,int y,int CommandNumber,Rectangle ecran) {
        addActionListener(this);
        this.setBounds(x, y, 200, 100);
        this.CommandNumber = CommandNumber;
        this.rect = ecran;
        setLayout(null);
        setOpaque(true);

        if (CommandNumber == 1) 
        setIcon(new ImageIcon(Rectangle.PATH+"arriereplan.png"));

        if (CommandNumber == 2) 
        setIcon(new ImageIcon(Rectangle.PATH+"arriereplan.png"));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (CommandNumber == 1) 
            rect.SetState(1);

        if (CommandNumber == 2) 
            rect.SetState(2); 
    }

   @Override
   protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        String text = "";

        if (CommandNumber == 1) 
            text = "Play";

        if (CommandNumber == 2)
            text = "Continue";

        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = this.getWidth()/2 - length/2;
        int y = this.getHeight()/2;
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
   }

  

   
    
}
