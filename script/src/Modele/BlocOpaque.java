package Modele;

public class BlocOpaque extends Bloc {		//Le bloc Opaque ne reflechit pas la lumiere et n'est pas deplacable
	public BlocOpaque(int x,int y) {
		super(x,y,true);
	}
}