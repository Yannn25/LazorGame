package modele;

import javax.swing.*;

public abstract class Bloc {

	protected int x,y;		//Postion du bloc dans le tableau
	final boolean fixe;//S'il est initialisé à true alors le bloc n'est pas déplaçable
	
	public Bloc(int x, int y, boolean fixe) {
		
		this.x=x;
		this.y=y;
		this.fixe=fixe;
		
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}


	public void setX(int x){
		this.x=x;
	}

	public void setY(int y){
		this.y=y;
	}
        
        public String getType(){
            return "";
        }

	public abstract int deviationLaser(int x, int y, int angle);
}
