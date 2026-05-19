package LibrarianPanel;
import javax.swing.*;
import java.awt.*;

public class dashpanels extends JPanel {
    public dashpanels() {
        setLayout(new BorderLayout());
        add(new JLabel("Welcome to NU LibTrack Dashboard", JLabel.CENTER), BorderLayout.CENTER);
    }
}

