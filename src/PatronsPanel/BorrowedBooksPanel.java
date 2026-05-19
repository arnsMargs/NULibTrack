package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class BorrowedBooksPanel extends JPanel {
    public BorrowedBooksPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,245,245));

        JLabel title = new JLabel("My Borrowed Books", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        String[] cols = {"Book Title","Action"};
        Object[][] data = {
            {"Intro to Object-Oriented Programming","Renew"},
            {"Digital Marketing","Return"}
        };

        JTable table = new JTable(data, cols);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}

