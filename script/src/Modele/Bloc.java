package Modele;

public abstract class Bloc {

	protected int x,y;		//Postion du bloc dans le tableau
	final boolean fixe;		//S'il est initialis� � true alors le bloc n'est pas d�pla�able
	
	public Bloc(int x, int y, boolean fixe) {
		
		this.x=x;
		this.y=y;
		this.fixe=fixe;
		
	}
}

/*
 * Sous-class de bloc.
 * Ces sous-class de Bloc repr�senterons les diff�rents type de bloc dans le jeu
 */

