package vue;

import java.awt.Point;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JDialog;

public class FinDePartie extends JDialog {
    
    public JButton but = new JButton("Fermer");
    
    public FinDePartie () {
        super.setSize(250, 250);
        super.setLocation(new Point(300,300));
        super.setTitle("Victoire");
        super.setVisible(true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        but.addActionListener(e -> { super.dispose();});
        super.add(but);
    }
    
    
}
