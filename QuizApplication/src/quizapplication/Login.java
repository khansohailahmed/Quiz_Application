package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel h1, h2;
    JTextField name;
    JButton close, rules, reg;

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        h1 = new JLabel("Quiz by sk");
        h1.setFont(new Font("Arial", Font.BOLD, 35));
        h1.setBounds(650, 150, 250, 50);
        h1.setForeground(Color.BLUE);
        add(h1);

        h2 = new JLabel("Enter Your Name Here");
        h2.setFont(new Font("Arial", Font.BOLD, 35));
        h2.setBounds(570, 210, 400, 50);
        h2.setForeground(Color.GREEN);
        add(h2);

        name = new JTextField();
        name.setFont(new Font("Arial", Font.BOLD, 35));
        name.setBounds(550, 280, 400, 50);
        name.setForeground(Color.BLACK);
        add(name);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("quizapplication/Icons/Login.jpg"));
        Image i2 = i.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 50, 400, 400);
        add(image);

        close = new JButton("Close");
        close.setBounds(550, 350, 150, 37);
        close.addActionListener(this);
        add(close);

        rules = new JButton("Rules");
        rules.setBounds(850, 350, 150, 38);
        rules.addActionListener(this);
        add(rules);

        reg = new JButton("Register");
        reg.setBounds(705, 420, 150, 38);
        reg.addActionListener(this);
        add(reg);

        setSize(1100, 600);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == rules) {
            String sname = name.getText();
            Conn c = new Conn();
            try {
                String query = "SELECT * FROM login WHERE name='" + sname + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    new Rules(sname);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You need to register first to play the quiz.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == reg) {
            new Registerforquiz();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
