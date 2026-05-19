package UI.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SidebarStyle {

    public static void style(JButton btn) {

        Color normal = new Color(10, 40, 90);
        Color hover = new Color(20, 70, 150);

        btn.setBackground(normal);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));

        btn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hover);
                btn.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(normal);
                btn.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
            }
        });
    }
}
