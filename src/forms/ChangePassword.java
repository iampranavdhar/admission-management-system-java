package forms;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Color;

public class ChangePassword extends JFrame implements ActionListener {
  private Connection con;
  private PreparedStatement ps, ps1;
  JLabel old_password, new_password, usrname, bgLabel;
  JPasswordField p1, p2;
  JButton submit_btn, cancel_btn;
  JTextField t1;

  public ChangePassword(String title) {
    super(title);
    old_password = new JLabel("Old Password");
    new_password = new JLabel("New Password");
    usrname = new JLabel("Username");
    t1 = new JTextField();
    p1 = new JPasswordField();
    p2 = new JPasswordField();
    submit_btn = new JButton("Submit");
    cancel_btn = new JButton("Cancel");
    setLayout(null);
    usrname.setBounds(500, 140, 120, 30);
    old_password.setBounds(500, 180, 120, 30);
    new_password.setBounds(500, 220, 120, 30);
    t1.setBounds(620, 140, 150, 30);
    p1.setBounds(620, 180, 150, 30);
    p2.setBounds(620, 220, 150, 30);
    submit_btn.setBounds(640, 280, 100, 30);
    cancel_btn.setBounds(530, 280, 100, 30);

    Color customRed = new Color(255, 96, 92);
    Color customGreen = new Color(0, 202, 78);

    submit_btn.setBackground(customGreen);
    cancel_btn.setBackground(customRed);
    submit_btn.setForeground(Color.WHITE);
    cancel_btn.setForeground(Color.WHITE);

    add(old_password);
    add(new_password);
    add(p1);
    add(p2);
    add(submit_btn);
    add(cancel_btn);
    add(usrname);
    add(t1);

    bgLabel = new JLabel(new ImageIcon("changePassbg.png"));
    bgLabel.setBounds(0, -30, 900, 600);
    add(bgLabel);

    submit_btn.addActionListener(this);
    cancel_btn.addActionListener(this);
  }

  boolean result;

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == cancel_btn) {
      dispose();
    }
    if (ae.getSource() == submit_btn) {
      try {

        Database db = new Database();
        con = db.connect();

        ps = con.prepareStatement("select * from log where username=? and passwd=?");
        ps.setString(1, t1.getText());
        ps.setString(2, p1.getText());
        ResultSet rs = ps.executeQuery();
        rs.next();
        String s = rs.getString("username");
        String s1 = rs.getString("passwd");
        ps1 = con.prepareStatement("update log set passwd=? where username=? and passwd=?");
        ps1.setString(1, p2.getText());
        ps1.setString(2, s);
        ps1.setString(3, s1);
        ps1.executeUpdate();
        JOptionPane.showMessageDialog(null, "password changed");
        t1.setText("");
        p1.setText("");
        p2.setText("");
        dispose();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No Such Record Found " + e);
      }
    }
  }

  public static void main(String[] args) {
    ChangePassword obj = new ChangePassword("Change Password");
    obj.setSize(900, 600);
    obj.setLocation(450, 150);
    obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    obj.setResizable(false);
    obj.setVisible(true);
  }

}
