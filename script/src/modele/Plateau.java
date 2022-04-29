package modele;

import java.awt.*;
import java.util.LinkedList;

public class Plateau {

    public int width;
    public int height;
    protected Case[][] plateau;
    protected Cible[] cibles; //Toutes les cibles du plateau
    protected Laser[] lasers; //Tous les lasers du plateau
    Bloc b;
    LinkedList<Laser[]> tablasers = new LinkedList<>();
    protected boolean win;

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
    public Cible[] getCibles() {
        return cibles;
    }
    public void setCibles(Cible[] cibles) {
        this.cibles = cibles;
    }
    public boolean isWin() {
        return win;
    }    

    public boolean winCondtion() {
        boolean res=true;
        for(Cible c : this.cibles) {
            boolean b = false;
            for(Laser l:this.lasers) {
                for(Point p : l.points){
                    if( c.getPoint().x == p.x && c.getPoint().y == p.y) {
                        b=true;
                        break;
                    }
                } 
            }
            if(!b) {
                res = false;
                break;
            }
        }
        if(res){
            System.out.println("VICTOIRE");
            win = true;
        }
        return res;
    }


    /**
     *
     * @return
     */
    public boolean deplacerBloc(int x1,int y1,int x2,int y2) {

        if (deplacementPossible(x1, y1, x2, y2) && !(x1 == x2 && y1 == y2)){
            getCase(x2, y2).ajouterBloc(getCase(x1, y1).getBloc());
            getCase(x1, y1).enleverBloc();
            return true;
        }

        return false;
    }

    /*
     * Boolean qui nous permet de savoir si la case a la position
     * (x,y) est une instance de CaseVisible
     * @param x coordonées x
     * @param y coordonées y
     * @return vrai si il est possible de placer un bloc
     * sur la case en question
     */
    public boolean estVisible(int x, int y){
        return plateau[x][y] instanceof CaseVisible;
    }

    /**
     * Méthode qui va initialiser le tracage du laser en fonction de son
     * point de départ et de son orientation;
     */
    public void initLaser(){
        for(Laser l : lasers){
            if (l!=null){
               l.points = new LinkedList<Point>();
               tablasers.add(lasers);
               calculerChemin(l);
            }
        }
        CibleAtteinte();
        winCondtion();
        System.out.println(cibles[0].isAtteint());
    }


    public boolean deplacementPossible(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2){
            return true;
        }
        return !(getCase(x1, y1) instanceof CaseCachee) &&
        !(getCase(x2, y2) instanceof CaseCachee) &&
        !getCase(x2, y2).BlocPresent();
    }


    //calcule les points touchés par le laser passé en paramètre
    public void calculerChemin(Laser l){
        int i = l.x;
        int j = l.y;
        int angletmp = l.orientation;
        int oldtmp = angletmp;
        while(i <= 2*this.height && j <= 2*this.width && i >=0 && j >=0) {
            l.points.add(new Point(i,j));
            oldtmp = angletmp;
            angletmp = nouvelAngle(i, j, angletmp,l);
            if (angletmp == 90 ) {
                l.points.add(new Point(i, j+2));
                j += 2;
                angletmp = oldtmp;
            }
            if(angletmp == 270){
                l.points.add(new Point(i, j-2));
                j -= 2;
                angletmp = oldtmp;
            }
            if(angletmp == 180) {
                l.points.add(new Point(i+2, j));
                i+=2;
                angletmp = oldtmp;
            }
            if(angletmp == 0){
                l.points.add(new Point(i-2, j));
                i-=2;
                angletmp = oldtmp;
            }
            if (angletmp == 45) {
                i--;
                j++;
            } else if (angletmp == 135) {

                i--;
                j--;

            } else if (angletmp == 225) {

                i++;
                j--;

            } else if (angletmp == 315) {

                i++;
                j++;

            } else if (angletmp == -1) {
                i=1-i;
                j=1-j;
            }
        }

    }

    public void CibleAtteinte(){

        for( Laser l : lasers) {
            for(int i = 0; i < cibles.length; i++){
                    cibles[i].atteint = false;
                }
            for(Point point : l.points){
                for(int i = 0; i < cibles.length && cibles[i].atteint == false; i++){
                    if(cibles[i].p.x == point.x && cibles[i].p.y == point.y)
                        cibles[i].atteint = true;
                }
            }
        }
    }

    /* Initialisation des plateau un peu commme des niveaux*/

    public void initdemo() {
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                plateau[i][j] = new CaseVisible();
            }
        }
        plateau[3][3] = new CaseVisible(new BlocReflechissant());
        plateau[8][1] = new CaseVisible(new BlocPrisme());
        plateau[7][7] = new CaseVisible(new BlocSemiReflechissant());
        plateau[2][3] = new CaseVisible(new BlocOpaque());
    }

    public int nouvelAngle(int x, int y, int angle, Laser l) {
        int[] caseVerif = caseAVerifier(x, y, angle);
        if(caseVerif!=null && getCase(caseVerif[0], caseVerif[1]).BlocPresent()){
            b=getCase(caseVerif[0], caseVerif[1]).getBloc();
            return b.deviationLaser(x, y,angle);
        }  
        return angle ;
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