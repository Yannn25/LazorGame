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
	
	public boolean deplacerBloc() {
		return true;
	}



	public static int[] produitMatrices(int mat[][], int x1,int x2){
		int produit[] = new int [2];

		produit[0] = mat[0][0]*x1 + mat[0][1]*x2;
		produit[1] = mat[1][0]*x1 + mat[1][1]*x2;
		return produit;

	}

	public static void main(String[] args) {

		int x1= 2;
		int x2= 3;
		int mat[][]={{2,-2},{5,3}};
		System.out.println(produitMatrices(mat, x1, x2)[0] + "\n" + produitMatrices(mat, x1, x2)[1]);
	}

	public Case getCase(int x, int y){
		return plateau[x][y];
	}

	public void setCase(int x, int y,Case c){
			plateau[x][y] = c;
	}
	
	public void init(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				plateau[i][j] = new CaseVisible();
			}
		}
	}


}
