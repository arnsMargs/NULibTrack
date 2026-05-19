package PatronsPanel;

import javax.swing.*;
import java.awt.*;

public class FinesPanel extends JPanel {
    public FinesPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,245,245));

        JLabel title = new JLabel("Fines & Penalties", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JButton payBtn = new JButton("Pay Fines");
        payBtn.setBackground(new Color(255,204,0));
        add(payBtn, BorderLayout.CENTER);
    }
}
