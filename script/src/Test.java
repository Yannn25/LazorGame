import modele.CaseVisible;
import modele.Laser;
import modele.Plateau;
import vue.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Test  {

    public static final String PATH="Icone\\";
    public static void main(String[] args) {


        LinkedList<Laser[]> tablaser = new LinkedList<>();
        LinkedList<Laser> l = new LinkedList<Laser>();
        l.add(new Laser(3, 2, 315));
        l.add(new Laser(4, 5, 45));

        Plateau plat = new Plateau(5, 5, l);
        plat.initdemo();
        plat.initLaser();

        //Vue vue = new Vue(plat);


        Rectangle rects = new Rectangle(plat);
        rects.setLayout(null);
        rects.setOpaque(true);
        rects.setIcon(new ImageIcon(PATH+"arriereplan.png"));

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
                    rects.bloc[i][j].setName("Bloc");
                    rects.bloc[i][j].setBounds(50*j, 50*i, 50, 50);
                    if (plat.getCase(i, j) instanceof CaseVisible){
                        rects.bloc[i][j].setIcon(new ImageIcon(PATH+"case.png"));
                    }
                    if (plat.getCase(i, j).getBloc().getType()=="Reflechissant"){
                        rects.bloc[i][j].setIcon(new ImageIcon(PATH+"Blocreflechissant.png"));
                    }
                    if (plat.getCase(i, j).getBloc().getType()=="SemiReflechissant"){
                        rects.bloc[i][j].setIcon(new ImageIcon(PATH+"Blocsemireflechissant.png"));
                    }

                    if (plat.getCase(i, j).getBloc().getType()=="Prisme"){
                        rects.bloc[i][j].setIcon(new ImageIcon(PATH+"Blocprismatique.png"));
                    }

                    if (plat.getCase(i, j).getBloc().getType()=="Absorbant"){
                        rects.bloc[i][j].setIcon(new ImageIcon(PATH+"Blocabsorbant.png"));
                    }
                    frame.add(rects.bloc[i][j]);
                }
            }
        }

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
