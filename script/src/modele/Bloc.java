package modele;

import java.io.Serializable;

import javax.swing.*;

public abstract class Bloc implements Serializable{

	public boolean fixe;//S'il est initialisé à true alors le bloc n'est pas déplaçable

	public Bloc(boolean fixe) {
		this.fixe=fixe;
	}
        
	public String getType(){
            return "";
        }

	public abstract int deviationLaser(int x, int y, int angle);
}
