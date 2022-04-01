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
        int[] res = plat.caseAVerifier(6,1,45);

        plat.setLasers(l);
        plat.initdemo();
        plat.InitLaser();
//        plat.CalculTrajectoire();

        //Vue vue = new Vue(plat);


        Rectangle rects = new Rectangle(plat);
        rects.setLayout(null);
        rects.setBounds(0,0,300,300);
        rects.setBackground(Color.WHITE);

        JFrame frame = new JFrame("Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);


    }

}
