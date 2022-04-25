import vue.Rectangle;
import modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Test  {


    public static void main(String[] args) {


        LinkedList<Laser[]> tablaser = new LinkedList<>();
        LinkedList<Laser> l = new LinkedList<Laser>();
        l.add(new Laser(4,5, 45));
        l.add(new Laser(3,2, 315));

        Plateau plat = new Plateau(5,5,l);

        //plat.setLasers(l1);
        plat.initdemo();
        plat.initLaser();







        //Vue vue = new Vue(plat);


        Rectangle rects = new Rectangle(plat);
        rects.setLayout(null);
        //rects.setBounds(50,50,300,300);
        rects.setBackground(Color.WHITE);

        JFrame frame = new JFrame("Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(rects);

        rects.addMouseListener(rects.ma);
        rects.addMouseMotionListener(rects.ma);
        for (int i = 0; i < plat.height; i++) {
            for (int j = 0; j < plat.width; j++) {
                if(plat.getCase(i, j).BlocPresent()){
                    rects.bloc[i][j]=new JLabel();
                    rects.bloc[i][j].setOpaque(true);
                    rects.bloc[i][j].setBackground(Color.LIGHT_GRAY);
                    rects.bloc[i][j].setLayout(null);
                    rects.bloc[i][j].setBounds(50*j, 50*i, 50, 50);
                    rects.bloc[i][j].setName("Label22");
                    rects.bloc[i][j].setText("BlocRaf");
                    if (i==2 && j==3){
                        rects.bloc[i][j].setBackground(Color.BLUE);
                        rects.bloc[i][j].setText("BlocAB");
                    }
                    frame.add(rects.bloc[i][j]);
                }
            }
        }

        frame.setVisible(true);


    }

}
