
package forms;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;

public class steps extends JFrame {
  Font f;
  JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, bgLabel;
  JTextArea jta = new JTextArea();

  public steps(String title) {
    super(title);

    f = new Font("Arial", Font.PLAIN, 18);
    l3 = new JLabel("Step 1: Register Yourself And Create Your Account.");
    l4 = new JLabel("Step 2: Log in To Your Account.");
    l5 = new JLabel("Step 3: Submit Admission Form.");
    l6 = new JLabel("Step 4: Wait For The Merit List.");
    l7 = new JLabel("Step 5: After The Allotment Of Seat, Pay Fees And Generate Fee Reciept.");

    Color customBlue = new Color(224, 1, 210);

    l3.setBounds(25, 200, 700, 100);
    l3.setFont(f);
    l3.setForeground(customBlue);
    l4.setBounds(25, 230, 700, 100);
    l4.setFont(f);
    l4.setForeground(customBlue);
    l5.setBounds(25, 260, 700, 100);
    l5.setFont(f);
    l5.setForeground(customBlue);
    l6.setBounds(25, 290, 700, 100);
    l6.setFont(f);
    l6.setForeground(customBlue);
    l7.setBounds(25, 320, 700, 100);
    l7.setFont(f);
    l7.setForeground(customBlue);

    add(l3);
    add(l4);
    add(l5);
    add(l6);
    add(l7);

    bgLabel = new JLabel(new ImageIcon("Stepsbg.png"));
    bgLabel.setBounds(0, 0, 1000, 605);
    add(bgLabel);
  }

  public static void main(String[] args) {
    steps s = new steps("STEPS TO FOLLOW");
    s.setSize(900, 600);
    s.setLocation(400, 200);
    s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    s.setResizable(false);
    s.setVisible(true);
  }
}