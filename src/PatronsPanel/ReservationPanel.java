package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class ReservationPanel extends JPanel {
    public ReservationPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,245,245));

        JLabel title = new JLabel("My Reservations", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        String[] cols = {"Cover","Book Title","Status","Action"};
        
        ImageIcon coverIcon = new ImageIcon("images/modernjava.jpeg");

        Object[][] data = {
            {coverIcon,"Modern Java","Reserved","Cancel"}
        };

        JTable table = new JTable(data, cols) {
           
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) return Icon.class; 
                return Object.class;
            }
        };

        table.setRowHeight(60); 
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
