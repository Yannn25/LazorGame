package Test;

import Vue.Vue;
import Modele.*;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JFrame;

public class Test  {

  
    public static void main(String[] args) {


        Plateau plat = new Plateau(4, 4);
        //plat.init3();
        
        Laser[] l = new Laser[2];
        l[0] = new Laser(0, 0, 90);
        LinkedList<Point> p = new LinkedList<>();
        p.add(new Point(100, 100));p.add(new Point(200, 200));p.add(new Point(400, 40));
        p.add(new Point(600, 520));p.add(new Point(700, 50));
        l[0].setPoints(p);
        plat.setLasers(l);
        
        Vue vue = new Vue(); 
        vue.setPlat(plat);
        vue.TraceLaser(vue.getGraphics());
        

    }
    
}