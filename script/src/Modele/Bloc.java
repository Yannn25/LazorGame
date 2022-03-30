package Modele;

import javax.swing.*;

public abstract class Bloc extends JPanel {

	protected int x,y;		//Postion du bloc dans le tableau
	final boolean fixe;		//S'il est initialisé à true alors le bloc n'est pas déplaçable
	
	public Bloc(int x, int y, boolean fixe) {
		
		this.x=x;
		this.y=y;
		this.fixe=fixe;
		
	}
        
        public String getType(){
            return "";
        } 
}
