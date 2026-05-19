package LibrarianPanel;

import javax.swing.*;
import java.awt.*;

public class bookpanel extends JPanel {
    public bookpanel() {
        setLayout(new GridLayout(2, 1, 10, 10));
        add(new JButton("Add New Book"));
        add(new JButton("Search Books"));
    }
}
