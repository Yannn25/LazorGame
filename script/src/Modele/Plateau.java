package Modele;

public class Plateau {

	final int width;
	final int height;
	protected Case[][] plateau;
	protected Cible[] cibles; //Toutes les cibles du plateau
	protected Laser[] lasers; //Toutes les lasers du plateau
	
	public Plateau(int height, int width) {
		
		this.height=height;
		this.width=width;
		this.plateau = new Case[height][width];
		
	}
	
	public boolean deplacerBloc() {
		return true;
	}
	
	public boolean winCondition() {		//Retourne true si toutes les cibles sont atteintes
		boolean b=true;
		for(Cible c:this.cibles) {
			boolean tmp=false;
			for(Laser l:this.lasers) {
				if(l.points.contains(c.p)) {
					tmp=true;
					break;
				}
			}
			if(!tmp) {
				b=false;
				break;
			}
		}
		return b;
	}
	
}
