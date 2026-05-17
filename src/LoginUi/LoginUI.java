package LoginUi;

import javax.swing.*;
import java.awt.*;
import Services.authServ;
import Services.dB;
import LibTrackModel.modelU;
import DashBoards.LibrarianDashboardUI;
import DashBoards.PatronDashboardUI;

public class LoginUI extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;

    public LoginUI() {
        setTitle("NU LibTrack - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Select applicant type:"));
        roleBox = new JComboBox<>(new String[]{"Librarian", "Patron"});
        panel.add(roleBox);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> login());
        panel.add(loginBtn);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.addActionListener(e -> signup());
        panel.add(signupBtn);

        add(panel);
        setVisible(true);
    }

    private void login() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleBox.getSelectedItem();

        for (modelU user : dB.users) {
            if (user.getEmail().equals(email) && user.login(password)) {
                JOptionPane.showMessageDialog(this, "Welcome " + role + "!");
                if (role.equals("Librarian")) {
                    new LibrarianDashboardUI().setVisible(true);
                } else {
                    new PatronDashboardUI().setVisible(true);
                }
                dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Invalid login.");
    }

    private void signup() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleBox.getSelectedItem();

        boolean success = authServ.register(email, password, role);
        JOptionPane.showMessageDialog(this,
            success ? "Registration successful!" : "Registration failed.");
    }
}
