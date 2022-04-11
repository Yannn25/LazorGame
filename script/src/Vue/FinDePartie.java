package Vue;

import java.awt.Point;
import java.awt.PopupMenu;
import javax.swing.JDialog;

public class FinDePartie extends JDialog {
    
    
    
    public FinDePartie () {
        super.setSize(250, 250);
        super.setLocation(new Point(300,300));
        //super.add(new PopupMenu("Victoire"));
        super.setTitle("Victoire");
        super.setVisible(true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    
}
