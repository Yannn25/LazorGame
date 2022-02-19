package Modele;

import javax.swing.JPanel;

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
        public Laser[] getLasers() {
            return lasers;
        }
        public void setLasers(Laser[] lasers) {
            this.lasers = lasers;
        }
        
        
        /*
        */
	public boolean deplacerBloc() {
            return true;
	}

	
	
	/*
	* Initialisation des plateau un peu commme des niveaux
	*/
	public void init1(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				plateau[i][j] = new CaseVisible();
			}
		}
	}
	public void init2(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(i%2 == 0 && j%2 != 0 || i%2 != 0 && j%2 == 0){
					plateau[i][j] = new CaseVisible();
				} else {
					plateau[i][j] = new CaseCachee();
				}
			}
		}
	}
	public void init3(){
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    if(i%2 == 0){
                        plateau[i][j] = new CaseVisible();
                    } else {
                        plateau[i][j] = new CaseCachee();
                    }
                }
            }
	}


}
