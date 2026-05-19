package DashBoards.LibrarianDashboards;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class LibrarianDashboardUI extends JFrame {

    Color navy = new Color(0, 51, 102);
    Color yellow = new Color(255, 204, 0);
    Color bg = new Color(240, 240, 240);

    // ✅ DATA
    ArrayList<Book> books = new ArrayList<>();
    int reservations = 5;
    int overdueCount = 8;
    double unpaidFees = 60.0;

    JTextArea notifArea;
    JButton overdueBtn, unpaidBtn;

    // ================= BOOK CLASS =================
    class Book {
        String title, author;
        int quantity;

        Book(String t, String a, int q) {
            title = t;
            author = a;
            quantity = q;
        }
    }

    public LibrarianDashboardUI() {

        // ✅ SAMPLE DATA
        books.add(new Book("Java Programming","John Smith",5));
        books.add(new Book("Marketing","Anna Cruz",2));

        setTitle("NU LibTrack - Librarian Dashboard");
        setSize(1400, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ================= HEADER =================
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(navy);

        JLabel title = new JLabel("NU LibTrack");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(new EmptyBorder(10, 20, 10, 10));

        JLabel dash = new JLabel("Librarian Dashboard");
        dash.setForeground(Color.WHITE);

        top.add(title, BorderLayout.WEST);
        top.add(dash, BorderLayout.CENTER);

        add(top, BorderLayout.NORTH);

        // ================= MAIN =================
        JPanel main = new JPanel(new GridLayout(3,2,15,15));
        main.setBorder(new EmptyBorder(15,15,15,15));
        main.setBackground(bg);

        // ================= BOOK MANAGEMENT =================
        JPanel booksPanel = createPanel("Book Management");

        JButton add = createButton("Add New Book");
        add.addActionListener(e -> addBook());

        JButton edit = createButton("Edit Book");
        edit.addActionListener(e -> editBook());

        JButton remove = createButton("Remove Book");
        remove.addActionListener(e -> removeBook());

        JButton bulk = createButton("Bulk Upload");
        bulk.addActionListener(e ->
                JOptionPane.showMessageDialog(this,"Bulk upload simulated ✅"));

        booksPanel.add(add);
        booksPanel.add(edit);
        booksPanel.add(bulk);
        booksPanel.add(remove);

        // ================= CIRCULATION =================
        JPanel circulation = createPanel("Circulation");

        JButton issue = createButton("Issue Book");
        issue.addActionListener(e -> issueBook());

        JButton ret = createButton("Return Book");
        ret.addActionListener(e -> returnBook());

        JButton renew = createButton("Renew Book");
        renew.addActionListener(e ->
                JOptionPane.showMessageDialog(this,"Book renewed for 3 days ✅"));

        circulation.add(issue);
        circulation.add(ret);
        circulation.add(renew);

        // ================= RESERVATION =================
        JPanel reserve = createPanel("Reservations");

        JLabel pending = new JLabel("Pending: " + reservations);

        JButton viewRes = createButton("View Reservations");
        viewRes.addActionListener(e ->
                JOptionPane.showMessageDialog(this,"Reservations: " + reservations));

        reserve.add(pending);
        reserve.add(viewRes);

        // ================= FINES =================
        JPanel fines = createPanel("Fines");

        overdueBtn = new JButton("Overdue: " + overdueCount);
        overdueBtn.setBackground(Color.RED);
        overdueBtn.setForeground(Color.WHITE);

        unpaidBtn = new JButton("Unpaid: ₱" + unpaidFees);
        unpaidBtn.setBackground(Color.GREEN);

        JButton paid = new JButton("Mark Paid");
        paid.setBackground(yellow);

        paid.addActionListener(e -> {
            unpaidFees = 0;
            unpaidBtn.setText("Unpaid: ₱0");
        });

        fines.add(overdueBtn);
        fines.add(unpaidBtn);
        fines.add(paid);

        // ================= REPORTS =================
        JPanel reports = createPanel("Reports");

        JButton summary = createButton("Dashboard Summary");
        summary.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Total Books: " + books.size()));

        reports.add(summary);
        reports.add(createButton("Usage Analytics"));

        // ================= NOTIFICATIONS =================
        JPanel notif = createPanel("Notifications");
        notif.setLayout(new BorderLayout());

        notifArea = new JTextArea();
        notifArea.setText("System Ready ✅");

        notif.add(new JScrollPane(notifArea));

        // ================= ADD =================
        main.add(booksPanel);
        main.add(circulation);
        main.add(reserve);
        main.add(fines);
        main.add(reports);
        main.add(notif);

        add(main, BorderLayout.CENTER);
        setVisible(true);
    }

    // ================= ACTION METHODS =================

    private void addBook() {
        String title = JOptionPane.showInputDialog("Book Title:");
        String author = JOptionPane.showInputDialog("Author:");
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Quantity:"));

        books.add(new Book(title,author,qty));

        notifArea.append("\nAdded: " + title);
    }

    private void editBook() {
        String title = JOptionPane.showInputDialog("Enter book to edit:");

        for(Book b: books){
            if(b.title.equalsIgnoreCase(title)){
                b.quantity = Integer.parseInt(JOptionPane.showInputDialog("New Quantity:"));
                notifArea.append("\nEdited: " + title);
                return;
            }
        }

        JOptionPane.showMessageDialog(this,"Not found");
    }

    private void removeBook() {
        String title = JOptionPane.showInputDialog("Book to remove:");

        books.removeIf(b -> b.title.equalsIgnoreCase(title));
        notifArea.append("\nRemoved: " + title);
    }

    private void issueBook() {
        String title = JOptionPane.showInputDialog("Issue book:");

        for(Book b: books){
            if(b.title.equalsIgnoreCase(title) && b.quantity>0){
                b.quantity--;
                notifArea.append("\nIssued: " + title);
                return;
            }
        }

        JOptionPane.showMessageDialog(this,"Not available");
    }

    private void returnBook() {
        String title = JOptionPane.showInputDialog("Return book:");

        for(Book b: books){
            if(b.title.equalsIgnoreCase(title)){
                b.quantity++;
                notifArea.append("\nReturned: " + title);
                return;
            }
        }
    }

    // ================= UI HELPERS =================

    private JPanel createPanel(String title){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new GridLayout(3,2,10,10));
        return panel;
    }

    private JButton createButton(String text){
        JButton b = new JButton(text);
        b.setBackground(navy);
        b.setForeground(Color.WHITE);
        return b;
    }

    public static void main(String[] args){
        new LibrarianDashboardUI();
    }
}