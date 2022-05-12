package modele;

public class BlocAbsorbant extends Bloc {  //Le bloc Opaque ne reflechit pas la lumiere et n'est pas deplacable

    public BlocAbsorbant(){
        super(false);
    }
    public BlocAbsorbant(boolean fixe){
        super(fixe);
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