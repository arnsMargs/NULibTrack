package DashBoards;

import javax.swing.*;
import java.awt.*;

public class LibrarianDashboardUI extends JFrame {
    public LibrarianDashboardUI() {
        setTitle("NU LibTrack - Librarian Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JButton("Add New Book"));
        panel.add(new JButton("Issue Book"));
        panel.add(new JButton("Return Book"));
        panel.add(new JButton("Renew Book"));
        panel.add(new JButton("View Fines"));
        panel.add(new JButton("Reports"));

        add(panel);
        setVisible(true);
    }
}
