 package modele;

public class BlocSemiReflechissant extends Bloc {
    
    
	public BlocSemiReflechissant(int x,int y) {
		super(x,y,false);
	}
        
    public BlocSemiReflechissant(){
        super(0,0,false);
    }    
        
    @Override
    public String getType(){
            return "SemiReflechissant";
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
        } else if (x % 2 == 0 && y % 2 == 1) {
            switch (angle) {
                case 45:
                    return 315;
                case 135:
                    return 225;
                case 225:
                    return 135;
                case 315:
                    return 45;
            }
        }
        return angle;
    }


    public int[] autredev(int x, int y, int angle){
        int[] tabangle= new int[2];
        if (x % 2 == 1 && y % 2 == 0) {
                 if(angle == 315){
                    tabangle[0]=315;
                    tabangle[1]=225;
                 }
        } else if (x % 2 == 0 && y % 2 == 1) {
                 if(angle == 315){
                    tabangle[0]=225;
                    tabangle[1]=45;
                 }
        }
        return tabangle;
    }


}
