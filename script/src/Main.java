import controleur.Controleur;

public class Main {

    public static void main(String[] args){
        /*try{
            Controleur.initNiveau2().sauvegarder("Niveau2");
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        Controleur controleur = new Controleur();
        controleur.commencerJeu();
    }

}
