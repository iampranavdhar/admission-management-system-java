package forms;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentLogin extends JFrame implements ActionListener {

  private Connection con;
  private PreparedStatement ps, ps1;
  private ResultSet rs, rs1;
  JButton login, cancel;
  JLabel login_id, password, bgLabel;
  JTextField t1;
  JPasswordField p1;

  public StudentLogin(String title) {
    super(title);
    login = new JButton("Login");
    cancel = new JButton("Cancel");
    login_id = new JLabel("Login Id");
    password = new JLabel("Password");
    t1 = new JTextField();
    p1 = new JPasswordField();
    setLayout(null);
    login_id.setBounds(540, 180, 100, 30);
    password.setBounds(540, 230, 100, 30);
    t1.setBounds(640, 180, 150, 30);
    p1.setBounds(640, 230, 150, 30);
    add(login_id);
    add(password);
    add(t1);
    add(p1);
    login.setBounds(570, 290, 100, 30);
    cancel.setBounds(690, 290, 100, 30);

    Color customRed = new Color(255, 96, 92);
    Color customGreen = new Color(0, 202, 78);
    login.setBackground(customGreen);
    cancel.setBackground(customRed);
    cancel.setForeground(Color.WHITE);
    login.setForeground(Color.WHITE);

    add(login);
    add(cancel);
    login.addActionListener(this);
    cancel.addActionListener(this);

    bgLabel = new JLabel(new ImageIcon("LoginPagebg.png"));
    bgLabel.setBounds(0, 0, 900, 600);
    add(bgLabel);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == cancel) {
      dispose();
    }
    if (ae.getSource() == login) {
      try {
        Database db = new Database();
        con = db.connect();
        if (!(t1.getText()).equals("") && !(p1.getText()).equals("")) {
          ps = con.prepareStatement("select * from log where username=? and passwd=? ");
          ps.setString(1, t1.getText());
          ps.setString(2, p1.getText());
          rs = ps.executeQuery();
          rs.next();
          ps1 = con.prepareStatement("select mob from log where username=?");
          ps1.setString(1, t1.getText());
          rs1 = ps1.executeQuery();
          rs1.next();
          String pno = rs1.getString("mob");
          dispose();
          StudentPortal stp = new StudentPortal("Student Panel", pno);
          stp.setSize(900, 600);
          stp.setLocation(350, 125);
          stp.setVisible(true);
          stp.setResizable(false);
          stp.getContentPane();
        } else {
          JOptionPane.showMessageDialog(null, "Name or Password Cannot be Blank\nLogin Unsuccessful,Try again");
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Sorry No Such Record :  " + e);
      }
    }
  }

  public static void main(String[] args) {
    StudentLogin log = new StudentLogin("Log In");
    log.setSize(900, 600);
    log.setLocation(450, 150);
    log.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    log.setResizable(false);
    log.setVisible(true);
  }
}
