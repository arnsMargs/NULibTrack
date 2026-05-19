package UI.utils;

import javax.swing.*;

public class PanelAnimator {

    public static void slide(JPanel container, JPanel newPanel) {

        int width = container.getWidth();

        newPanel.setBounds(width, 0, width, container.getHeight());

        container.add(newPanel);

        Timer timer = new Timer(5, null);

        timer.addActionListener(e -> {

            int x = newPanel.getX();

            if (x <= 0) {
                newPanel.setLocation(0, 0);
                timer.stop();

                container.remove(0);
                container.revalidate();
                container.repaint();
            } else {
                newPanel.setLocation(x - 20, 0);
            }
        });

        timer.start();
    }
}
