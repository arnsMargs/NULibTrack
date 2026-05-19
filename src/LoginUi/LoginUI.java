package LoginUi;

import javax.swing.*;
import java.awt.*;
import Services.*;
import LibTrackModel.modelU;
import DashBoards.LibrarianDashboards.LibrarianDashboardUI;
import DashBoards.PatronDashbaoards.PatronDashboardUI;

public class LoginUI extends JFrame {

    JTextField email = new JTextField();
    JPasswordField pass = new JPasswordField();

    public LoginUI() {

        Color b = new Color(0,51,102),
              y = new Color(255,204,0),
              bg = new Color(245,245,245);

        setTitle("NU LibTrack");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);

        JPanel m = new JPanel(new BorderLayout());
        m.setBackground(bg);

        JPanel top = new JPanel();
        top.setBackground(b);
        top.setLayout(new BoxLayout(top,1));

        for(String s : new String[]{
                "NU LibTrack",
                "National University Library Tracking"}) {

            JLabel l = new JLabel(s,0);
            l.setForeground(Color.WHITE);
            l.setAlignmentX(.5f);
            l.setFont(new Font("Arial",1,
                    s.equals("NU LibTrack") ? 48 : 18));
            top.add(l);
        }

        JPanel line = new JPanel();
        line.setBackground(y);
        line.setMaximumSize(new Dimension(800,3));

        top.add(Box.createVerticalStrut(25),0);
        top.add(Box.createVerticalStrut(15));
        top.add(line);

        JPanel f = new JPanel(new GridLayout(5,1,0,12));
        f.setBackground(bg);
        f.setPreferredSize(new Dimension(380,220));

        JComboBox<String> role =
                new JComboBox<>(new String[]{"Librarian","Patron"});

        email.setBorder(BorderFactory.createTitledBorder("Email"));
        pass.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton log = new JButton("Login"),
                sign = new JButton("Sign Up");

        log.setBackground(b);
        log.setForeground(Color.WHITE);
        sign.setBackground(y);

        JPanel btn = new JPanel(new GridLayout(1,2,10,0));
        btn.setBackground(bg);
        btn.add(log);
        btn.add(sign);

        JLabel forgot = new JLabel("Forgot Password?",0);
        forgot.setForeground(b);

        for(Component c : new Component[]{role,email,pass,btn,forgot})
            f.add(c);

        JPanel c = new JPanel();
        c.setBackground(bg);
        c.add(f);

        JPanel bot = new JPanel(new BorderLayout());
        bot.setBackground(b);
        bot.setPreferredSize(new Dimension(800,50));

        JLabel logo = new JLabel("   NU LibTrack");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial",1,24));
        bot.add(logo);

        log.addActionListener(e -> {

            for(modelU u : dB.users)

                if(u.getEmail().equals(email.getText())
                && u.login(new String(pass.getPassword()))) {

                JOptionPane.showMessageDialog(this,"Welcome!");

                (u.getRole().equals("Librarian")
                   ? new LibrarianDashboardUI()
                   : new PatronDashboardUI())
                   
                   .setVisible(true);

                    dispose();
                    return;
                }

            JOptionPane.showMessageDialog(this,"Invalid Login");
        });

        sign.addActionListener(e ->
         JOptionPane.showMessageDialog(this,

         authServ.register(
         email.getText(),
         new String(pass.getPassword()),
        (String)role.getSelectedItem())

        ? "Registration Successful!"
        : "Registration Failed"));

        m.add(top,"North");
        m.add(c);
        m.add(bot,"South");

        add(m);
        setVisible(true);
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(LoginUI::new);
    }
}