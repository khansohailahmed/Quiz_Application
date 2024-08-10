package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    JLabel h1, h2;
    JButton back, start;
    String name;

    
    public Rules(String name) {
        this.name = name; 
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);

        h1 = new JLabel("Welcome " + name + " to Quiz by sk");
        h1.setFont(new Font("Whisper", Font.BOLD, 35));
        h1.setBounds(60, 50, 1000, 35);
        h1.setForeground(Color.CYAN);
        add(h1);

        h2 = new JLabel();
        h2.setBounds(60, 100, 1000, 300);
        h2.setForeground(Color.CYAN);
        h2.setText(
                "<html>" +
                        "1. Time Limit: Players have 30 seconds to answer each quiz question. This adds urgency and excitement to the game.<br><br>" +
                        "2. Scoring: Points are awarded based on correct answers. Incorrect answers may result in point deductions or no points awarded.<br><br>" +
                        "3. Lifelines: Players may have lifelines such as \"50/50\" (removing two incorrect answers) or \"Ask the Audience\" (polling the audience for their answer).<br><br>" +
                        "4. Round Format: The game may consist of multiple rounds, each with a set number of questions. Points or difficulty can increase with each round.<br><br>" +
                        "5. Fair Play: Players must refrain from using external help or devices during the game. Cheating may result in disqualification or point penalties." +
                        "</html>"
        );
        add(h2);

        back = new JButton("Back");
        back.setBounds(250, 450, 150, 37);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(450, 450, 150, 38);
        start.addActionListener(this);
        add(start);

        setSize(1100, 600);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            new Login().setVisible(true);
            dispose();
        } else if (ae.getSource() == start) {
            new QuizzStart(name);
        }
    }

    public static void main(String[] args) {
        
        new Rules("User");
    }
}
