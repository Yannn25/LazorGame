package Modele;

import java.awt.Point;
import java.util.LinkedList;

public class Plateau {

	final int width;
	final int height;
	protected Case[][] plateau;
        protected boolean[][] tabPencher;//Le tableau inverser de toutes les "cibles" qu'un laser peut parcourir
	protected Cible[] cibles; //Toutes les cibles du plateau
	protected Laser[] lasers; //Tous les lasers du plateau
	
	public Plateau(int height, int width) {
		
            this.height=height;
            this.width=width;
            this.plateau = new Case[width][height];
            this.tabPencher = new boolean[width*2][height*2];
                
	}

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
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
        public void setLasers(Laser[] l) {
            this.lasers = l;
        }
        
        public boolean winCondtion() {
		boolean res=true;
		for(Cible c:this.cibles) {
			boolean b = false;
			for(Laser l:this.lasers) {
				if(l.points.contains(c)) {
					b=true;
					break;
				}
			}
			if(!b) {
				res = false;
				break;
			}
		}
		return res;
	}
        
        
        /**
        *
        * @return 
        */
	public boolean deplacerBloc() {
            
            return true;
	}
        
        /**
         * Boolean qui nous permet de savoir si la case a la position
         * (x,y) est une instance de CaseVisible 
         * @param x coordonées x
         * @param y coordonées y
         * @return vrai si il est possible de placer un bloc 
         * sur la case en question
         */
        public boolean DeplacerSurCase(int x, int y){
            return plateau[x][y] instanceof CaseVisible;
        }
        
        public static double[] produitMatrices(double mat[][], int x1,int x2){
		double produit[] = new double [2];

		produit[0] = mat[0][0]*x1 + mat[0][1]*x2;
		produit[1] = mat[1][0]*x1 + mat[1][1]*x2;
		return produit;

	}

        
        public static double[] conversionVersCible(int x,int y) {
		double[][] n = {{-1,1},{1,1}};
		return produitMatrices(n,x,y);
	}
	
	public static double[] conversionVersBloc(int x,int y) {
		double[][] n = {{-0.5,0.5},{0.5,0.5}};
		return produitMatrices(n,x,y);
	}

        
        
        /**
         * Méthode qui va initialiser le tracage du laser en fonction de son 
         * point de départ et de son orientation;
         */
        public void InitLaser(){ 
            
            for(Laser l : lasers){
                
                double depart[] = conversionVersCible(l.x, l.y);
                l.points.add(new Point((int)depart[0], (int)depart[1]));
                    
                if(l.orientation <= 90){
                    for(int j = l.y+1; j < tabPencher.length; j++){
                        double points[] = conversionVersBloc(l.x, j);
                        int x = (int)points[0];
                        int y = (int)points[1];
                        tabPencher[x][y] = true;
                        l.points.add(new Point((int)points[0], (int)points[1]));
                       
                    }
                } else {
                    for(int j = l.x+1; j < tabPencher.length; j++){
                        double points[] = conversionVersCible(j, l.y);
                        int x = (int)points[0];
                        int y = (int)points[1];
                        tabPencher[x][y] = true;
                        l.points.add(new Point((int)points[0], (int)points[1]));
                    }
                }
            }
        }
        
	/**
         * Méthode qui permet de recalculer la trajectoire du laser apres le 
         * déplacement d'un bloc;
         */
        public void CalculTrajectoire(){
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    //if( plateau[i][j].BlocPresent())
                    switch(plateau[i][j].getType()){
                        case "Opaque" :
                            
                            break;
                        case "Prisme" :
                            break;
                        case "Reflechissant" :
                            break;
                        case "SemiReflechissant" :
                            break;
                        case "TP" :
                            break;
                    }
                }
            }
        }
        
        public void CibleAtteinte(){
            for( Laser l : lasers) {
                for(Point point : l.points){
                    for(int i = 0; i < cibles.length; i++){
                        if(cibles[i].p.x == point.x && cibles[i].p.y == point.y)
                            cibles[i].atteint = true;
                    }
                }
            }
        }
	
	/** 
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
        
    public void initdemo() {
        for(int i = 0; i < 3; i ++){
            plateau[0][i] = new CaseVisible();
        }
        plateau[0][2] = new CaseVisible(new BlocOpaque(0, 2));
    }    

}
