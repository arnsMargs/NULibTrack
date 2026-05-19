package DashBoards.PatronDashbaoards;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PatronDashboardUI extends JFrame {
    Color navy = new Color(0, 51, 102);
    Color yellow = new Color(255, 204, 0);
    Color bg = new Color(240, 240, 240);

    public PatronDashboardUI() {
        setTitle("NU LibTrack - Patron Dashboard");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // =========================
        // TOP HEADER
        // =========================
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(navy);
        top.setPreferredSize(new Dimension(1400, 70));

        JLabel title = new JLabel("NU LibTrack");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBorder(new EmptyBorder(10, 20, 10, 10));

        JLabel dash = new JLabel("Patron Dashboard");
        dash.setForeground(Color.WHITE);
        dash.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel centerTitle = new JPanel();
        centerTitle.setBackground(navy);
        centerTitle.add(dash);

        top.add(title, BorderLayout.WEST);
        top.add(centerTitle, BorderLayout.CENTER);

        JPanel yellowLine = new JPanel();
        yellowLine.setBackground(yellow);
        yellowLine.setPreferredSize(new Dimension(1400, 10));

        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(top, BorderLayout.CENTER);
        topContainer.add(yellowLine, BorderLayout.SOUTH);

        add(topContainer, BorderLayout.NORTH);

        // =========================
        // SIDEBAR
        // =========================
        JPanel side = new JPanel();
        side.setBackground(navy);
        side.setPreferredSize(new Dimension(220, 0));
        side.setLayout(new GridLayout(6, 1, 0, 5));

        String[] menu = {
                "Home",
                "Catalog",
                "My Account",
                "Reservation",
                "Fines",
                "Notifications"
        };

        for(String s : menu){
            JButton b = new JButton(s);
            b.setFocusPainted(false);
            b.setBackground(navy);
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Arial", Font.BOLD, 18));
            b.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            side.add(b);
        }

        add(side, BorderLayout.WEST);

        // =========================
        // MAIN CONTENT
        // =========================
        JPanel main = new JPanel();
        main.setBackground(bg);
        main.setBorder(new EmptyBorder(15,15,15,15));
        main.setLayout(new GridLayout(3,2,15,15));

        // Online Catalog Search
        JPanel catalog = createPanel("Online Catalog Search");
        catalog.setLayout(new BorderLayout());

        JPanel searchBar = new JPanel(new GridLayout(1,4,10,0));
        searchBar.add(new JComboBox<>(new String[]{"All Categories"}));
        searchBar.add(new JComboBox<>(new String[]{"All Formats"}));
        searchBar.add(new JTextField("Enter book title..."));
        JButton searchBtn = new JButton("Search");
        searchBtn.setBackground(yellow);
        searchBar.add(searchBtn);

        JPanel filters = new JPanel(new GridLayout(1,4,10,0));
        for(String f : new String[]{"Genre","Author","Publication Year","Availability"}){
            JButton btn = createButton(f);
            filters.add(btn);
        }

        catalog.add(searchBar, BorderLayout.NORTH);
        catalog.add(filters, BorderLayout.SOUTH);

        // Recommendations
        JPanel recs = createPanel("Recommendations");
        recs.add(new JLabel("No Available Data"));

        // Real-Time Availability
        JPanel avail = createPanel("Real-Time Availability");
        avail.setLayout(new GridLayout(1,4,10,10));
        avail.add(makeStatus("Available", new Color(0,153,0)));
        avail.add(makeStatus("Borrowed", new Color(0,102,204)));
        avail.add(makeStatus("Reserved", new Color(255,102,0)));
        avail.add(makeStatus("On Hold", new Color(204,0,0)));

        // My Borrowed Books
        JPanel borrowed = createPanel("My Borrowed Books");
        borrowed.setLayout(new GridLayout(2,2,10,10));
        borrowed.add(new JLabel("Intro to Object-Oriented Programming"));
        JButton renew = new JButton("Renew");
        renew.setBackground(yellow);
        borrowed.add(renew);
        borrowed.add(new JLabel("Digital Marketing"));
        JButton ret = createButton("Return");
        borrowed.add(ret);

        // My Reservations
        JPanel reserve = createPanel("My Reservations");
        reserve.setLayout(new BorderLayout());
        reserve.add(new JLabel("Modern Java"), BorderLayout.CENTER);
        JButton cancel = new JButton("Cancel");
        cancel.setBackground(new Color(204,0,0));
        cancel.setForeground(Color.WHITE);
        reserve.add(cancel, BorderLayout.SOUTH);

        // Reading History
        JPanel history = createPanel("Reading History");
        history.setLayout(new GridLayout(3,1));
        history.add(new JLabel("Modern Java – Borrowed: Mar 8, 2026; Returned: Mar 12, 2026"));
        history.add(new JLabel("Leadership 101 – Borrowed: Apr 1, 2026; Returned: Apr 9, 2026"));
        history.add(new JLabel("Basic Economics – Borrowed: Apr 1, 2026; Returned: Apr 9, 2026"));

        // Fines & Penalties
        JPanel fines = createPanel("Fines & Penalties");
        JButton payBtn = new JButton("Pay Fines");
        payBtn.setBackground(yellow);
        fines.add(payBtn);

        // Add all panels
        main.add(catalog);
        main.add(recs);
        main.add(avail);
        main.add(borrowed);
        main.add(reserve);
        main.add(history);
        main.add(fines);

        add(main, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createPanel(String title){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new FlowLayout());
        return panel;
    }

    private JButton createButton(String text){
        JButton b = new JButton(text);
        b.setBackground(navy);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 16));
        return b;
    }

    private JLabel makeStatus(String text, Color bg){
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setOpaque(true);
        l.setBackground(bg);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("Arial", Font.BOLD, 16));
        return l;
    }
}
