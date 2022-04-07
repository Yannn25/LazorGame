package Modele;

public class CaseCachee extends Case {

    @Override
    public boolean BlocPresent() {
        return false;
    }

    @Override
    public Bloc getBloc() {
        return null;
    }

    @Override
    public void enleverBloc() {}

    @Override
    public boolean ajouterBloc(Bloc bloc) {
        return false;
    }

}