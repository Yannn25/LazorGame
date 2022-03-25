package Test;

import Vue.Vue;
import Modele.*;
import java.awt.geom.Line2D;
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
        l[0] = new Laser(1,4, 315);
        //l[1] = new Laser(0, 0, 90);
        //LinkedList<Point> p = new LinkedList<>();
        //p.add(new Point(100, 400));p.add(new Point(250, 100));//p.add(new Point(400, 40));
        // p.add(new Point(600, 400));p.add(new Point(700, 50));
        // LinkedList<Point> pp = new LinkedList<>();
        // pp.add(new Point(500, 780));pp.add(new Point(450, 600));pp.add(new Point(270, 750));
        //l[0].setPoints(p);
        // l[1].setPoints(pp);
        plat.setLasers(l);
        plat.init2();
        plat.InitLaser();
        plat.CalculTrajectoire();
        
        Vue vue = new Vue(plat);
        //vue.g2.drawLine(1*vue.getWidth()/12, 1*vue.getHeight()/7, 200, 200);
        //vue.g2.drawLine(100, 100, 200, 200);

//        for(int i = 1; i <= 8; i++){
//            Rectangle2D myRect = new Rectangle2D.Double(i*10,104, 50, 50);
//            AffineTransform at = AffineTransform.getRotateInstance(Math.PI / 4, 150, 150);
//            Shape rotatedRect = at.createTransformedShape(myRect);
//
//            vue.g2.draw(rotatedRect);
//        }
//        vue.getGraphics().drawOval(104, 104, 50, 50);
//          vue.getGraphics().drawLine(104, 104, 204, 204);
//          for(int i = 1; i <= 4; i++){
//              for(int j = 1; j <= 3; j++){
//                vue.getGraphics().drawRect(i*vue.getWidth()/8, j*vue.getHeight()/4, 100, 100);
//              }
//          }
//          vue.getGraphics().drawLine(104, 148, 160, 204);
    }
    
}