package modele;

public class BlocSemiReflechissant extends Bloc {
    
    
	public BlocSemiReflechissant(int x,int y) {
		super(x,y,false);
	}
        
        @Override
        public String getType(){
            return "SemiReflechissant";
        }
}
