package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registerforquiz extends JFrame implements ActionListener {

    JTextField userIdField,tfphone;
    JPasswordField passwordField;
    JButton registerButton, loginButton;
    

    public Registerforquiz() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("User Registration for Quiz");
        heading.setBounds(100, 20, 400, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(60, 80, 150, 25);
        userIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(220, 80, 150, 25);
        add(userIdField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(60, 130, 150, 25);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 130, 150, 25);
        add(passwordField);
        
        JLabel phone = new JLabel("Mobile no:");
        phone.setBounds(60, 180, 150, 25);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(phone);
        tfphone = new JTextField();
        tfphone.setBounds(220, 180, 150, 25);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfphone);
        
        registerButton = new JButton("Register");
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBounds(100, 270, 120, 30);
        registerButton.addActionListener(this);
        add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(260, 270, 120, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        setSize(600, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == registerButton) {
            String user = userIdField.getText();
            String pass = new String(passwordField.getPassword());  
            String phone = tfphone.getText();
            try {
                Conn c = new Conn();
                String query = "INSERT INTO login (name, password, phone) VALUES ('" + user + "', '" + pass + "', '" + phone + "');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "User Registered Successfully");
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        } else if (ae.getSource() == loginButton) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Registerforquiz();
    }
}
