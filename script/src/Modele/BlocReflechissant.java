package Modele;

import java.awt.*;

public class BlocReflechissant extends Bloc {
    
    
    public BlocReflechissant(int x,int y)
    {
            super(x,y,false);
            setSize(50,50);
    }
        
    @Override
    public String getType() {
        return "Reflechissant";
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

                g2d.fillRect(300, 300, 50, 50);
            }

}