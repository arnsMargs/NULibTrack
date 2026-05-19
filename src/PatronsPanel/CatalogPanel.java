package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class CatalogPanel extends JPanel {
    public CatalogPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,245,245));

        JLabel title = new JLabel("Online Catalog Search", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new GridLayout(2,2,10,10));
        searchPanel.add(new JComboBox<>(new String[]{"All Categories","Science","Technology","Arts"}));
        searchPanel.add(new JComboBox<>(new String[]{"All Formats","Book","E-book"}));
        searchPanel.add(new JTextField("Enter book title..."));
        JButton searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(255,204,0));
        searchPanel.add(searchBtn);

        add(searchPanel, BorderLayout.CENTER);

        // Example search results
        String[] cols = {"Title","Author","Year","Status","Action"};
        Object[][] data = {
            {"Modern Java Programming","John Bailey","2020","Available","Request to Borrow"},
            {"Digital Marketing","-","2020","Borrowed","Return"},
            {"Introduction to OOP","-","2020","Available","Renew"}
        };
        JTable table = new JTable(data, cols);
        add(new JScrollPane(table), BorderLayout.SOUTH);
    }
}
