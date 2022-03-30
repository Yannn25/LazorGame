package Test;

import Vue.Vue;
import Modele.*;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

public class Test  {

  
    public static void main(String[] args) {


        Plateau plat = new Plateau(3,3);


        Laser[] l = new Laser[1];
        l[0] = new Laser(3,3, 360);
        plat.setLasers(l);
        plat.InitLaser();
        
        Vue vue = new Vue(plat);
        vue.repaint();
//       e(104, 148, 160, 204);
    }
    
}