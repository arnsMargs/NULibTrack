package DashBoards.LibrarianDashboards;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LibrarianDashboardUI extends JFrame {
    Color navy = new Color(0, 51, 102);
    Color yellow = new Color(255, 204, 0);
    Color bg = new Color(240, 240, 240);

    public LibrarianDashboardUI() {

        setTitle("NU LibTrack - Librarian Dashboard");
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

        JLabel dash = new JLabel("Librarian Dashboard");
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
        side.setLayout(new GridLayout(8, 1, 0, 5));

        String[] menu = {
                "Dashboard",
                "Books",
                "Borrow/Return",
                "Fines",
                "Reports",
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

        // =========================
        // BOOK MANAGEMENT
        // =========================

        JPanel books = createPanel("Book Management");

        books.add(createButton("Add New Book"));
        books.add(createButton("Edit Book"));
        books.add(createButton("Bulk Upload"));
        books.add(createButton("Remove Book"));

        // =========================
        // CIRCULATION
        // =========================

        JPanel circulation = createPanel("Circulation Management");

        circulation.add(createButton("Issue Book"));
        circulation.add(createButton("Return Book"));
        circulation.add(createButton("Renew Book"));

        // =========================
        // RESERVATION
        // =========================

        JPanel reserve = createPanel("Reservation System");

        JLabel pending = new JLabel("Pending Reservation: 5");
        pending.setFont(new Font("Arial", Font.BOLD, 18));

        reserve.add(pending);
        reserve.add(createButton("View Reservations"));
        reserve.add(createButton("Manage Holds"));

        // =========================
        // FINES
        // =========================

        JPanel fines = createPanel("Fine & Penalty Management");

        JButton overdue = new JButton("Overdue Alerts: 8");
        overdue.setBackground(new Color(220,53,69));
        overdue.setForeground(Color.WHITE);

        JButton unpaid = new JButton("Unpaid Fees: Php 60.00");
        unpaid.setBackground(new Color(40,167,69));
        unpaid.setForeground(Color.WHITE);

        JButton paid = new JButton("Paid Fines");
        paid.setBackground(yellow);

        fines.add(overdue);
        fines.add(unpaid);
        fines.add(paid);
        fines.add(createButton("View Fines"));
        fines.add(createButton("Send Reminder"));

        // =========================
        // REPORTS
        // =========================

        JPanel reports = createPanel("Reports & Analytics");

        reports.add(createButton("Dashboard Summary"));
        reports.add(createButton("Reports"));
        reports.add(createButton("Usage Analytics"));
        reports.add(createButton("Inventory Reports"));
        reports.add(createButton("View Analytics"));

        // =========================
        // NOTIFICATIONS
        // =========================

        JPanel notif = createPanel("Notifications");

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        area.setText(
                "✓ 2 Books Due Tomorrow\n\n" +
                "✓ Reservation Pending\n\n" +
                "✗ Overdue Fine: Php 50"
        );

        notif.setLayout(new BorderLayout());
        notif.add(area, BorderLayout.CENTER);

        // =========================
        // ADD ALL PANELS
        // =========================

        main.add(books);
        main.add(circulation);
        main.add(reserve);
        main.add(fines);
        main.add(reports);
        main.add(notif);

        add(main, BorderLayout.CENTER);

        setVisible(true);
    }

    // =========================
    // CUSTOM PANEL
    // =========================

    private JPanel createPanel(String title){

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new GridLayout(3,2,10,10));

        return panel;
    }

    // =========================
    // CUSTOM BUTTON
    // =========================

    private JButton createButton(String text){

        JButton b = new JButton(text);

        b.setBackground(navy);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 16));

        return b;
    }
}
