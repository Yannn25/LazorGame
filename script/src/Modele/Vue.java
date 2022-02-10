package Modele;

public class Vue{


    public void affichage(Plateau plat){
        for(int i = 0; i < plat.height; i++){
            for(int j = 0; j < plat.width; j++){
                plat.getCase(i, j).afficheCase();
            }
            System.out.println("\n");
        }
    }
}