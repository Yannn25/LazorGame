package Vue;

import Modele.*;
import Modele.Laser;
import Modele.Plateau;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;


public class Vue extends JFrame {
  
    JPanel panTabCase = new JPanel();
    JLabel jLabels[][] = new JLabel[3][3];
    JLabel p[] =new JLabel[50];

    
    protected Plateau plat;
    private Graphics2D g2;
    
    public Vue(Plateau p){ 
        super(" Vue ");
        super.setSize(1200, 650);
        super.setVisible(true);
        super.setLayout(null);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.g2 = (Graphics2D) this.getGraphics();
        this.plat = p;
        panTabCase.setLayout(null);
        panTabCase.setBounds(getWidth()/2, getHeight()/2, 200, 200);
        panTabCase.setBackground(Color.WHITE);
        panTabCase.addMouseMotionListener(ma);
        panTabCase.addMouseListener(ma);

        JLabel posiCible = new JLabel();
        posiCible.setLayout(null);
        posiCible.setBounds(0,0 , 5, 5);
        posiCible.setBackground(Color.RED);

        InititialisationPlateauet();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panTabCase);
        setLocationRelativeTo(null);

    }

    public Plateau getPlat() {
        return plat;
    }
    public void setPlat(Plateau plat) {
        this.plat = plat;
    }
    
    @Override
    public void paint(Graphics g){
        Plateau();
        TraceLaser(); 
    }
    /**
     * Méthode qui permet de tracer la trajectoire de chaque laser
     * appartenant à notre plateau PLAT.
     * @param g
     */
    public void TraceLaser(){
        int i=0;
        for (Laser l : plat.getLasers()) {
            //on vérifie bien que l n'est pas null
            if(l != null){
                //on parcours l'ensemble des points de notre laser
                for(Point p : l.getPoints()){
                    if( i < l.getPoints().size()-1){//ici on vérifie que i n'est pas a la dernière position
                        if(l.getPoints().get(i+1) != null){//et la on vérifie que le point suivant n'est pas null
                            Point suiv = l.getPoints().get(i+1);
                            Line2D line = new Line2D.Float(p.x, p.y, suiv.x, suiv.y);
                            g2.setColor(Color.red);
                            g2.setStroke(new BasicStroke((float) 2.0,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
                            g2.draw(line);
                            i++;
                        }
                    }
                }
            }
        }   
    }
    
    MouseAdapter ma = new MouseAdapter() {
		JPanel selectionPanel = null;
		Point selectionlabelposition = null;
		Point panelClickposition = null;

		@Override
		public void mousePressed(MouseEvent e) {

			Component pressedComp = panTabCase.findComponentAt(e.getX(), e.getY());
			try {
				if (pressedComp != null && pressedComp instanceof JPanel) {
					selectionPanel = (JPanel) pressedComp;
					selectionlabelposition = selectionPanel.getLocation();
					panelClickposition = e.getPoint();
					panTabCase.setComponentZOrder(selectionPanel, 0);
					selectionPanel.repaint();
				}

			}catch (IllegalArgumentException ex) {
				panTabCase.setLocation(0, 0);
				System.out.println("impossible de deplacer");
			}

		}

		@Override
		public void mouseDragged( MouseEvent e) {
			try {
				if (selectionPanel != null
						&& selectionlabelposition != null
						&& panelClickposition != null && selectionPanel.getName()!="null") {

					Point newPanelClickPoint = e.getPoint();

					final int newX = selectionlabelposition.x + (newPanelClickPoint.x - panelClickposition.x),
					newY = selectionlabelposition.y + (newPanelClickPoint.y - panelClickposition.y);

					//System.out.println(selectionlabelposition.x);

					selectionPanel.setLocation(newX, newY);
					String labelname= this.selectionPanel.getName();

					switch (labelname){
						case  "Label22" :

							if(this.selectionPanel.getX()<=30 && this.selectionPanel.getY()<=30){
								selectionPanel.setLocation(55, 55);
							}

							if( this.selectionPanel.getX()<=55 && this.selectionPanel.getY()<=55){
								selectionPanel.setLocation(55, 55);
							}

							if ( this.selectionPanel.getX()==55 && this.selectionPanel.getY()==55){
								panTabCase.removeAll();
								MiseajourPlateau(this.selectionPanel.getX(),this.selectionPanel.getY(),this.selectionPanel.getName());
								panTabCase.repaint();
							}

							if (this.selectionPanel.getX() >=130 && this.selectionPanel.getY() >=130) {
								selectionPanel.setLocation(110, 110);

								panTabCase.removeAll();
								InititialisationPlateauet();
								panTabCase.repaint();
								// MiseajourPlateau(this.selectionPanel.getX(),this.selectionPanel.getY(),this.selectionPanel.getName());
								// panTabCase.repaint();
							}

					}

				}
			} catch (NullPointerException ex) {
				panTabCase.setLocation(0, 0);
				System.out.println("impossible de déplacer une case vide");
			}

		}

	};

	public void InititialisationPlateauet( ){
		// var jLabels1 = new JLabel[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					jLabels[i][j] = new JLabel();
					jLabels[i][j].setBounds(j * 55, i * 55, 50, 50);
					jLabels[i][j].setLayout(null);
					jLabels[i][j].setOpaque(true);

					JPanel casep[][] = new JPanel[3][3];
					casep[i][j] = new JPanel();
					casep[i][j].setBounds(j * 55, i * 55, 50, 50);
					casep[i][j].setBackground(Color.RED);
					casep[i][j].setName("Label" + i + j);
					casep[i][j].setLayout(null);

					if (i == 2 && j == 2) {
						panTabCase.add(casep[i][j]);

					}

					if (i == 1 && j == 1 || i == 2 && j == 2) {
						jLabels[i][j].setBackground(Color.gray);
					} else {
						jLabels[i][j].setBackground(Color.WHITE);
					}
				//	new Laser( jLabels[i][j], panTabCase);
					panTabCase.add(jLabels[i][j]);
				}
			}
	}

	public void MiseajourPlateau(int x, int y,String nombloc){

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				jLabels[i][j] = new JLabel();
				jLabels[i][j].setBounds(j * 55, i * 55, 50, 50);
				jLabels[i][j].setLayout(null);
				jLabels[i][j].setOpaque(true);

				JPanel casep[][] = new JPanel[3][3];
				casep[i][j] = new JPanel();
				casep[i][j].setBounds(j * 55, i * 55, 50, 50);
				casep[i][j].setBackground(Color.RED);
				casep[i][j].setLayout(null);

				casep[i][j].setLocation(x, y);
				casep[i][j].setName(nombloc);
				panTabCase.add(casep[i][j]);


				if (i == 1 && j == 1 || i == 2 && j == 2) {
					jLabels[i][j].setBackground(Color.gray);
				} else {
					jLabels[i][j].setBackground(Color.WHITE);
				}

				if (casep[i][j].getName() == nombloc) {

				}

				//orientationLazer(0,x,y);
				//new Laser(x, y, 0, jLabels[i][j], panTabCase);

				panTabCase.add(jLabels[i][j]);
				panTabCase.repaint();
			}
		}
	}

        public void Plateau(){
            plat.initdemo();
            for(int i=10; i <= 10*plat.getWidth(); i+=10){
                for(int j=10; j <= 10*plat.getHeight(); j+=10){
//                    if(plat.getCase(i/10, j/10) instanceof CaseVisible){
                        g2.setColor(Color.gray.brighter());
                        g2.drawRect(13*i, 13*j, 100, 100);
                       // if(plat.getCase(i/10, j/10).BlocPresent()){
                         //   g2.fill3DRect(15*i, 15*j, 100, 100, rootPaneCheckingEnabled);
                        //}
                    //}                    
                }
            }
        }


//    MouseAdapter ma = new MouseAdapter() {
//        public void MousePressed(MouseEvent e){
//            if(plat.DeplacerSurCase(e.getX(), e.getY())){
//                
//            }
//        }
//    };
    
}