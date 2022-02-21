package Modele;

import java.awt.Point;
import java.util.LinkedList;

public class Laser {

	protected final int x,y;
	// Orientation en degr√© ?
	// Ou orientation avec un vecteur ? Vx, Vy ?
	protected final int orientation;
	
	protected LinkedList<Point> points; //LinkedList des points parcouru par le laser
	
	public Laser(int x,int y, int orientation) {
		
		this.x=x;
		this.y=y;
		this.orientation=orientation;

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

			System.out.println("Le laser est deviÈ vers les cases suivantes : ");
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

			System.out.println("Le laser est deviÈ vers les cases suivantes : ");
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

			System.out.println("Le laser est deviÈ vers les cases suivantes : ");
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

			System.out.println("Le laser est deviÈ vers les cases suivantes : ");
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


}
