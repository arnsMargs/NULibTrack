package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class AccountPanel extends JPanel {
    public AccountPanel() {
        setLayout(new GridLayout(4,1,10,10));
        setBackground(new Color(245,245,245));

        add(new JLabel("Name: Patron User"));
        add(new JLabel("Email: patron@example.com"));
        add(new JLabel("Membership: Active"));
        add(new JLabel("Borrow Limit: 5 books"));
    }
}