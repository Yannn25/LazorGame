package Test;

import Vue.Rectangle;
import Modele.*;

import javax.swing.*;
import java.awt.*;
//import java.awt.Graphics2D;
//import java.awt.Point;
//import java.awt.Rectangle;
//import java.awt.Shape;
//import java.awt.geom.AffineTransform;
//import java.awt.geom.Line2D;
//import java.awt.geom.Rectangle2D;
//import java.util.LinkedList;

public class Test  {


    public static void main(String[] args) {

        Plateau plat = new Plateau(5,5);

        Laser[] l = new Laser[1];
        l[0] = new Laser(1,2 , 315);
        int[] res = plat.caseAVerifier(2,3,315  );
        System.out.println("res[0] "+res[0]+" res[1] "+res[1]);

        plat.setLasers(l);
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
                    rects.bloc[i][j].setBackground(Color.BLACK);
                    rects.bloc[i][j].setLayout(null);
                    rects.bloc[i][j].setBounds(50*j, 50*i, 50, 50);
                    rects.bloc[i][j].setName("Label22");
                    frame.add(rects.bloc[i][j]);
                }
            }
        }

        frame.setVisible(true);


    }

}
