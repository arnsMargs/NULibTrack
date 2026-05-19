package DashBoards.PatronDashbaoards;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class PatronDashboardUI extends JFrame {

    Color navy = new Color(20, 40, 80);
    Color yellow = new Color(255, 200, 0);
    Color bg = new Color(245, 245, 255);

    List<Book> books = new ArrayList<>();
    List<String> borrowedBooks = new ArrayList<>();
    List<String> reservedBooks = new ArrayList<>();
    List<History> historyList = new ArrayList<>();

    int booksRead = 0;
    int fineAmount = 150;

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> resultsList = new JList<>(listModel);

    JTextField searchField;
    JPanel borrowedPanel, reservePanel, historyPanel;
    JLabel feeLabel;

    // ================= BOOK =================
    class Book {
        int id, quantity;
        String title, author, status;

        Book(int id, String t, String a, int q, String s) {
            this.id = id;
            title = t;
            author = a;
            quantity = q;
            status = s;
        }
    }

    // ================= HISTORY =================
    class History {
        String title, author, borrowedDate, returnedDate;

        History(String t, String a, String b, String r) {
            title = t;
            author = a;
            borrowedDate = b;
            returnedDate = r;
        }
    }

    public PatronDashboardUI() {

        // SAMPLE DATA
        books.add(new Book(101,"Java Programming","John Smith",5,"Available"));
        books.add(new Book(102,"Digital Marketing","Anna Cruz",0,"Borrowed"));
        books.add(new Book(103,"Basic Economics","Mark Lee",2,"Available"));

        setTitle("NU LibTrack");
        setSize(1300,800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ================= HEADER =================
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(navy);

        JLabel title = new JLabel("NU LibTrack");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial",Font.BOLD,22));
        title.setBorder(new EmptyBorder(10,20,10,10));

        JButton profile = new JButton("A");
        profile.setPreferredSize(new Dimension(45,45));
        profile.setBackground(new Color(102,153,255));
        profile.setForeground(Color.WHITE);

        profile.addActionListener(e -> showProfile());

        top.add(title,BorderLayout.WEST);
        top.add(profile,BorderLayout.EAST);

        add(top,BorderLayout.NORTH);

        // ================= MAIN =================
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(bg);

        // ===== SEARCH PANEL =====
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));

        searchField = new JTextField();
        JButton searchBtn = new JButton("Search");
        searchBtn.setBackground(yellow);

        JPanel bar = new JPanel(new GridLayout(1,2,10,10));
        bar.add(searchField);
        bar.add(searchBtn);

        searchPanel.add(bar,BorderLayout.NORTH);
        searchPanel.add(new JScrollPane(resultsList),BorderLayout.CENTER);

        searchBtn.addActionListener(e -> performSearch());

        resultsList.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                handleBookClick();
            }
        });

        // ===== RIGHT PANEL (FIXED EQUAL BOXES) =====
        JPanel right = new JPanel(new GridLayout(4,1,15,15));
        right.setBorder(new EmptyBorder(10,10,10,10));

        borrowedPanel = createBox("Borrowed");
        reservePanel = createBox("Reservations");
        historyPanel = createBox("History");
        JPanel fines = createBox("Fines");

        // ===== FINES =====
        fines.setLayout(new FlowLayout(FlowLayout.LEFT));

        feeLabel = new JLabel("₱" + fineAmount);
        JButton pay = new JButton("Pay");
        pay.setBackground(yellow);

        pay.addActionListener(e -> {
            fineAmount = 0;
            feeLabel.setText("₱0");
            JOptionPane.showMessageDialog(this,"Payment successful ✅");
        });

        fines.add(feeLabel);
        fines.add(pay);

        // ADD PANELS (EQUAL SIZE)
        right.add(borrowedPanel);
        right.add(reservePanel);
        right.add(historyPanel);
        right.add(fines);

        main.add(searchPanel,BorderLayout.CENTER);
        main.add(right,BorderLayout.EAST);

        add(main);

        setVisible(true);
    }

    // ✅ CREATE EQUAL BOX
    private JPanel createBox(String title){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(Color.WHITE);

        panel.setPreferredSize(new Dimension(250,150));
        panel.setMinimumSize(new Dimension(250,150));

        return panel;
    }

    // ================= SEARCH =================
    private void performSearch(){
        listModel.clear();

        String key = searchField.getText().toLowerCase();

        for(Book b: books){
            if(b.title.toLowerCase().contains(key)){
                listModel.addElement(
                        "ID:"+b.id+" | "+b.title+
                                " | "+b.author+
                                " | Qty:"+b.quantity+
                                " | "+b.status);
            }
        }
    }

    // ================= CLICK =================
    private void handleBookClick(){

        String selected = resultsList.getSelectedValue();

        for(Book b: books){

            if(selected.contains("ID:"+b.id)){

                if(b.quantity > 0){
                    b.quantity--;
                    borrowedBooks.add(b.title);
                    JOptionPane.showMessageDialog(this,"Borrowed ✅");

                } else {
                    reservedBooks.add(b.title);
                    JOptionPane.showMessageDialog(this,"Reserved ✅");
                }
            }
        }

        refreshBorrowed();
        refreshReserve();
        performSearch();
    }

    // ================= BORROW =================
    private void refreshBorrowed(){

        borrowedPanel.removeAll();

        for(String book: borrowedBooks){

            JPanel row = new JPanel();

            JLabel lbl = new JLabel(book);

            JButton renew = new JButton("Renew");
            JButton ret = new JButton("Return");

            renew.addActionListener(e ->
                    JOptionPane.showMessageDialog(this,
                            book+" renewed for 3 more days ✅"));

            ret.addActionListener(e -> {

                borrowedBooks.remove(book);

                for(Book b: books){
                    if(b.title.equals(book)){
                        b.quantity++;

                        historyList.add(new History(
                                b.title,b.author,
                                LocalDate.now().minusDays(3).toString(),
                                LocalDate.now().toString()
                        ));

                        booksRead++;
                    }
                }

                refreshBorrowed();
                refreshHistory();
                performSearch();
            });

            row.add(lbl);
            row.add(renew);
            row.add(ret);

            borrowedPanel.add(row);
        }

        borrowedPanel.revalidate();
        borrowedPanel.repaint();
    }

    // ================= RESERVE =================
    private void refreshReserve(){

        reservePanel.removeAll();

        for(String book: reservedBooks){

            JPanel row = new JPanel();

            JLabel lbl = new JLabel(book);
            JButton cancel = new JButton("Cancel");

            cancel.addActionListener(e -> {
                reservedBooks.remove(book);
                refreshReserve();
            });

            row.add(lbl);
            row.add(cancel);

            reservePanel.add(row);
        }

        reservePanel.revalidate();
        reservePanel.repaint();
    }

    // ================= HISTORY =================
    private void refreshHistory(){

        historyPanel.removeAll();

        for(History h: historyList){

            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
            card.setBackground(new Color(235,240,255));

            card.add(new JLabel("📘 " + h.title));
            card.add(new JLabel("Author: " + h.author));
            card.add(new JLabel("Borrowed: "+h.borrowedDate+
                    " | Returned: "+h.returnedDate));

            historyPanel.add(card);
        }

        historyPanel.revalidate();
        historyPanel.repaint();
    }

    // ================= PROFILE =================
    private void showProfile(){

        JOptionPane.showMessageDialog(this,
                "Name: Arniel Margaret T.\n"+
                        "Books Read: "+booksRead+
                        "\nRole: Student");
    }

    public static void main(String[] args){
        new PatronDashboardUI();
    }
}