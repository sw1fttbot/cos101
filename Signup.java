import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

    JFrame frame = new JFrame();

    JLabel lbPassword, lbPassword2, text;

    JLabel fName, lName, eMail, pNumber, logMessage;

    JTextField jfName, jlName, jeMail, jpNumber;

    JPasswordField jpPassword, jpPassword2;

    JButton btnSignup, btnLog;

    Signup() {

        fName = new JLabel("first name:");
        fName.setFont(new Font("Jumble", Font.BOLD, 15));

        lName = new JLabel("last name:");
        lName.setFont(new Font("Jumble", Font.BOLD, 15));

        eMail = new JLabel("email:");
        eMail.setFont(new Font("Jumble", Font.BOLD, 15));

        pNumber = new JLabel("phone number:");
        pNumber.setFont(new Font("Jumble", Font.BOLD, 15));

        lbPassword = new JLabel("create new password:");
        lbPassword.setFont(new Font("Jumble", Font.BOLD, 15));

        lbPassword2 = new JLabel("confirm password:");
        lbPassword2.setFont(new Font("Jumble", Font.BOLD, 15));

        logMessage = new JLabel("");

        jfName = new JTextField();
        jlName = new JTextField();
        jeMail = new JTextField();
        jpNumber = new JTextField();
        jpPassword = new JPasswordField();
        jpPassword2 = new JPasswordField();

        text = new JLabel("Already have an account?");
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        text.setHorizontalAlignment(JLabel.CENTER);

        btnSignup = new JButton("Sign up");
        btnSignup.setFocusable(false);
        btnSignup.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        btnSignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String password = new String(jpPassword.getPassword());
                String confirm = new String(jpPassword2.getPassword());

                String email = jeMail.getText();
                String regex = "^(.+)@(.+)$";
                    
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);

                try {
                    FileWriter f = new FileWriter("C:\\Users\\milto\\OneDrive\\Documents\\VS Code\\Java\\Comp_Sci\\MassageBookingSystem\\src\\database.txt", true);
                    BufferedWriter b = new BufferedWriter(f);
                    PrintWriter writer = new PrintWriter(b);

                    if (e.getSource() == btnSignup) {

                        if ((jfName.getText().length() <= 0) || (jlName.getText().length() <= 0) || (jeMail.getText().length() <= 0) || (jpNumber.getText().length() <= 0) || (password.length() <= 0) || (confirm.length() <= 0)) {

                            logMessage.setText("Please fill in all the details.");

                        } else if (String.valueOf(matcher.matches()) == "false") {

                            logMessage.setText("Invalid email address!");

                        } else if (jpNumber.getText().length() != 10) {

                                logMessage.setText("The number you have entered is invalid!");

                        } else if (password.equals(confirm)) {

                                writer.print(jfName.getText());
                                writer.print(", ");
                                writer.print(jlName.getText());
                                writer.print(", ");
                                writer.print(jeMail.getText());
                                writer.print(", ");
                                writer.print(jpNumber.getText());
                                writer.print(", ");
                                writer.print(password);
                                writer.print("\n");

                                frame.dispose();
                                new HomePage();
  
                        } else {

                            logMessage.setText("password does not match!");

                        }
                    }

                    writer.close();
                } catch (Exception exc) {
                    System.out.println(exc);
                }
            }
        });

        btnLog = new JButton("log in");
        btnLog.setContentAreaFilled(false);
        btnLog.setBorderPainted(false);
        btnLog.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
        btnLog.setHorizontalAlignment(JLabel.CENTER);
        btnLog.setFocusable(false);
        btnLog.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnLog) {
                    frame.dispose();
                    new Login();
                }
            }
        });

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(13, 1, 5, 10));
        formPanel.add(fName);
        formPanel.add(jfName);
        formPanel.add(lName);
        formPanel.add(jlName);
        formPanel.add(eMail);
        formPanel.add(jeMail);
        formPanel.add(pNumber);
        formPanel.add(jpNumber);
        formPanel.add(lbPassword);
        formPanel.add(jpPassword);
        formPanel.add(lbPassword2);
        formPanel.add(jpPassword2);
        formPanel.add(logMessage);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 5, 6));
        buttonPanel.add(btnSignup);
        buttonPanel.add(text);
        buttonPanel.add(btnLog);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.setTitle("Sign up");
        frame.setSize(548,608);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) throws Exception {
        new Signup();
    }
}
