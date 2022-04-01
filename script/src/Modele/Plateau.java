package Modele;

import java.awt.Point;
import static java.lang.Math.*;
import java.util.LinkedList;

public class Plateau {

    public int width;
    public int height;
    protected Case[][] plateau;
    protected Cible[] cibles; //Toutes les cibles du plateau
    protected Laser[] lasers; //Tous les lasers du plateau

    public Plateau(int height, int width) {

        this.height=height;
        this.width=width;
        this.plateau = new Case[height][width];

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Case getCase(int x, int y){
        return plateau[x][y];
    }
    public void setCase(int x, int y,Case c){
        plateau[x][y] = c;
    }
    public Laser[] getLasers() {
        return lasers;
    }
    public void setLasers(Laser[] l) {
        this.lasers = l;
    }

    public boolean winCondtion() {
        boolean res=true;
        for(Cible c:this.cibles) {
            boolean b = false;
            for(Laser l:this.lasers) {
                if(l.points.contains(c)) {
                    b=true;
                    break;
                }
            }
            if(!b) {
                res = false;
                break;
            }
        }
        return res;
    }


    /**
     *
     * @return
     */
    public boolean deplacerBloc() {

        return true;
    }

    /**
     * Boolean qui nous permet de savoir si la case a la position
     * (x,y) est une instance de CaseVisible
     * @param x coordonées x
     * @param y coordonées y
     * @return vrai si il est possible de placer un bloc
     * sur la case en question
     */
    public boolean DeplacerSurCase(int x, int y){
        return plateau[x][y] instanceof CaseVisible;
    }

    /**
     * Méthode qui va initialiser le tracage du laser en fonction de son
     * point de départ et de son orientation;
     */
    public void InitLaser(){
        for(Laser l : lasers){
            calculerChemin(l);
        }
    }

    //calcule les points touchés par le laser passé en paramètre
    public void calculerChemin(Laser l){
        int i = l.x;
        int j = l.y;
        while(i <= 2*this.height && j <= 2*this.width && i >= 0 && j >= 0){
            l.points.add(new Point(i,j));
            l.orientation = nouvelAngle(i,j,l.orientation);
            //System.out.println("i: " + i + ", j:" + j);
            if(l.orientation == 45){
                i--;
                j++;
            }
            else if(l.orientation == 135){
                i--;
                j--;
            }
            else if(l.orientation == 225){
                i++;
                j--;
            }
            else if(l.orientation == 315){
                i++;
                j++;
            }
        }
    }

    public void CibleAtteinte(){
        for( Laser l : lasers) {
            for(Point point : l.points){
                for(int i = 0; i < cibles.length; i++){
                    if(cibles[i].p.x == point.x && cibles[i].p.y == point.y)
                        cibles[i].atteint = true;
                }
            }
        }
    }

    /**
     * Initialisation des plateau un peu commme des niveaux*/

    public void initdemo() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                plateau[i][j] = new CaseVisible();
            }
        }
        // plateau[5][5] = new CaseCachee();
        // plateau[5][6] = new CaseCachee();
        plateau[3][3] = new CaseVisible(new BlocOpaque(0, 2));

    }

    public int nouvelAngle(int x, int y, int angle) {
        int[] caseVerif = caseAVerifier(x, y, angle);
        if (caseVerif!=null && getCase(caseVerif[0], caseVerif[1]).BlocPresent()) {
            System.out.println(caseVerif[0] + " " + caseVerif[1]);
            if (caseVerif[0] % 2 == 1) {
                switch (angle) {
                    case 45:
                        return 135;
                    case 135:
                        return 45;
                    case 225:
                        return 315;
                    case 315:
                        return 225;
                }
            } else if (caseVerif[1] % 2 == 1) {
                switch (angle) {
                    case 45:
                        return 315;
                    case 135:
                        return 225;
                    case 225:
                        return 135;
                    case 315:
                        return 45;
                }
            }
        }
        return angle;
    }

    public int[] caseAVerifier(int x, int y, int angle){
        int[] res = new int[2];
        if(x < 0 || y < 0 || x >= 2*this.height || y >= 2*this.width){
            return null;
        }
        if(x%2 == 1){
            if(angle == 45 || angle == 315){
                res[0] = (x+1)/2;
                res[1] = (y+2)/2;
            }
            else if(angle == 225 || angle == 135){
                res[0] = (x+1)/2;
                res[1] = (y)/2;
            }
        }
        else if(y%2 == 1){
            if(angle == 45 || angle == 135){
                res[0] = (x)/2;
                res[1] = (y+1)/2;
            }
            else if(angle == 225 || angle == 315){
                res[0] = (x+2)/2;
                res[1] = (y+1)/2;
            }
        }
        if(res[0] >= this.height || res[1] >= this.width)
            return null;
        return res;
    }
}
