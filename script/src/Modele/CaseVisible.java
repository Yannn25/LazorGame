package Modele;

public class CaseVisible extends Case{
    
    	
	protected Bloc bloc;
	
	public CaseVisible() {
		this(null);
	}
	
	public CaseVisible(Bloc bloc) {
		this.bloc=bloc;
	}

	/*
	* Affichage dans le terminal d'une Case Visible
	*/
	@Override
	public void afficheCase() {
		if(this.bloc != null){
			afficheBloc();
		}
		System.out.print("|__|");
	}

	/*
	* Affichage d'un bloc
	*/
	public void afficheBloc(){
		System.out.print("| BLOC |  ");
	}
	
	public void setBloc(Bloc b){
		this.bloc = b;
	}

    @Override
    public boolean BlocPresent() {
        return this.bloc != null;
    }
    
}
