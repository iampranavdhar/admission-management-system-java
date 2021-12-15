package forms;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {
    JLabel name, password, mobile_no, bgLabel;
    JTextField t1, t2;
    JPasswordField p1;
    JButton submit_btn, cancel_btn;
    private Connection con;
    private PreparedStatement ps;

    public Register(String title) {
        super(title);
        name = new JLabel("Name");
        password = new JLabel("Password");
        mobile_no = new JLabel("Mobile");
        submit_btn = new JButton("Submit");
        cancel_btn = new JButton("Cancel");
        t1 = new JTextField();
        t2 = new JTextField();
        p1 = new JPasswordField();
        setLayout(null);
        name.setBounds(530, 150, 100, 30);
        t1.setBounds(650, 150, 150, 30);
        add(name);
        add(t1);
        password.setBounds(530, 180, 100, 30);
        bgLabel = new JLabel(new ImageIcon("RegisterPagebg.png"));
        bgLabel.setBounds(-45, 0, 1000, 605);
        p1.setBounds(650, 180, 150, 30);
        mobile_no.setBounds(530, 210, 100, 30);
        t2.setBounds(650, 210, 150, 30);
        add(password);
        add(p1);
        add(mobile_no);
        add(t2);
        submit_btn.setBounds(570, 290, 100, 30);
        cancel_btn.setBounds(690, 290, 100, 30);
        Color customRed = new Color(255, 96, 92);
        Color customGreen = new Color(0, 202, 78);
        submit_btn.setBackground(customGreen);
        cancel_btn.setBackground(customRed);
        cancel_btn.setForeground(Color.WHITE);
        submit_btn.setForeground(Color.WHITE);
        submit_btn.addActionListener(this);
        cancel_btn.addActionListener(this);
        add(submit_btn);
        add(cancel_btn);
        add(bgLabel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel_btn) {
            dispose();
        }
        if (ae.getSource() == submit_btn) {
            String s1 = t1.getText(), s2 = t2.getText();
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            try {
                Database db = new Database();
                con = db.connect();
                ps = con.prepareStatement("insert into log values(?,?,?)");
                if (!(p1.getText()).equals("") && !(t2.getText()).equals("") && !s1.equals("")) {
                    ps.setString(1, s1);
                    ps.setString(2, p1.getText());
                    ps.setString(3, t2.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,
                            "Registration Successful,Use your Username and password to login");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Name or Password Cannot be Blank\nRegistration Unsuccessful,Try again");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong :  " + e);
            }
        }
    }

    public static void main(String[] args) {
        Register reg = new Register("Registration");
        reg.setSize(900, 600);
        reg.setLocation(420, 240);
        reg.setDefaultCloseOperation(EXIT_ON_CLOSE);
        reg.setVisible(true);
        reg.setResizable(false);
    }
}
