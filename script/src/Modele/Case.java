package Modele;

public abstract class Case {
	
	
	public void afficheCase(){ }
	public void setBloc(Bloc b){}
        public abstract boolean BlocPresent();
}


class 	CaseCachee extends Case {
	/*
	* Affichage dans le terminal d'une Case non Visible
	*/
	@Override
	public void afficheCase () {
		System.out.print("|** |");
	}

    @Override
    public boolean BlocPresent() {
        return false;
    }
}
