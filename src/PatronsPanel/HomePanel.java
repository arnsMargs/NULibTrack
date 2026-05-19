package PatronsPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import LibTrackModel.modelBook;
import Services.*;
import PatronsPanel.*;


public class HomePanel extends JPanel {

    public HomePanel() {

        setLayout(new BorderLayout(10,10));
        setBackground(new Color(240,240,240));

        /* ================= TOP SEARCH ================= */
        JPanel top = new JPanel();
        top.setBorder(BorderFactory.createTitledBorder("Online Catalog Search"));

        JComboBox<String> cat = new JComboBox<>(new String[]{"All Categories"});
        JComboBox<String> format = new JComboBox<>(new String[]{"All Formats"});
        JTextField search = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        top.add(cat);
        top.add(format);
        top.add(search);
        top.add(searchBtn);

        /* ================= CENTER GRID ================= */
        JPanel grid = new JPanel(new GridLayout(2,3,10,10));

        grid.add(grid, new CatalogPanel());
        grid.add(new BorrowedBooksPanel());
        grid.add(new ReservationPanel());
        grid.add(new AccountPanel());

        /* ================= BOTTOM ================= */
        JPanel bottom = new FinesPanel();

        add(top, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}