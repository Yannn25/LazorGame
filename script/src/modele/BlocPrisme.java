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
        if(y % 2 == 1 ){
            switch(angle){
                case 45 : return 0;
                case 315 : return 180;
                case 135 : return 0;
                case 225 : return 180; 
            }           
        } else if(x % 2 == 1 ){
            switch(angle){
                case 45 : return 90;
                case 135 : return 270;
                case 315 : return 90;
                case 225 : return 270; 
            }
        }
        return angle;
    }   
}
