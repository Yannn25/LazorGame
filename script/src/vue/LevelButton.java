package vue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Plateau;
import vue.Rectangle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelButton extends JButton implements ActionListener{
    private int BlocNumber; /* 1-absorbant,2-Opaque,3-prisme,4-Reflechissant,5-semi-reflechissant,6-tp*/
    Rectangle rect;

    public LevelButton(int x,int y,int CommandNumber,Rectangle ecran) {
        this.setBounds(x, y, 280, 80);
        this.rect = ecran;
        this.BlocNumber = CommandNumber;
        setLayout(null);
        setOpaque(true);
        setIcon(new ImageIcon(Rectangle.PATH +"arriereplan.png"));

        JLabel blocPanel = new JLabel();
        blocPanel.setLayout(null);
        blocPanel.setOpaque(true);
        blocPanel.setBounds(225, 15, 50, 50);
        blocPanel.setIcon(new ImageIcon(Rectangle.PATH + "Blocreflechissant.png"));
        add(blocPanel);
        addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (BlocNumber) {
            case 1:
                rect.setPlat(new Plateau(1));
                break;
            case 2:
                rect.setPlat(new Plateau(2));
                break;
            case 3:
                rect.setPlat(new Plateau(3));
                break;
            case 4:
                rect.setPlat(new Plateau(4));
                break;
            case 5:
                rect.setPlat(new Plateau(5));
                break;
            case 6:
                rect.setPlat(new Plateau(6));
                break;
        }
        rect.SetState(2);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
 
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,25F));

        String text = "BLOC";

        if (BlocNumber == 1) 
            text = "Niveau 1";

        if (BlocNumber == 2)
            text = "Niveau 2";

        if (BlocNumber == 3)
            text = "Niveau 3";

        if (BlocNumber == 4)
            text = "Niveau 4";

        if (BlocNumber == 5)
            text = "Niveau 5";

        if (BlocNumber == 6)
            text = "Niveau 6";
        

        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = this.getWidth()/3 - length/2;
        int y = this.getHeight()/2;
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
         
    }
    
}
