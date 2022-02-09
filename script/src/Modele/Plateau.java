package Modele;

public class Plateau {

	final int width;
	final int height;
	protected Case[][] plateau;
	protected Cible[] cibles; //Toutes les cibles du plateau
	protected Laser[] lasers; //Tous les lasers du plateau
	
	public Plateau(int height, int width) {
		
		this.height=height;
		this.width=width;
		this.plateau = new Case[height][width];
		
	}
	
	public Case getCase(int x, int y){
		return plateau[x][y];
	}
	public void setCase(int x, int y,Case c){
			plateau[x][y] = c;
	}

	public boolean deplacerBloc() {
		return true;
	}
	
	public void init(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				plateau[i][j] = new CaseVisible();
			}
		}
	}


}
