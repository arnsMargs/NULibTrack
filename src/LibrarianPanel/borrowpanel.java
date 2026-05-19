package LibrarianPanel;


import javax.swing.*;
import java.awt.*;

public class borrowpanel extends JPanel {
    public borrowpanel() {
        setLayout(new GridLayout(2, 1, 10, 10));
        add(new JButton("Issue Book"));
        add(new JButton("Return Book"));
    }
}


