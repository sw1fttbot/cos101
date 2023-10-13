import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JButton buttonHome = new JButton("home");
    JButton buttonRev = new JButton("reviews");
    JButton buttonBook = new JButton("bookings");
    JButton buttonAbout = new JButton("about");
    JButton buttonCont = new JButton("contact us");
    JButton buttonLog = new JButton("log in");
    JButton buttonSign = new JButton("sign up");
    JButton button = new JButton("BOOK NOW");

    HomePage() {

        frame.setTitle("home page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setSize(1080, 608);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(50, 45));
        panel.setLayout(null);

        buttonHome.setBounds(50, 13, 100, 20);
        buttonHome.setForeground(new Color(100, 100, 100));
        buttonHome.setContentAreaFilled(false);
        buttonHome.setBorderPainted(false);
        buttonHome.setFocusable(false);

        buttonRev.setBounds(150, 13, 100, 20);
        buttonRev.setForeground(new Color(100, 100, 100));
        buttonRev.setContentAreaFilled(false);
        buttonRev.setBorderPainted(false);
        buttonRev.setFocusable(false);

        buttonBook.setBounds(250, 13, 100, 20);
        buttonBook.setForeground(new Color(100, 100, 100));
        buttonBook.setContentAreaFilled(false);
        buttonBook.setBorderPainted(false);
        buttonBook.setFocusable(false);

        buttonAbout.setBounds(350, 13, 100, 20);
        buttonAbout.setForeground(new Color(100, 100, 100));
        buttonAbout.setContentAreaFilled(false);
        buttonAbout.setBorderPainted(false);
        buttonAbout.setFocusable(false);

        buttonCont.setBounds(450, 13, 100, 20);
        buttonCont.setForeground(new Color(100, 100, 100));
        buttonCont.setContentAreaFilled(false);
        buttonCont.setBorderPainted(false);
        buttonCont.setFocusable(false);

        buttonLog.setBounds(800, 13, 100,20);
        buttonLog.setForeground(new Color(100, 100, 100));
        buttonLog.setContentAreaFilled(false);
        buttonLog.setBorderPainted(false);
        buttonLog.setFocusable(false);
        buttonLog.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonLog) {
                    frame.dispose();
                    new Login();
                }
            }
        });

        buttonSign.setBounds(900, 13, 100,20);
        buttonSign.setForeground(new Color(100, 100, 100));
        buttonSign.setContentAreaFilled(false);
        buttonSign.setBorderPainted(true);
        buttonSign.setFocusable(false);
        buttonSign.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonSign) {
                    frame.dispose();
                    new Signup();
                }
            }
        });

        panel.add(buttonHome);
        panel.add(buttonRev);
        panel.add(buttonBook);
        panel.add(buttonAbout);
        panel.add(buttonCont);
        panel.add(buttonLog);
        panel.add(buttonSign);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setPreferredSize(new Dimension(50, 50));
        panel2.setLayout(null);
        button.setBounds(480, 400, 100, 25);
        button.setFocusable(false);

        ImageIcon image = new ImageIcon("C:/Users/milto/OneDrive/Documents/VS Code/Java/Comp_Sci/MassageBookingSystem/stones_therapy_flowers_11078_1920x1200.jpg");
        JLabel ilabel = new JLabel(image);
        ilabel.setSize(1080, 608);
        ilabel.setLayout(new BorderLayout());

        frame.add(button);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(ilabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new HomePage();
    }
}
