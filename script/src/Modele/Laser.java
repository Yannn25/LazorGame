package Modele;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

public class Laser {

	protected final int x,y;
	// Orientation en degré ?
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
		public static void main(String[] args) {
		 String tab[][]=new String[4][4];
		tab[0][0]="A";
		tab[0][1]="B";
		tab[0][2]="C";
		tab[0][3]="D";

		tab[1][0]="F";
		tab[1][1]="G";
		tab[1][2]="H";
		tab[1][3]="I";


		tab[2][0]="K";
		tab[2][1]="L";
		tab[2][2]="M";
		tab[2][3]="N";

		tab[3][0]="P";
		tab[3][1]="Q";
		tab[3][2]="R";
		tab[3][3]="S";
		/*tab[0][0]="A";
		tab[0][1]="B";
		tab[0][2]="C";
		tab[0][3]="D";
		tab[0][4]="E";

		tab[1][0]="F";
		tab[1][1]="G";
		tab[1][2]="H";
		tab[1][3]="I";
		tab[1][4]="J";

		tab[2][0]="K";
		tab[2][1]="L";
		tab[2][2]="M";
		tab[2][3]="N";
		tab[2][4]="O";

		tab[3][0]="P";
		tab[3][1]="Q";
		tab[3][2]="R";
		tab[3][3]="S";
		tab[3][4]="T";

		tab[4][0]="U";
		tab[4][1]="V";
		tab[4][2]="W";
		tab[4][3]="X";
		tab[4][4]="Y";*/
		for (int i=0; i< tab.length;i++){
			for (int j =0; j<tab.length;j++){


				System.out.print(tab[i][j]+"  ");


			}
			System.out.println(" ");
		}
		/*Scanner sc =new Scanner(System.in);
		/*System.out.print("Enter le coordonnée x de la case de départ :");
		int x1=sc.nextInt();
		System.out.print("Enter le coordonnée y de la case de départ :");
		int y1=sc.nextInt();
		if (tab[x1][y1]=="B"){
		   tab[x1][y1]="C";}
		else
			System.out.print("La case selectionnée n'a pas de bloc");
		System.out.print("Enter le coordonnée x de la case d'arrivée :");
		int x2=sc.nextInt();
		System.out.print("Enter le coordonnée y de la case d'arrivée :");
		int y2=sc.nextInt();
		tab[x2][y2]="B";
		System.out.println("Donner la position de la case par rapport au lazer : h ou b");
		int x=1;
		int y=0;
			for ( int i =x  ; i < tab.length-x;i++) {

				for ( int j =y; j < tab.length;j++) {

					//System.out.print(tab[i][j]+"  ");


					if (i == j)
						System.out.print(tab[i][j]);


				}

			}*/

		Scanner sc =new Scanner(System.in);
		orientationintialeLaser(4, 3, 1, tab);
		System.out.print("Entrer le point x de la case :");
		int x =sc.nextInt();
		System.out.print("Entrer le point y de la case :");
		int y=sc.nextInt();
		//deviationlaserGH(4, tab, x, y);
			deviationlaserH(4, tab, x, y);
		}



}
