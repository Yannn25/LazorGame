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



	public static void produitMatrices(int mat[][], int x1[],int x2[]){
		int Matx1x2[][]= new int [2][2];
		int produit[][]= new int [2][2];
		System.out.println("Matrice 1 : ");
		for (int i=0; i< mat.length;i++){
			for (int j =0; j<mat.length;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println("\t");
		}

		//Calcul produit
		System.out.println("Matrice 2 : ");
		for (int i=0; i< 2;i++){
			for (int j =0; j<2;j++){
				Matx1x2[0][j]=x1[j];
				Matx1x2[1][j]=x2[j];
				System.out.print(Matx1x2[i][j]+" ");

			}
			System.out.println("\t");
		}
		System.out.println("Produit Matrice 1 et Matrice 2 : ");
		for (int i=0; i< 2;i++){
			for (int j =0; j<2;j++){
				produit[i][j] = 0;
				for( int k = 0 ; k < 2 ; k ++ )
					produit[i][j] = produit[i][j] + mat[i][k] * Matx1x2[k][j] ;
				System.out.print(produit[i][j]+" ");

			}
			System.out.println("\t");
		}

	}

	public static void main(String[] args) {

		int x1[]= {-1,4};
		int x2[]={7,-6};
		int mat[][]={{2,-2},{5,3}};
		produitMatrices(mat, x1, x2);


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
