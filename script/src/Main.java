import controleur.Controleur;

/*  Classe main qui lance la partie grace a un controleur */

public class Main {

    public static void main(String[] args) {
        /*try{
            Controleur.initNiveau5().sauvegarder("Niveau5");
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        Controleur controleur = new Controleur();
        controleur.commencerJeu();
    }

}
