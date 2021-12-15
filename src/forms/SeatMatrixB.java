package forms;

import java.awt.Color;
import javax.swing.*;

public class SeatMatrixB extends JFrame {
  JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;

  SeatMatrixB(String title) {
    super(title);
    l1 = new JLabel("Bachelor Of Technology");
    l2 = new JLabel("Computer Science");
    l3 = new JLabel("Information Technology");
    l4 = new JLabel("Electronics and Communication");
    l5 = new JLabel("Electrical and Electronics");
    l7 = new JLabel("Total");
    l8 = new JLabel("40");
    l9 = new JLabel("40");
    l10 = new JLabel("40");
    l11 = new JLabel("12");
    setLayout(null);
    l1.setBounds(5, 10, 300, 30);
    l2.setBounds(5, 50, 200, 30);
    l2.setForeground(Color.blue);
    l3.setBounds(5, 90, 200, 30);
    l3.setForeground(Color.blue);
    l4.setBounds(5, 130, 200, 30);
    l4.setForeground(Color.blue);
    l5.setBounds(5, 170, 200, 30);
    l5.setForeground(Color.blue);
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    l7.setBounds(260, 10, 100, 30);
    l8.setBounds(260, 50, 100, 30);
    l8.setForeground(Color.red);
    l9.setBounds(260, 90, 100, 30);
    l9.setForeground(Color.red);
    l10.setBounds(260, 130, 100, 30);
    l10.setForeground(Color.red);
    l11.setBounds(260, 170, 100, 30);
    l11.setForeground(Color.red);
    add(l7);
    add(l8);
    add(l9);
    add(l10);
    add(l11);
  }

  public static void main(String[] args) {
    SeatMatrixB obj = new SeatMatrixB("Seat Matrix BTech");
    obj.setSize(725, 250);
    obj.setLocation(250, 150);
    obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    obj.setVisible(true);
  }
}