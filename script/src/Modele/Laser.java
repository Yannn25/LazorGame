package Modele;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Laser {

	JLabel p[]=new JLabel[50];
	protected  int x,y;
	// Orientation en degrÃ© ?
	// Ou orientation avec un vecteur ? Vx, Vy ?
	protected  int orientation;
	
	protected LinkedList<Point> points; //LinkedList des points parcouru par le laser
	
	public Laser(int x, int y, int orientation, JLabel jl, JPanel jp) {
		
		this.x=x;
		this.y=y;
		this.orientation=orientation;
		orientationLazer(0, this.x, this.y, jp);

	}
	public Laser(JLabel jl, JPanel jp){
		traçagelaser(0, 50, jl, jp);
	}

	public static void orientationintialeLaser(int taille,int x, int y,String t[][]){
		System.out.println("Le laser passe par les cases suivante : ");
		try{
			System.out.print(t[x][y]);
		for (int i=1;i<taille;i++){
			System.out.print(t[x-i+1][y+i]);
			System.out.print(t[x-i][y+i]);
			x=x;
			y=y;
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("");
		}
	}
//Fonction orientation lazer au cas ou le bloc est sur le laser
	public static void deviationlaserH(int taille, String t[][],int x, int y){
		String coor[] = new String[taille];
        try{

			System.out.println("Le laser est devié vers les cases suivantes : ");
			for (int j=0,i=1;i<taille;i++,j++){
				System.out.print(t[x+i][y+i-1]);
				System.out.print(t[x+i][y+i]);
				System.out.println("");
				coor[j]=(x+i)+""+(y+i-1)+" "+(x+i)+""+(y+i);
				x=x;
				y=y;


			}
			for (int i=0;i<taille;i++){
				System.out.println(coor[i]);
			}

		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("");
		}

		}

	//Fonction orientation lazer au cas ou le bloc est sur le laser
	public static void deviationlaserB(int taille, String t[][],int x, int y) {
		try {

			System.out.println("Le laser est devié vers les cases suivantes : ");
			for (int i=1;i<taille;i++){
				System.out.print(t[x+i][y-i+1]);
				System.out.print(t[x+i][y-i]);
				x=x;
				y=y;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("");
		}

	}



	//Fonction orientation lazer au cas ou le bloc est sous le laser
	public static void deviationlaserB1(int taille, String t[][],int x, int y) {
		try {

			System.out.println("Le laser est devié vers les cases suivantes : ");
			for (int i=1;i<taille;i++){
				System.out.print(t[x-i+1][y-i]);
				System.out.print(t[x-i][y-i]);
				x=x;
				y=y;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("");
		}

	}

	//Fonction orientation lazer au cas ou le bloc est sous le laser
	public static void deviationlaserH1(int taille, String t[][],int x, int y) {
		try {

			System.out.println("Le laser est devié vers les cases suivantes : ");
			for (int i=1;i<taille;i++){
				System.out.print(t[x-i+1][y-i]);
				System.out.print(t[x-i][y-i]);
				x=x;
				y=y;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("");
		}

	}

	public void traçagelaser(int debut,int fin,JLabel l,JPanel panTabCase) {

		for (int i = debut; i < fin; i++) {
			p[i] = new JLabel();
			p[i].setLayout(null);
			p[i].setBounds(20 + i * 5, 155 - i * 5, 5, 5);
			p[i].setOpaque(true);
			p[i].setBackground(Color.BLUE);
			p[i].setVisible(true);

			if (i % 11 == 0 && i>0) {
				p[i].setBackground(Color.CYAN);

			}

			if ( i==0 ) {
				p[i].setBackground(Color.RED);

			}

			if (p[i].getX()== l.getX()+20 && p[i].getY()== l.getY()+45){
				System.out.println("les i "+i);
			}
			panTabCase.add( p[i]);
			panTabCase.repaint();
		}
	}

	public void orientationLazer(int issulaser, int x, int y,JPanel panTabCase){

		for (int i = issulaser; i < x/5; i++) {
			p[i] = new JLabel();
			p[i].setLayout(null);
			p[i].setOpaque(true);
			p[i].setBackground(Color.BLUE);
			p[i].setVisible(true);

			if (i % 11 == 0) {
				p[i].setBackground(Color.CYAN);
			}

			p[i].setBounds(20 + i * 5, 155 - i * 5, 5, 5);

			panTabCase.add( p[i]);
			//panTabCase.setComponentZOrder(p, 2);
			panTabCase.repaint();

		}

		for (int i = 0; i < 50; i++) {
			p[i] = new JLabel();
			p[i].setLayout(null);
			p[i].setOpaque(true);
			p[i].setBackground(Color.BLUE);
			p[i].setVisible(true);

			if (i % 11 == 0) {
				p[i].setBackground(Color.CYAN);
			}

			p[i].setBounds(x+20 + i * 5, y+45 + i * 5, 5, 5);


			panTabCase.add( p[i]);
			//panTabCase.setComponentZOrder(p, 2);
			panTabCase.repaint();

		}
	}






}
