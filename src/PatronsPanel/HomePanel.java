package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new GridLayout(2, 3, 20, 20));
        setBackground(new Color(245, 245, 245));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        add(makePanel("Online Catalog Search", new Color(255, 204, 0)));
        add(makePanel("Recommendations", new Color(0, 51, 102)));
        add(makePanel("Real-Time Availability", new Color(0, 153, 0)));
        add(makePanel("My Borrowed Books", new Color(0, 102, 204)));
        add(makePanel("My Reservations", new Color(255, 102, 0)));
        add(makePanel("Fines & Penalties", new Color(204, 0, 0)));
    }

    private JPanel makePanel(String title, Color bg) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);
        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
