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
        if(x % 2 == 1){
             if(angle == 45 || angle == 135) return 90;
             if(angle == 225 || angle == 315)  return 270;
        } else if(y % 2 == 1){
            if(angle == 45 || angle == 315) return 0;
            if(angle == 225 || angle == 135) return 180;
        }
        return angle;
    }   
}
