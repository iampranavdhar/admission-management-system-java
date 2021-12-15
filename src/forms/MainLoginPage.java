package forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class MainLoginPage extends JFrame implements ActionListener, MouseListener {

    JMenuBar mb;
    JMenu fee_structure_btn, seat_btn;
    JMenuItem exit_btn, instructions_btn, admin_home_btn, space_btn;
    JLabel bgLabel;
    Font f, f1, f2;
    JButton student_login_btn, student_register_btn;

    public MainLoginPage() {

        bgLabel = new JLabel(new ImageIcon("homePagebg.png"));

        mb = new JMenuBar();
        admin_home_btn = new JMenu("Admin Login");
        fee_structure_btn = new JMenu("Fee Structure");
        seat_btn = new JMenu("Seat Matrix");
        instructions_btn = new JMenu("Instructions");
        space_btn = new JMenu(
                "                                                                                                                ");
        exit_btn = new JMenu("Exit");

        student_login_btn = new JButton("Log in");
        student_register_btn = new JButton("Register");
        mb.add(admin_home_btn);
        mb.add(fee_structure_btn);
        mb.add(seat_btn);
        mb.add(instructions_btn);
        mb.add(space_btn);
        mb.add(exit_btn);

        f = new Font("Constantia", Font.BOLD, 45);
        f1 = new Font("Arial", Font.BOLD, 14);
        f2 = new Font("Algerian", Font.BOLD, 20);

        setLayout(null);
        bgLabel.setBounds(0, 50, 900, 600);

        student_login_btn.setBounds(350, 280, 100, 40);
        student_register_btn.setBounds(470, 280, 100, 40);
        Color customColor = new Color(175, 12, 62);
        student_login_btn.setBackground(customColor);
        student_register_btn.setBackground(customColor);
        student_login_btn.setForeground(Color.white);
        student_register_btn.setForeground(Color.white);
        add(student_login_btn);
        add(student_register_btn);

        mb.setBounds(0, 0, 1000, 50);
        mb.setBackground(Color.white);
        mb.setForeground(Color.black);
        exit_btn.setForeground(Color.red);
        add(bgLabel);
        add(mb);

        student_login_btn.addActionListener(this);
        student_register_btn.addActionListener(this);

        fee_structure_btn.addMouseListener(this);
        seat_btn.addMouseListener(this);
        exit_btn.addMouseListener(this);
        instructions_btn.addMouseListener(this);
        admin_home_btn.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == student_register_btn) {
            Register reg = new Register("Registration");
            reg.setSize(900, 600);
            reg.setLocation(550, 225);
            reg.setVisible(true);
        }
        if (ae.getSource() == student_login_btn) {
            StudentLogin log = new StudentLogin("Log_In");
            log.setSize(900, 600);
            log.setLocation(550, 225);
            log.setResizable(false);
            log.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == fee_structure_btn) {
            Fee obj = new Fee("Fee Structure");
            obj.setSize(900, 600);
            obj.setLocation(350, 100);
            obj.setVisible(true);
        }
        if (me.getSource() == seat_btn) {
            SeatMatrixB smb = new SeatMatrixB("SeatMatrix");
            smb.setSize(900, 600);
            smb.setLocation(250, 150);
            smb.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == exit_btn)
            System.exit(0);
        if (me.getSource() == instructions_btn) {
            steps s = new steps("Instructions To Follow");
            s.setSize(900, 600);
            s.setLocation(400, 200);
            s.setVisible(true);
        }
        if (me.getSource() == admin_home_btn) {
            AdminLogin logi = new AdminLogin("Admin Panel");
            logi.setSize(900, 600);
            logi.setLocation(550, 225);
            logi.setVisible(true);
            logi.setDefaultCloseOperation(EXIT_ON_CLOSE);
            logi.setResizable(false);
            logi.getContentPane().setBackground(Color.white);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        MainLoginPage obj = new MainLoginPage();
        obj.getContentPane().setBackground(Color.black);
        obj.setSize(900, 600);
        obj.setLocation(550, 225);
        obj.setTitle("Amrita University, Amritapuri Admission Portal");
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.setResizable(false);
        obj.setVisible(true);
    }
}