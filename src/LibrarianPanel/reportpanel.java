package LibrarianPanel;

import javax.swing.*;
import java.awt.*;

public class reportpanel extends JPanel {
    public reportpanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Reports Section", JLabel.CENTER), BorderLayout.NORTH);
        add(new JTextArea("Report details will appear here..."), BorderLayout.CENTER);
    }
}
