import controleur.Controleur;

public class Main {

    public static void main(String[] args) {
        try{
            Controleur.initNiveau1().sauvegarder("Niveau1");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Controleur controleur = new Controleur();
        controleur.commencerJeu();
    }

}
