package forms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Instructions extends JFrame {
  JLabel l3, l4, l5, l6, l7, l8, l9, bgLabel;
  Font f;

  public Instructions(String title) {
    super(title);
    f = new Font("Arial", Font.PLAIN, 18);
    l3 = new JLabel("1.All the candidates who have registered themselves are required to fill the admission form.");
    l4 = new JLabel("2.All the fields in the admission form are compulsory.");
    l5 = new JLabel("3.The preferences of streams once filled can't be changed.");
    l6 = new JLabel("4.Only after submitting the application form,the candidate is eligible for admission process.");
    l7 = new JLabel("5.The admission is strictly Based on Merit Score.");
    l8 = new JLabel("6.Candidates are requested to continuously check their accounts for the merit list.");
    l9 = new JLabel(
        "7.After generation of merit list & allotment of seat,the candidate can pay the fee & get fee reciept.");
    Color customBlue = new Color(224, 1, 210);
    l3.setBounds(25, 200, 800, 100);
    l3.setFont(f);
    l3.setForeground(customBlue);
    l4.setBounds(25, 230, 800, 100);
    l4.setFont(f);
    l4.setForeground(customBlue);
    l5.setBounds(25, 260, 800, 100);
    l5.setFont(f);
    l5.setForeground(customBlue);
    l6.setBounds(25, 290, 800, 100);
    l6.setFont(f);
    l6.setForeground(customBlue);
    l7.setBounds(25, 320, 800, 100);
    l7.setFont(f);
    l7.setForeground(customBlue);
    l8.setBounds(25, 350, 800, 100);
    l8.setFont(f);
    l8.setForeground(customBlue);
    l9.setBounds(25, 380, 800, 100);
    l9.setFont(f);
    l9.setForeground(customBlue);

    add(l3);
    add(l4);
    add(l5);
    add(l6);
    add(l7);
    add(l8);
    add(l9);

    bgLabel = new JLabel(new ImageIcon("Stepsbg.png"));
    bgLabel.setBounds(0, 0, 1000, 605);
    add(bgLabel);
  }

  public static void main(String[] args) {
    Instructions obj = new Instructions("Instructions");
    obj.setSize(900, 600);
    obj.setLocation(250, 200);
    obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    obj.setResizable(false);
    obj.setVisible(true);
  }
}