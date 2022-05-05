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
        rects.setLayout(null);
        rects.setOpaque(true);
        //rects.setIcon(new ImageIcon(Rectangle.PATH+"arriereplan.png"));
        
        
        //System.out.println(System.getProperty("user.dir"));

        JFrame frame = new JFrame("Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(rects);

        rects.addMouseListener(rects.ma);
        rects.addMouseMotionListener(rects.ma);
        /*for (int i = 0; i < plat.height; i++) {
            for (int j = 0; j < plat.width; j++) {
                if(plat.getCase(i, j).BlocPresent()){
                    rects.bloc[i][j]=new JLabel();
                    rects.bloc[i][j].setOpaque(true);
                    rects.bloc[i][j].setLayout(null);
                    rects.bloc[i][j].setName("Bloc");
                    rects.bloc[i][j].setBounds(50*j, 50*i, 50, 50);
                    if (plat.getCase(i, j) instanceof CaseVisible){
                        rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH+"case.png"));
                    }
<<<<<<< HEAD
                    String type = plat.getCase(i, j).getBloc().getType();
                    rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH + type + ".png"));
=======
                    if ("Reflechissant".equals(plat.getCase(i, j).getBloc().getType())){
                        rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH+"Blocreflechissant.png"));
                    }
                    if ("SemiReflechissant".equals(plat.getCase(i, j).getBloc().getType())){
                        rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH+"Blocsemireflechissant.png"));
                    }

                    if ("Prisme".equals(plat.getCase(i, j).getBloc().getType())){
                        rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH+"Blocprismatique.png"));
                    }

                    if ("Opaque".equals(plat.getCase(i, j).getBloc().getType())){
                        rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH+"Blocabsorbant.png"));
                    }

                    if ("Teleporteur".equals(plat.getCase(i, j).getBloc().getType())){
                        rects.bloc[i][j].setIcon(new ImageIcon(Rectangle.PATH+"tp.png"));
                    }
>>>>>>> 8423421 (menu accueil ok)
                    frame.add(rects.bloc[i][j]);
                }
            }
        }*/

        /*JLabel cases[][]= new JLabel[plat.getHeight()][plat.getWidth()];

        for (int i = 1; i < plat.height; i++) {
            for (int j = 1; j < plat.width; j++) {
                if(plat.getCase(i, j)  instanceof CaseVisible) {
                    cases[i][j] = new JLabel();
                    cases[i][j].setOpaque(true);
                    cases[i][j].setBackground(Color.LIGHT_GRAY);
                    cases[i][j].setLayout(null);
                    cases[i][j].setBounds(50 * j, 50 * i, 47, 47);
                    frame.add(cases[i][j]);
                }
            }
        }*/
        frame.setVisible(true);

    }



}
