package DashBoards;

import javax.swing.*;
import java.awt.*;

public class PatronDashboardUI extends JFrame {
    public PatronDashboardUI() {
        setTitle("NU LibTrack - Patron Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JButton("Search Catalog"));
        panel.add(new JButton("My Borrowed Books"));
        panel.add(new JButton("Reservations"));
        panel.add(new JButton("Fines & Penalties"));
        panel.add(new JButton("Notifications"));
        panel.add(new JButton("Logout"));

        add(panel);
        setVisible(true);
    }
}

