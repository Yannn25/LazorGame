import controleur.Controleur;

public class Main {

    public static void main(String[] args){
        /*try{
            Controleur.initNiveau3().sauvegarder("Niveau3");
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        Controleur controleur = new Controleur();
        controleur.commencerJeu();
    }

}
