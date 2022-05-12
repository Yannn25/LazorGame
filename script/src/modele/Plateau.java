package modele;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;

import controleur.Controleur;

public class Plateau implements Serializable{

    private static final long serialVersionUID = 1371416004898345184L;

    public final int width;
    public final int height;
    public Case[][] cases;
    protected Cible[] cibles; //Toutes les cibles du plateau
    protected LinkedList<Laser> lasers;//Tous les lasers du plateau
    public int niveau;
    protected final int nblasers;
    protected boolean win;
    public static String PATH = "./script/src/";
    //public static String PATH = "./src/";

    /*  CONSTRUCTEUR   */
    public Plateau(int height, int width, LinkedList<Laser> las, Cible[] cibles) {
        this.height=height;
        this.width=width;
        this.cases = new Case[height][width];
        this.lasers = las;
        this.nblasers = lasers.size();
        this.cibles = cibles;
    }

    public Plateau(int niveau){
        this.niveau = niveau;
        Plateau sauvegarde = reprisePartie("Niveau" + niveau);
        this.height = sauvegarde.height;
        this.width = sauvegarde.width;
        this.cases = sauvegarde.cases;
        this.lasers = (LinkedList<Laser>) sauvegarde.lasers.clone();
        this.cibles = sauvegarde.getCibles();
        this.nblasers = sauvegarde.lasers.size();
       
    }
    
    /* GETTER ET SETTER */
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Case getCase(int x, int y){
        return cases[x][y];
    }
    public void setCase(int x, int y,Case c){
        cases[x][y] = c;
    }
    public LinkedList<Laser> getLasers() {
        return lasers;
    }
    public void setLasers(LinkedList<Laser> l) {
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

    
    /**
     * Vérifie que toutes les cibles du plateau sont atteinte
     * et va ensuite passer a vrai notre boolean win
     */
    public boolean winCondition() {
        boolean res=true;
        for(Cible c: this.cibles){
            if(!c.isAtteint())
                res = false;
        }
        if(res){
            win = true;
        }
        return res;
    }

    /**
     * Pour chaque cibles du plateau, vérifie si un point d'un des lasers
     * est a la meme coordonées que notre cible.
     */
     public void calculerCibles(){
        for(int i = 0; i < cibles.length; i++){
            cibles[i].atteint = false;
        }
        for(Laser l : lasers) {
            for(Point point : l.points){
                for(int i = 0; i < cibles.length; i++){
                    if(cibles[i].p.x == point.x && cibles[i].p.y == point.y)
                        cibles[i].atteint = true;
                }
            }
        }
    }
     
    /**
     *  Va effectuer le déplacement d'un bloc sur le plateau
     *  uniquement si cela est possible grace a la méthode deplacementPosible.
     * @param x1 x de départ
     * @param y1 y de départ
     * @param x2 x d'arriver
     * @param y2 y d'arriver
     * @return vrai si le bloc a été deplacer.
     */
    public boolean deplacerBloc(int x1,int y1,int x2,int y2) {
        
        if (deplacementPossible(x1, y1, x2, y2) && !(x1 == x2 && y1 == y2)){
            getCase(x2, y2).ajouterBloc(getCase(x1, y1).getBloc());
            getCase(x1, y1).enleverBloc();
            return true;
        }

        return false;
    }

    /**
     * Boolean qui nous permet de savoir si la case a la position
     * (x,y) est une instance de CaseVisible
     * @param x coordonées x
     * @param y coordonées y
     * @return vrai si il est possible de placer un bloc
     * sur la case en question
     */
    public boolean estVisible(int x, int y){
        return cases[x][y] instanceof CaseVisible;
    }

    
    /**
     * Méthode qui va initialiser le calcul des points des lasers du plateau.
     * Tous en vérifiant ses déviations et la condition de victoire.
     */
    public void initLaser(){
        int size = lasers.size();
        for(int i = nblasers; i<size; i++){
            lasers.remove(nblasers);
        }
        for(int i=0;i < lasers.size();i++){
            if (lasers.get(i)!=null ){
                lasers.get(i).points = new LinkedList<Point>();
                calculerChemin(lasers.get(i));
            }
        }
        calculerCibles();
        winCondition();
    }

        /**
     * 
     * @param x1 x de départ
     * @param y1 y de départ
     * @param x2 x d'arriver
     * @param y2 y d'arriver
     * @return vrai si il est possible de deplacer un bloc
     * d'un point (x1,y1) a un autre point (x2,y2)
     * */
    public boolean deplacementPossible(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2){
            return true;
        }
        return (!(getCase(x1, y1) instanceof CaseCachee) &&
        !(getCase(x2, y2) instanceof CaseCachee) &&
        !getCase(x2, y2).blocPresent());
    }


    /**
     * Ajoute au laser l tous les points qu'il traverse, en fonction de 
     * son point de départ et de son orientation.
     * @param l le laser en question
     */
    public void calculerChemin(Laser l){
        int i = l.x;
        int j = l.y;
        int angletmp = l.orientation;
        int oldtmp;
        while(i <= 2*this.height && j <= 2*this.width && i >=0 && j >=0) {
            l.points.add(new Point(i,j));
            //cas du bloc prismatique
            oldtmp = angletmp;
            angletmp = nouvelAngle(i, j, angletmp);
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

   /**
    * Un nouvelle angle est renvvoyer en fonction du type de bloc présent 
    * aux alentours du point (x,y).
    * Pour les bloc SemiReflechissant et Teleporteur, ont traitera ces cas
    * directement dans la méthode, étant donné qu'elle nécesite l'ajout d'un 
    * nouveau laser.
    * @param x le point i
    * @param y le point j
    * @param angle l'orientaion de base du laser
    * @return le nouvel angle d'orientation du laser
    */

    public int nouvelAngle(int x, int y, int angle) {
        int[] caseVerif = caseAVerifier(x, y, angle);
        if (caseVerif!=null && getCase(caseVerif[0], caseVerif[1]).blocPresent()){
            String nomBloc=getCase(caseVerif[0], caseVerif[1]).getBloc().getType();

            switch (nomBloc){
                case "BlocSemiReflechissant":{
                    int k=0;
                    switch (angle) {
                        case 45:
                        lasers.add(new Laser(x - 1, y + 1, angle));
                            break;
                        case 135:
                            lasers.add(new Laser(x - 1, y - 1, angle));
                            break;
                        case 225:
                            lasers.add(new Laser(x + 1, y - 1, angle));
                            break;
                        case 315:
                            lasers.add(new Laser(x + 1, y + 1, angle));
                            break;
                        default:
                    }
                    return getCase(caseVerif[0], caseVerif[1]).getBloc().deviationLaser(x, y, angle);
                }
                case "BlocTeleporteur":
                    int a = 0,b = 0;
                    for (int i = 0; i < this.height; i++) {
                        for (int j = 0; j < this.width; j++) {
                            if (!(caseVerif[0] == i && caseVerif[1] == j) && getCase(i,j).getBloc() instanceof BlocTeleporteur) {
                                a = i;
                                b = j;
                            }
                        }
                    }
                    int diff_i = caseVerif[0]-a;
                    int diff_j = caseVerif[1]-b;
                    if (x%2 == 1 && y%2==0) {
                        switch (angle){
                            case 45:
                            case 315:
                                lasers.add(new Laser(x - 2*diff_i, y - 2*diff_j + 2, angle));
                                break;
                            case 135:
                            case 225:
                                lasers.add(new Laser(x - 2*diff_i, y - 2*diff_j - 2, angle));
                                break;
                        }
                    }
                    if (x%2 == 0 && y%2==1) {
                        switch (angle){
                            case 45:
                            case 135:
                                lasers.add(new Laser(x - 2*diff_i - 2, y - 2*diff_j, angle));
                                break;
                            case 315:
                            case 225:
                                lasers.add(new Laser(x - 2*diff_i + 2, y - 2*diff_j, angle));
                                break;
                        }
                    }
                    return -1;
                default:{
                    return getCase(caseVerif[0], caseVerif[1]).getBloc().deviationLaser(x, y, angle);
                }
            }
        }
        return angle ;
    }
    
    /**
     * Vérifie si un bloc est présent aux alentours du point (x,y).
     * @param x le point i
     * @param y le point j
     * @param angle l'orientaion de base du laser
     * @return un tableau de taille 2, composé des coordonées du bloc 
     * le plus proche des coordonées x et y.
     */
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

    /*
            MÉTHODE DE SAUVEGARDE DU PLATEAU
    */

    public void sauvegarder(String fileName) throws IOException {
        try {

            FileOutputStream file = new FileOutputStream(Plateau.PATH + "niveaux/"+fileName+".ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this);

            System.out.println(fileName + " sauvegardé");
            out.close();

        }catch(FileNotFoundException fnf){
            System.out.println("fichier de sauvegarde non trouvé");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Partie non sauvegardée erreur (fichier de sauvegarde?)");
        }catch(NullPointerException np){
            System.out.println("ressource pas trouvée");
        }

    }

    public static Plateau reprisePartie (String filename){
        Plateau p = null;
        try {
            System.out.println(Plateau.PATH + "niveaux/"+filename+".ser");
            FileInputStream file = new FileInputStream(Plateau.PATH + "niveaux/"+filename+".ser");
            ObjectInputStream in = new ObjectInputStream(file);

            p = (Plateau)in.readObject();

            System.out.println("objet recuperé");

            in.close();
            return (Plateau)p;
        }
        catch(FileNotFoundException e) {
            System.out.println("fichier non trouvé");
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("erreur");
            e.printStackTrace();
        }catch(NullPointerException e) {
            System.out.println("ressource pas trouvée");
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("L'objet n'est pas de la bonne classe");
            e.printStackTrace();
        }
        return p;
    }

    

} 