import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JFrame frame = new JFrame();

    JLabel lbUser, lbPassword, text, logMessage;

    static JTextField tfUser;

    static JPasswordField jpPassword;

    JButton btnLogin, btnSignup;

    Login() {

        lbUser = new JLabel("email:");
        lbUser.setFont(new Font("Jumble", Font.BOLD, 15));

        lbPassword = new JLabel("password:");
        lbPassword.setFont(new Font("Jumble", Font.BOLD, 15));

        text = new JLabel("Don't have an account yet?");
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        text.setHorizontalAlignment(JLabel.CENTER);

        logMessage = new JLabel("");

        tfUser = new JTextField();

        jpPassword = new JPasswordField();

        btnLogin = new JButton("Log in");
        btnLogin.setFocusable(false);
        btnLogin.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfUser.getText();
                String password = new String(jpPassword.getPassword());

                try {
                    String[] data = new String[5];
                    Scanner scan = new Scanner(new File("C:\\Users\\milto\\OneDrive\\Documents\\VS Code\\Java\\Comp_Sci\\MassageBookingSystem\\src\\database.txt"));

                    while (scan.hasNextLine()) {

                        String info = scan.nextLine();
                        data = info.split(", ");

                        int i = 0;
                        Customer client = new Customer(data[i], data[i + 1], data[i + 2], Integer.parseInt((data[i + 3])), data[i + 4]);

                        if (e.getSource() == btnLogin) {

                            if ((user.length() == 0) || (password.length() == 0)) {

                                logMessage.setText("Please enter username and password");

                            } else if (user.equals(client.getEmail()) && password.equals(client.getPassword())) {

                                frame.dispose();
                                new HomePage();
                            } else {

                                logMessage.setText("Invalid username or password!");
                            }
                        }
                    }

                scan.close();
                } catch (FileNotFoundException exc) {
                    System.out.println("File not found!");
                }
            }    
        });

        btnSignup = new JButton("create new account");
        btnSignup.setContentAreaFilled(false);
        btnSignup.setBorderPainted(false);
        btnSignup.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
        btnSignup.setHorizontalAlignment(JLabel.CENTER);
        btnSignup.setFocusable(false);
        btnSignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSignup) {
                    frame.dispose();
                    new Signup();
                }
            }
        });

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 1, 5, 10));
        formPanel.add(lbUser);
        formPanel.add(tfUser);
        formPanel.add(lbPassword);
        formPanel.add(jpPassword);
        formPanel.add(logMessage);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 5, 6));
        buttonPanel.add(btnLogin);
        buttonPanel.add(text);
        buttonPanel.add(btnSignup);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.setTitle("Log in");
        frame.setSize(548,608);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[] args) throws IOException {
        new Login();
    }
}
