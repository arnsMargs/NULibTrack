package LibrarianPanel;

import javax.swing.*;
import java.awt.*;

public class finespanel extends JPanel {
    public finespanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Fines Management", JLabel.CENTER), BorderLayout.NORTH);
        add(new JTable(new Object[][] {
            {"User1", "₱50"},
            {"User2", "₱100"}
        }, new Object[] {"User", "Fine"}), BorderLayout.CENTER);
    }
}
