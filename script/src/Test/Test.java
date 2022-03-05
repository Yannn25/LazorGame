package Test;

import Vue.Vue;
import Modele.*;
import java.awt.Point;
import java.util.LinkedList;

public class Test  {

  
    public static void main(String[] args) {


        Plateau plat = new Plateau(4, 4);
       
        
        Laser[] l = new Laser[2];
        l[0] = new Laser(0, 0, 90);
        l[1] = new Laser(0, 0, 90);
        LinkedList<Point> p = new LinkedList<>();
        p.add(new Point(100, 100));p.add(new Point(200, 200));p.add(new Point(400, 40));
        p.add(new Point(600, 400));p.add(new Point(700, 50));
        LinkedList<Point> pp = new LinkedList<>();
        pp.add(new Point(500, 780));pp.add(new Point(450, 600));pp.add(new Point(270, 750));
        l[0].setPoints(p);
        l[1].setPoints(pp);
        plat.setLasers(l);
        
        Vue vue = new Vue(); 
        vue.setPlat(plat);
        vue.TraceLaser(vue.getGraphics());
        

    }
    
}