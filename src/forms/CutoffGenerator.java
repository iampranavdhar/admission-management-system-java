package forms;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class CutoffGenerator extends JFrame implements ActionListener {
  JLabel l1, l2, l3, l4, l5, bgLabel;
  JTextField t1, t2, t3, t4, t5;
  JButton b1;
  Font f;

  public CutoffGenerator(String title) {
    super(title);
    f = new Font("Arial", Font.BOLD, 16);
    l1 = new JLabel("C.S.E");
    l2 = new JLabel("I.T");
    l3 = new JLabel("E.C.E");
    l4 = new JLabel("E.E.E");

    t1 = new JTextField();
    t2 = new JTextField();
    t3 = new JTextField();
    t4 = new JTextField();

    b1 = new JButton("Set Cutoff");
    setLayout(null);

    l1.setBounds(30, 140, 500, 100);
    t1.setBounds(70,180, 100, 25);

    add(l1);
    add(t1);

    l2.setBounds(180, 140, 500, 100);
    t2.setBounds(220, 180, 100, 25);

    add(l2);
    add(t2);

    l3.setBounds(30, 180, 500, 100);
    t3.setBounds(70, 220, 100, 25);

    add(l3);
    add(t3);

    l4.setBounds(180, 180, 500, 100);
    t4.setBounds(220, 220, 100, 25);

    add(l4);
    add(t4);

    b1.setBounds(30, 340, 110, 30);
    Color customGreen = new Color(0, 202, 78);
    b1.setBackground(customGreen);
    b1.setForeground(Color.WHITE);
    add(b1);
    b1.addActionListener(this);

    bgLabel = new JLabel(new ImageIcon("cutoffbg.png"));
    bgLabel.setBounds(0, 0, 900, 600);
    add(bgLabel);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {
      Calculation cs = new Calculation();
      cs.cse_cutoff = Float.parseFloat(t1.getText());
      cs.it_cutoff = Float.parseFloat(t2.getText());
      cs.ece_cutoff = Float.parseFloat(t3.getText());
      cs.eee_cutoff = Float.parseFloat(t4.getText());

      JOptionPane.showMessageDialog(null, "the cutoff has been set");
      dispose();
    }
  }

  public static void main(String[] args) {
    CutoffGenerator b = new CutoffGenerator("BTech Cutoff Update");
    b.setSize(900, 600);
    b.setLocation(50, 50);
    b.setDefaultCloseOperation(EXIT_ON_CLOSE);
    b.setResizable(false);
    b.setVisible(true);
  }
}