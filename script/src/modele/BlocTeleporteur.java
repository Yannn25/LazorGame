package modele;

public class BlocTeleporteur extends Bloc {
    
    
	public BlocTeleporteur(int x, int y) {
		super(x,y,false);
	}
    public BlocTeleporteur(int x, int y, boolean fixe) {
        super(x,y,fixe);
    }
    public BlocTeleporteur(){
        super(0,0,false);
    }

    @Override
    public String getType(){
            return "BlocTeleporteur";
        }

    @Override
    public int deviationLaser(int x, int y, int angle){
        return -1;
    }   
}
