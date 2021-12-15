package forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminLogin extends JFrame implements ActionListener {
    JButton admin_login_btn, admin_cancel_btn;
    JLabel admin_username, password, bgLabel;
    JTextField admin_usrname_txtfeild;
    JPasswordField password_txtfeild;
    String ad, pw;

    public AdminLogin(String title) {
        super(title);
        admin_login_btn = new JButton("Login");
        admin_cancel_btn = new JButton("Cancel");
        admin_username = new JLabel("Admin Username");
        password = new JLabel("Password");
        admin_usrname_txtfeild = new JTextField();
        password_txtfeild = new JPasswordField();
        setLayout(null);
        admin_username.setBounds(150, 380, 120, 30);
        password.setBounds(450, 380, 120, 30);
        admin_usrname_txtfeild.setBounds(280, 380, 150, 30);
        password_txtfeild.setBounds(540, 380, 150, 30);
        add(admin_username);
        add(password);
        add(admin_usrname_txtfeild);
        add(password_txtfeild);

        Color customRed = new Color(255, 96, 92);
        Color customGreen = new Color(0, 202, 78);
        admin_login_btn.setBounds(320, 450, 120, 30);
        admin_cancel_btn.setBounds(500, 450, 120, 30);
        admin_login_btn.setBackground(customGreen);
        admin_cancel_btn.setBackground(customRed);
        add(admin_login_btn);
        add(admin_cancel_btn);

        bgLabel = new JLabel(new ImageIcon("adminLoginbg.png"));
        bgLabel.setBounds(0, 0, 900, 600);
        add(bgLabel);

        admin_login_btn.addActionListener(this);
        admin_cancel_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        char[] p = password_txtfeild.getPassword();
        pw = new String(p);
        ad = admin_usrname_txtfeild.getText();
        if (ae.getSource() == admin_cancel_btn) {
            dispose();
        }
        if (ae.getSource() == admin_login_btn) {
            try {
                if (ad.equals("admin") && pw.equals("admin")) {

                    Admin adm = new Admin("Admin Login");
                    dispose();
                    adm.setSize(900, 600);
                    adm.setLocation(350, 125);
                    adm.setVisible(true);
                    adm.getContentPane();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Administrator");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AdminLogin log = new AdminLogin("Admin Log in");
        log.setSize(900, 600);
        log.setLocation(450, 150);
        log.setDefaultCloseOperation(EXIT_ON_CLOSE);
        log.setResizable(false);
        log.setVisible(true);
    }

}
