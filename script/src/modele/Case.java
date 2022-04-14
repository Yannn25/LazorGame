package modele;

public abstract class Case {
	
	
	public void afficheCase(){ }
	public void setBloc(Bloc b){}
    public abstract boolean BlocPresent();
    public String getType() {return "";}
    public abstract Bloc getBloc();
    public abstract void enleverBloc();
    public abstract boolean ajouterBloc(Bloc bloc);

}