package forms;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class PayFee extends JFrame implements ActionListener {
  JLabel l1, l2, l3, l4, l5, bgLabel;
  JTextField t1, t2, t3, t4, t5;
  JButton b1;
  JComboBox cb2;
  int apno;

  public PayFee(String title, int ano) {
    super(title);
    apno = ano;
    setLayout(null);
    l1 = new JLabel("Application Number");
    l3 = new JLabel("Course");
    cb2 = new JComboBox();
    cb2.addItem(" ");
    cb2.addItem("Computer Science and Engineering");
    cb2.addItem("Information Technology");
    cb2.addItem("Electronics and Communication");
    cb2.addItem("Electrical and Electronics");
    l4 = new JLabel("CONTACT NO.");
    l5 = new JLabel("FEES");
    t1 = new JTextField();
    t2 = new JTextField();
    t3 = new JTextField();
    t4 = new JTextField();
    t5 = new JTextField();
    b1 = new JButton("PAY");
    l1.setBounds(10, 210, 100, 30);
    t1.setBounds(120, 210, 150, 30);
    add(l1);
    add(t1);
    l3.setBounds(10, 250, 100, 30);
    add(l3);
    cb2.setBounds(120, 250, 200, 30);
    add(cb2);
    l4.setBounds(10, 290, 100, 30);
    t4.setBounds(120, 290, 150, 30);
    add(l4);
    add(t4);
    l5.setBounds(10, 330, 100, 30);
    t5.setBounds(120, 330, 150, 30);
    add(l5);
    add(t5);
    Color customGreen = new Color(0, 202, 78);
    b1.setBounds(10, 370, 100, 30);
    b1.setBackground(customGreen);
    b1.setForeground(Color.WHITE);
    add(b1);
    b1.addActionListener(this);

    bgLabel = new JLabel(new ImageIcon("payFeebg.png"));
    bgLabel.setBounds(0, 0, 900, 600);
    add(bgLabel);
    try {
      Database db = new Database();
      Connection con = db.connect();
      PreparedStatement ps = con.prepareStatement("select * from merit_list where ano=?");
      ps.setInt(1, ano);
      ResultSet rs = ps.executeQuery();
      rs.next();
      t1.setText(rs.getString("cname"));
      t2.setText("B.Tech");
      t3.setText(rs.getString("ca"));
      t4.setText(rs.getString("conno"));
      String dl = rs.getString("dlevel");
      if (dl.equals("B.Tech")) {
        t5.setText("1,05,000");
      }

      t1.setBackground(Color.white);
      t2.setBackground(Color.white);
      t3.setBackground(Color.white);
      t4.setBackground(Color.white);
      t5.setBackground(Color.white);
      t1.setEditable(false);
      t2.setEditable(false);
      t3.setEditable(false);
      t4.setEditable(false);
      t5.setEditable(false);
    } catch (Exception e) {
      e.getMessage();
      e.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {
      int result = JOptionPane.showConfirmDialog(null, "Confirm PAYMENT ?", "Confirmation Dialog",
          JOptionPane.OK_CANCEL_OPTION);

      if (result == JOptionPane.OK_OPTION) {
        JOptionPane.showMessageDialog(null, "FEE PAID....Now you can generate fee reciept");
        dispose();
        try {
          Database db = new Database();
          Connection con = db.connect();
          PreparedStatement ps1 = con.prepareStatement("update fee set status=? where ano=?");
          ps1.setString(1, "paid");
          ps1.setInt(2, apno);
          ps1.executeUpdate();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    PayFee obj = new PayFee("PAYMENT", 6901);
    obj.setSize(900, 600);
    obj.setLocation(500, 200);
    obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    obj.setVisible(true);
  }
}