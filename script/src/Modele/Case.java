package Modele;

public abstract class Case {
	
	
	public void afficheCase(){ }
	public void setBloc(Bloc b){}
        public abstract boolean BlocPresent();
        public String getType() {return "";}
}


class 	CaseCachee extends Case {

    @Override
    public boolean BlocPresent() {
        return false;
    }
}
