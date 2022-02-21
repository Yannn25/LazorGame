package Modele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plateau extends JFrame {

	JPanel panTabCase = new JPanel();
	JLabel jLabels[][] = new JLabel[3][3];
	JLabel p[] =new JLabel[50];

	final int width;
	final int height;
	protected Case[][] plateau;
	protected Cible[] cibles; //Toutes les cibles du plateau
	protected Laser[] lasers; //Tous les lasers du plateau
	
	public Plateau(int height, int width) {
		
		this.height=height;
		this.width=width;
		this.plateau = new Case[height][width];


		panTabCase.setLayout(null);
		panTabCase.setBounds(0, 0, 200, 200);
		panTabCase.setBackground(Color.WHITE);

		panTabCase.addMouseMotionListener(ma);
		panTabCase.addMouseListener(ma);


		tracagelaser();
		InititialisationPlateauet(-1, -1, jLabels);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		add(panTabCase);
		setLocationRelativeTo(null);


		
	}
	
	public boolean deplacerBloc() {
		return true;
	}




	public static int[] produitMatrices(int mat[][], int x1,int x2){
		int produit[] = new int [2];

		produit[0] = mat[0][0]*x1 + mat[0][1]*x2;
		produit[1] = mat[1][0]*x1 + mat[1][1]*x2;
		return produit;

	}

	public Case getCase(int x, int y){
		return plateau[x][y];
	}

	public void setCase(int x, int y,Case c){
			plateau[x][y] = c;
	}
	
	public void init(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				plateau[i][j] = new CaseVisible();
			}
		}
	}


	public void InititialisationPlateauet(int x,int y,JLabel jLabels[][]  ){
		// var jLabels1 = new JLabel[3][3];
		if(x==-1 && y==-1 ) {
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
					panTabCase.add(jLabels[i][j]);
				}
			}
		}

	}

	public void tracagelaser() {

		for (int i = 0; i < 50; i++) {
			p[i]=new JLabel();
			p[i].setLayout(null);
			p[i].setBounds(20 + i * 5, 155 - i * 5, 5, 5);
			p[i].setOpaque(true);
			p[i].setBackground(Color.BLUE);

			if (i % 11 == 0) {
				p[i].setBackground(Color.CYAN);
			}
			panTabCase.add(p[i]);
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



								System.out.println("action");
							}


					}

				}
			} catch (NullPointerException ex) {
				panTabCase.setLocation(0, 0);
				System.out.println("impossible de déplacer une case vide");
			}

		}

	};


	public static void main( String[] args) {

		Plateau frame = new Plateau(0,0);

		frame.setVisible(true);
	}


}
