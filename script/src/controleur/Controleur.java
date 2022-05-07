package controleur;

import modele.*;
import vue.*;

import javax.swing.*;
import java.util.LinkedList;

public class Controleur {

	private Plateau plateau;
	private Rectangle rect;

	public Controleur(){
		this.plateau = initNiveau1();
		this.rect = new Rectangle(plateau);
	}

	public Controleur(Plateau plateau){
		this.plateau = plateau;
		rect = new Rectangle(plateau);
	}

	public Controleur(int niveau){
		this.plateau = new Plateau(niveau);
		rect = new Rectangle(plateau);
	}

	public Controleur(Plateau plateau, Rectangle rect){
		this.plateau = plateau;
		this.rect = rect;
	}

	public static Plateau initNiveau1(){
		LinkedList<Laser> l1 = new LinkedList<Laser>();
		l1.add(new Laser(8, 1, 45));
		Cible[] c1 = new Cible[1];
		c1[0] = new Cible(7, 4);
		Plateau plateau = new Plateau(5, 5, l1, c1);
		for (int i = 0; i < plateau.height; i++) {
			for (int j = 0; j < plateau.width; j++) {
				plateau.cases[i][j] = new CaseVisible();
			}
		}
		plateau.cases[1][4] = new CaseCachee();
		plateau.cases[2][2] = new CaseCachee();
		plateau.cases[3][2] = new CaseCachee();
		plateau.cases[3][4] = new CaseCachee();
		plateau.cases[4][1] = new CaseCachee();
		plateau.cases[4][4] = new CaseCachee();

		plateau.cases[1][2] = new CaseVisible(new BlocReflechissant());
		plateau.cases[2][1] = new CaseVisible(new BlocReflechissant());
		plateau.cases[4][3] = new CaseVisible(new BlocReflechissant());
		plateau.initLaser();
		return plateau;
	}

	public static Plateau initNiveau2(){
		LinkedList<Laser> l1 = new LinkedList<Laser>();
		l1.add(new Laser(7, 8, 225));
		Cible[] c1 = new Cible[1];
		c1[0] = new Cible(2, 1);
		Plateau plateau = new Plateau(7, 7, l1, c1);
		for (int i = 0; i < plateau.height; i++) {
			for (int j = 0; j < plateau.width; j++) {
				plateau.cases[i][j] = new CaseVisible();
			}
		}
		plateau.cases[1][3] = new CaseCachee();
		plateau.cases[3][2] = new CaseCachee();
		plateau.cases[3][3] = new CaseCachee();
		plateau.cases[6][1] = new CaseCachee();

		plateau.cases[3][1] = new CaseVisible(new BlocSemiReflechissant());
		plateau.cases[5][2] = new CaseVisible(new BlocReflechissant());
		plateau.cases[2][4] = new CaseVisible(new BlocReflechissant());
		plateau.initLaser();
		return plateau;
	}

	/*public static Plateau initNiveau3() {
		LinkedList<Laser> l1 = new LinkedList<Laser>();
		l1.add(new Laser(1, 2, 90));
		Cible[] c1 = new Cible[1];
		c1[0] = new Cible(2, 0);

		Plateau plateau = new Plateau(5, 5, l1, c1);

		for (int i = 0; i < plateau.height; i++) {
			for (int j = 0; j < plateau.width; j++) {
				plateau.cases[i][j] =  new CaseVisible();
			}
		}
		
		plateau.cases[1][0] = new CaseVisible(new BlocAbsorbant());
		plateau.cases[0][1] = new CaseVisible(new BlocReflechissant());
		plateau.cases[0][2] = new CaseVisible(new BlocAbsorbant());
		plateau.cases[1][1] = new CaseVisible(new BlocAbsorbant());
		plateau.cases[2][1] = new CaseVisible(new BlocAbsorbant());
		plateau.cases[2][2] = new CaseVisible(new BlocAbsorbant());

		plateau.initLaser();
		return plateau;
	}*/

	public void commencerJeu(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(rect);
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
}
