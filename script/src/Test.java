import modele.*;
import vue.Rectangle;

import javax.swing.*;

import modele.*;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;

public class Test  {
    JFrame jFrame;
    
   // public Test(JFrame jFrame){
     //   this.jFrame = jFrame;

    //}

    public static void main(String[] args) {

        

        LinkedList<Laser> l1 = new LinkedList<Laser>();
        l1.add(new Laser(3, 2, 315));
        Plateau p1 = new Plateau(4, 4, l1);
        Cible[] c1 = new Cible[1];
         c1[0] = new Cible(1, 2);

        p1.setCibles(c1);
        p1.initdemo();
        p1.initLaser();

        
        
        Rectangle rects = new Rectangle(p1);

        JFrame frame = new JFrame("Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(rects);

        
        
        frame.setVisible(true);

    }



}
