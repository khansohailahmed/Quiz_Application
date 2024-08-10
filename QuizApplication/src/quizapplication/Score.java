package quizapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("quizapplication/Icons/score.jpg"));
        Image i2 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 50, 300, 400);
        add(image);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        // Save score to database
        try {
            Conn c = new Conn();
            String query = "INSERT INTO score(name, score) VALUES('" + name + "', " + score + ")";
            c.s.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login(); 
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
