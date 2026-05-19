package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {
    public NotificationPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,245,245));

        JLabel title = new JLabel("Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JTextArea area = new JTextArea("No new notifications.");
        area.setEditable(false);
        add(area, BorderLayout.CENTER);
    }
}