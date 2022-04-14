package modele;

public class BlocSemiReflechissant extends Bloc {
    
    
	public BlocSemiReflechissant(int x,int y) {
		super(x,y,false);
	}
        
        @Override
        public String getType(){
            return "SemiReflechissant";
        }

    @Override
    public int deviationLaser(int x, int y, int angle){
        return 0;
    }   
}
