package Test;

import Modele.*;

public class Test  {

  
    public static void main(String[] args) {


        Plateau plat = new Plateau(4, 4);
        plat.init3();
        //Case c = new CaseCachee();
        //plat


        //Bloc b1 = new BlocReflechissant(1,1,true);

        //plat.getCase(1, 1).setBloc(b1);
        Vue vue = new Vue(); 


        vue.affichage(plat);
 
    }
    
}