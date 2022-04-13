package modele;

public class BlocTP extends Bloc {
    
    
	public BlocTP(int x, int y) {
		super(x,y,false);
	}
        
        @Override
        public String getType(){
            return "TP";
        }
}
