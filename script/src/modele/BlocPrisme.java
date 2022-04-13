package modele;

public class BlocPrisme extends Bloc {
    
    
    public BlocPrisme(int x, int y) {
            super(x,y,false);
    }
        
    @Override
    public String getType() {
        return "Prisme";
    }    
}