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
