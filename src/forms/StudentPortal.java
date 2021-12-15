package forms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class StudentPortal extends JFrame implements ActionListener {
    JLabel l1,  l3, l7, l8, bgLabel;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String nam;
    String lid;
    private PreparedStatement ps1, ps2, ps3, ps4, ps5, ps6;
    private ResultSet rs1, rs2, rs3, rs4, rs5, rs6, rs7;
    int dd, mm, yy;
    String date;
    int apno;
    Font f;
    Font fbig;

    public StudentPortal(String title, String pno) {
        super(title);
        f = new Font("Arial", Font.BOLD, 20);
        fbig = new Font("Arial", Font.BOLD, 25);
        setLayout(null);
        Calendar cal = new GregorianCalendar();
        dd = cal.get(Calendar.DATE);
        mm = cal.get(Calendar.MONTH) + 1;
        yy = cal.get(Calendar.YEAR);
        date = dd + "/" + mm + "/" + yy;
        b1 = new JButton("Fill Admission Form");
        b2 = new JButton("Change Password");
        b3 = new JButton("Merit List");
        b4 = new JButton("Pay Fee");
        b5 = new JButton("Generate Fee Receipt");
        b6 = new JButton("Instructions");
        b7 = new JButton("Logout");
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        Color customBlue = new Color(99, 60, 204);
        b4.setBackground(customBlue);
        b5.setBackground(customBlue);
        b3.setBackground(customBlue);
        b1.setBackground(customBlue);
        b2.setBackground(customBlue);
        b6.setBackground(customBlue);
        Color customPink = new Color(255, 96, 92);
        b7.setBackground(customPink);
        b7.setForeground(Color.white);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
        b5.setForeground(Color.white);
        b6.setForeground(Color.white);
        try {
            Database db = new Database();
            Connection con = db.connect();
            ps1 = con.prepareStatement("select username from log where mob=?");
            ps1.setString(1, pno);
            rs1 = ps1.executeQuery();
            rs1.next();
            nam = rs1.getString("username");
            ps2 = con.prepareStatement("select username from log where mob=?");
            ps2.setString(1, pno);
            rs2 = ps2.executeQuery();
            rs2.next();
            lid = rs2.getString("username");
            ps5 = con.prepareStatement("select * from candidate_details where cmob=?");
            ps5.setString(1, pno);
            rs5 = ps5.executeQuery();
            if (rs5.next()) {
                b1.setEnabled(false);
                b1.setBackground(Color.white);
                ps3 = con.prepareStatement("select ano from candidate_details where cmob=?");
                ps3.setString(1, pno);
                rs3 = ps3.executeQuery();
                rs3.next();
                apno = rs3.getInt("ano");
                ps4 = con.prepareStatement("select * from merit_details where ano=?");
                ps4.setInt(1, apno);
                rs4 = ps4.executeQuery();
                rs4.next();

            }

            Statement st = con.createStatement();
            rs7 = st.executeQuery("select * from merit_list");
            if (rs7.next()) {
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
            }
            ps6 = con.prepareStatement("select * from fee where ano=?");
            ps6.setInt(1, apno);
            rs6 = ps6.executeQuery();
            rs6.next();
            String status = rs6.getString("status");
            if (status.equals("paid")) {
                b4.setEnabled(false);
                b4.setBackground(Color.white);
            }
        } catch (Exception e) {
        }
        l1 = new JLabel("Welcome");
        l1.setFont(fbig);

        l3 = new JLabel(nam);
        l3.setFont(fbig);

        l7 = new JLabel("Date:");
        l7.setFont(f);
        l8 = new JLabel(date);
        l8.setFont(f);
        l1.setForeground(Color.white);
        l3.setForeground(Color.white);

        l7.setForeground(Color.white);
        l8.setForeground(Color.white);
        l1.setBounds(400, 100, 150, 20);
        l3.setBounds(400, 130, 260, 20);

        add(l1);
        add(l3);
        b1.setBounds(0, 0, 200, 30);
        add(b1);

        l7.setBounds(30, 500, 50, 30);
        l8.setBounds(90, 500, 150, 30);
        add(l7);
        add(l8);
        b2.setBounds(205, 0, 150, 30);
        b3.setBounds(360, 0, 150, 30);
        b4.setBounds(515, 0, 150, 30);
        b5.setBounds(670, 0, 230, 30);
        b6.setBounds(0, 35, 150, 30);
        b7.setBounds(750, 35, 150, 30);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);

        bgLabel = new JLabel(new ImageIcon("StudentPortalbg.png"));
        bgLabel.setBounds(0, -30, 900, 600);
        add(bgLabel);

        b1.setBorderPainted(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            AdmissionLogin adm = new AdmissionLogin("Admission Form");
            adm.setSize(1300, 730);
            adm.setLocation(30, 0);
            adm.setVisible(true);
        }
        if (ae.getSource() == b2) {
            ChangePassword chp = new ChangePassword("Change Password");
            chp.setSize(900, 600);
            chp.setLocation(400, 150);
            chp.setVisible(true);
        }
        if (ae.getSource() == b3) {
            MeritList ml = new MeritList("LIST");
            ml.setSize(900, 600);
            ml.setLocation(500, 10);
            ml.setVisible(true);
        }
        if (ae.getSource() == b4) {
            PayFee pf = new PayFee("PAY FEE", apno);
            pf.setSize(900, 600);
            pf.setLocation(500, 200);
            pf.setVisible(true);

        }
        if (ae.getSource() == b5) {
            FeeReciept fr = new FeeReciept("FEE RECIEPT", apno);
            fr.setSize(900, 600);
            fr.setLocation(250, 200);
            fr.setVisible(true);
        }
        if (ae.getSource() == b6) {
            Instructions ins = new Instructions("INSTRUCTIONS");
            ins.setSize(900, 600);
            ins.setLocation(250, 200);
            ins.setVisible(true);
        }
        if (ae.getSource() == b7) {
            int result = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Confirmation Dialog",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        StudentPortal span = new StudentPortal("Student Panel", "9643171490");
        span.setSize(900, 600);
        span.setResizable(false);
        span.setLocation(550, 225);
        span.setDefaultCloseOperation(EXIT_ON_CLOSE);
        span.setVisible(true);
        span.setResizable(false);
        span.getContentPane().setBackground(Color.white);
    }
}
