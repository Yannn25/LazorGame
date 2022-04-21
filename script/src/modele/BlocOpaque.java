package modele;

public class BlocOpaque extends Bloc {  //Le bloc Opaque ne reflechit pas la lumiere et n'est pas deplacable
	
    
    public BlocOpaque(int x,int y) {
	super(x,y,true);

    }
    public BlocOpaque(){
        super(0,0,false);
    }
    @Override
    public String getType() {
        return "Opaque";
    }
    
    @Override
    public int deviationLaser(int x, int y, int angle){
        return -1;
    }
}