package server.diagnosis.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class PopUps {
    //this section is extra and I'll implement the errors within the textfield first, perhaps doing this later if we have the time
    private JFrame popFrame;

    JDialog vDialog = new JDialog(popFrame, "Validation Error");
    JDialog cDialog = new JDialog(popFrame, "Connection Error");
    JDialog dDialog = new JDialog(popFrame, "Disconnection Error");
    
    JButton ok = new JButton("Ok");
    JButton tryAgain = new JButton("Try again");
}
