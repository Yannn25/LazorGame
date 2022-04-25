package modele;

public class BlocPrisme extends Bloc {
    
    
    public BlocPrisme(int x, int y) {
            super(x,y,false);
    }
        
    @Override
    public String getType() {
        return "Prisme";
    } 


    @Override
    public int deviationLaser(int x, int y, int angle){
        if (x % 2 == 1 && y % 2 == 0) {
            switch (angle) {
                case 45:
                    return 135;
                case 135:
                    return 45;
                case 225:
                    return 315;
                case 315:
                    return 225;
            }
        }
        return angle;
    }   
}