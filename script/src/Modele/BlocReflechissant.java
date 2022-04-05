package Modele;

import java.awt.*;

public class BlocReflechissant extends Bloc {

    public BlocReflechissant(int x,int y)
    {
            super(x,y,false);

    }
        
    @Override
    public String getType() {
        return "Reflechissant";
    }


}