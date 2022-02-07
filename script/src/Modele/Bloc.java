package Modele;

public abstract class Bloc {

	protected int x,y;		//Postion du bloc dans le tableau
	final boolean fixe;		//S'il est initialisé à true alors le bloc n'est pas déplaçable
	
	public Bloc(int x, int y, boolean fixe) {
		
		this.x=x;
		this.y=y;
		this.fixe=fixe;
		
	}
}

/*
 * Sous-class de bloc.
 * Ces sous-class de Bloc représenterons les différents type de bloc dans le jeu
 */
class BlocOpaque extends Bloc {		//Le bloc Opaque ne reflechit pas la lumiere et n'est pas deplacable
	public BlocOpaque(int x,int y) {
		super(x,y,true);
	}
}

class BlocReflechissant extends Bloc {
	public BlocReflechissant(int x,int y) {
		super(x,y,false);
	}
}

class BlocSemiReflechissant extends Bloc {
	public BlocSemiReflechissant(int x,int y) {
		super(x,y,false);
	}
}

class BlocTP extends Bloc {
	public BlocTP(int x, int y) {
		super(x,y,false);
	}
}

class BlocPrisme extends Bloc {
	public BlocPrisme(int x, int y) {
		super(x,y,false);
	}
}