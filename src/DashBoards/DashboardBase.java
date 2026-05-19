package DashBoards;

import javax.swing.*;
import java.awt.*;
import UI.utils.PanelAnimator;

public abstract class DashboardBase extends JFrame {

    protected JPanel content;

    public DashboardBase(String title) {

        setTitle(title);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // IMPORTANT for animation
        content = new JPanel(null);

        add(createSidebar(), BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        setVisible(true);
    }

    protected abstract JPanel createSidebar();

    protected void switchPanel(JPanel panel) {

        panel.setBounds(0, 0, 900, 600);

        if (content.getComponentCount() == 0) {
            content.add(panel);
        } else {
            PanelAnimator.slide(content, panel);
        }

        content.repaint();
    }
}