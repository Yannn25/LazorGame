package modele;

public class BlocPrisme extends Bloc {
    
    
    public BlocPrisme(int x, int y) {
            super(x,y,false);
    }
    public BlocPrisme(){
        super(0,0,false);
    }
        
    @Override
    public String getType() {
        return "Prisme";
    } 


    @Override
    public int deviationLaser(int x, int y, int angle){
        return angle;
    }   
}
