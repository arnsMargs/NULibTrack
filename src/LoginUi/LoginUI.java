package LoginUi;

import javax.swing.*;
import java.awt.*;
import Services.authServ;

public class LoginUI extends JFrame  {
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
       String role = (String) roleBox.getSelectedItem();


       // For now, just show a message
       JOptionPane.showMessageDialog(this,
           "Login attempt: " + email + " as " + role);
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
