package modele;

public class BlocAbsorbant extends Bloc {  //Le bloc Opaque ne reflechit pas la lumiere et n'est pas deplacable
	
    
    public BlocAbsorbant(int x, int y) {
	super(x,y,true);

    }
    
    @Override
    public String getType() {
        return "Absorbant";
    }
    
    @Override
    public int deviationLaser(int x, int y, int angle){
        return 0;
    }
}