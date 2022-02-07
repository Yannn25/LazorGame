package Modele;

public abstract class Case {

}

class CaseVisible extends Case {
	
	protected Bloc bloc;
	
	public CaseVisible() {
		this(null);
	}
	
	public CaseVisible(Bloc bloc) {
		this.bloc=bloc;
	}
	
}

class 	CaseCachee extends Case {}
