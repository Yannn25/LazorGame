package Test;

import Vue.Vue;
import Modele.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Test  {

  
    public static void main(String[] args) {


        Plateau plat = new Plateau(3,3);
       
        
        Laser[] l = new Laser[1];
        l[0] = new Laser(0,0, 90);
       // l[1] = new Laser(0, 0, 90);
        //LinkedList<Point> p = new LinkedList<>();
       // p.add(new Point(100, 400));p.add(new Point(250, 100));//p.add(new Point(400, 40));
        // p.add(new Point(600, 400));p.add(new Point(700, 50));
       // LinkedList<Point> pp = new LinkedList<>();
       // pp.add(new Point(500, 780));pp.add(new Point(450, 600));pp.add(new Point(270, 750));
        //l[0].setPoints(p);
       // l[1].setPoints(pp);
        plat.setLasers(l);
        plat.InitLaser();
        
        Vue vue = new Vue(plat); 
      

       // vue.setPlat(plat);
       // vue.TraceLaser(vue.getGraphics());
        //vue.Plateau(vue.getGraphics());

    }
    
}