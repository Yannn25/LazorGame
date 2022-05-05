package modele;

public class BlocAbsorbant extends Bloc {  //Le bloc Opaque ne reflechit pas la lumiere et n'est pas deplacable
	
    
    public BlocAbsorbant(int x, int y) {
	    super(x,y,false);
    }
    public BlocAbsorbant(int x, int y, boolean fixe) {
        super(x,y,fixe);
    }
    public BlocAbsorbant(){
        super(0,0,false);
    }
    @Override
    public String getType() {
        return "BlocAbsorbant";
    }
    
    @Override
    public int deviationLaser(int x, int y, int angle){
        return -1;
    }
}