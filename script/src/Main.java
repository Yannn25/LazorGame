import controleur.Controleur;

/*  Classe main qui lance la partie grace a un controleur */

public class Main {

    public static void main(String[] args) {
        /*try{
            Controleur.initNiveau6().sauvegarder("Niveau6");
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        Controleur controleur = new Controleur();
        controleur.commencerJeu();
    }

}
