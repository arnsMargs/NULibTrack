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

        content = new JPanel(null); // IMPORTANT (for animation)

        add(createSidebar(), BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        setVisible(true);
    }

    protected abstract JPanel createSidebar();

    protected void switchPanel(JPanel panel) {

        panel.setSize(content.getWidth(), content.getHeight());

        if (content.getComponentCount() == 0) {
            content.add(panel);
            content.repaint();
        } else {
            PanelAnimator.slide(content, panel);
        }
    }
}
