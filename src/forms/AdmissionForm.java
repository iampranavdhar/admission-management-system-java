package forms;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;

public class AdmissionForm extends JFrame implements ActionListener, FocusListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23,
            l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44,
            l45, l46, l0, bgLabel;
    JComboBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22;
    JTextArea jta1, jta2, jta3;
    JRadioButton r1, r2, r3, r4;
    JButton b1;
    ButtonGroup bg;
    private Connection con;
    private PreparedStatement ps, ps1, ps2, ps3, ps4, ps5, ps6, ps7, ps8, ps9;
    private ResultSet rs;
    public static int an = 6901;
    Font f;

    public AdmissionForm(String title) {
        super(title);
        l1 = new JLabel("PROGRAMME SELECTION");
        l0 = new JLabel("Mode");
        l3 = new JLabel("Course Choice");
        l4 = new JLabel("Preference 1");
        l5 = new JLabel("Preference 2");
        l6 = new JLabel("Preference 3");
        l7 = new JLabel("CANDIDATE'S DETAILS");
        l8 = new JLabel("Candidate's Name");
        l10 = new JLabel("Gender");
        l11 = new JLabel("Email");
        l12 = new JLabel("D.O.B (dd/mm/yyyy)");
        l13 = new JLabel("Mobile No.");
        l14 = new JLabel("ADDRESS DETAILS");
        l15 = new JLabel("City");
        l16 = new JLabel("State");
        l17 = new JLabel("Address");
        l18 = new JLabel("Pincode");
        l19 = new JLabel("ACADEMIC DETAILS");
        l20 = new JLabel("12th Details");
        l21 = new JLabel("School Name");
        l22 = new JLabel("School City");
        l23 = new JLabel("School Address");
        l24 = new JLabel("Percentage");
        l25 = new JLabel("Year of Passing");
        l26 = new JLabel("Marks Obtained");
        l27 = new JLabel("Physics");
        l28 = new JLabel("Chemistry");
        l29 = new JLabel("Maths");
        l37 = new JLabel("COMPETITIVE EXAMINATION SCORE");
        l38 = new JLabel("JEE Main Sore");
        l40 = new JLabel("PARENT'S DETAILS");
        l41 = new JLabel("Father's Name");
        l42 = new JLabel("Mobile No.");
        l43 = new JLabel("Mother's Name");
        l44 = new JLabel("Mobile No.");
        l45 = new JLabel("By submitting the application,the applicant certifies and declares that:-");
        l46 = new JLabel(
                "The information provided above is complete,accurate and fulfill the minimum eligibility criteria and applicant agrees to all the terms and conditions of Admission Process.");
        b1 = new JButton("Submit");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
        t12 = new JTextField();
        t17 = new JTextField();
        t19 = new JTextField();
        t20 = new JTextField();
        t21 = new JTextField();
        t22 = new JTextField();
        jta1 = new JTextArea();
        jta2 = new JTextArea();
        r1 = new JRadioButton("Male", false);
        r2 = new JRadioButton("Female", false);
        r3 = new JRadioButton("Hostel", false);
        r4 = new JRadioButton("Day Scholar", false);
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        cb2 = new JComboBox();
        cb2.addItem(" ");
        cb2.addItem("Computer Science and Engineering");
        cb2.addItem("Information Technology");
        cb2.addItem("Electronics and Communication");
        cb2.addItem("Electrical and Electronics");
        cb3 = new JComboBox();
        cb3.addItem(" ");
        cb3.addItem("Computer Science and Engineering");
        cb3.addItem("Information Technology");
        cb3.addItem("Electronics and Communication");
        cb3.addItem("Electrical and Electronics");
        cb4 = new JComboBox();
        cb4.addItem(" ");
        cb4.addItem("Computer Science and Engineering");
        cb4.addItem("Information Technology");
        cb4.addItem("Electronics and Communication");
        cb4.addItem("Electrical and Electronics");

        cb6 = new JComboBox();
        cb6.addItem(" ");
        cb6.addItem("Andaman & Nicobar Islands");
        cb6.addItem("Andhra Pardesh");
        cb6.addItem("Arunachal Pradesh");
        cb6.addItem("Assam");
        cb6.addItem("Bihar");
        cb6.addItem("Chandigarh");
        cb6.addItem("Chhattisgarh");
        cb6.addItem("Dadar & Nagar Haveli");
        cb6.addItem("Daman & Diu");
        cb6.addItem("Delhi");
        cb6.addItem("Goa");
        cb6.addItem("Gujrat");
        cb6.addItem("Haryana");
        cb6.addItem("Himachal Pradesh");
        cb6.addItem("Jammu& Kashmir");
        cb6.addItem("Jharkhand");
        cb6.addItem("Karnataka");
        cb6.addItem("Kerala");
        cb6.addItem("Lakshwadeep");
        cb6.addItem("Madhya Pradesh");
        cb6.addItem("Maharashtra");
        cb6.addItem("Manipur");
        cb6.addItem("Meghalaya");
        cb6.addItem("Mizoram");
        cb6.addItem("Nagaland");
        cb6.addItem("Odisha");
        cb6.addItem("Puducherry");
        cb6.addItem("Punjab");
        cb6.addItem("Rajasthan");
        cb6.addItem("sikkim");
        cb6.addItem("Tamil Nadu");
        cb6.addItem("telangana");
        cb6.addItem("Tripura");
        cb6.addItem("Uttar Pradesh");
        cb6.addItem("Uttarakhand");
        cb6.addItem("West Bengal");
        cb7 = new JComboBox();
        cb7.addItem(" ");
        cb7.addItem("2019");
        cb7.addItem("2020");
        cb7.addItem("2021");

        setLayout(null);
        l0.setBounds(5, 35, 250, 30);
        add(l0);
        r3.setBounds(105, 35, 100, 30);
        add(r3);
        r4.setBounds(215, 35, 120, 30);
        add(r4);
        l1.setBounds(5, 5, 250, 30);
        add(l1);
        l3.setBounds(5, 105, 100, 30);
        add(l3);
        l4.setBounds(105, 75, 100, 30);
        cb2.setBounds(205, 75, 220, 30);
        add(l4);
        add(cb2);
        l5.setBounds(105, 105, 100, 30);
        cb3.setBounds(205, 105, 220, 30);
        add(l5);
        add(cb3);
        l6.setBounds(105, 135, 100, 30);
        cb4.setBounds(205, 135, 220, 30);
        add(l6);
        add(cb4);
        l7.setBounds(5, 205, 250, 30);
        add(l7);
        l8.setBounds(5, 235, 150, 30);
        t1.setBounds(130, 235, 160, 30);
        add(l8);
        add(t1);
        l10.setBounds(5, 275, 100, 30);
        r1.setBounds(130, 275, 80, 30);
        r2.setBounds(215, 275, 80, 30);
        add(l10);
        add(r1);
        add(r2);
        l11.setBounds(5, 315, 100, 30);
        t2.setBounds(130, 315, 300, 30);
        add(l11);
        add(t2);
        l12.setBounds(5, 355, 120, 30);
        t3.setBounds(130, 355, 100, 30);
        add(l12);
        add(t3);
        l13.setBounds(5, 395, 100, 30);
        t4.setBounds(130, 395, 100, 30);
        add(l13);
        add(t4);
        l14.setBounds(5, 435, 250, 30);
        add(l14);
        l15.setBounds(5, 465, 100, 30);
        t5.setBounds(130, 465, 150, 30);
        add(l15);
        add(t5);
        l16.setBounds(5, 505, 100, 30);
        cb6.setBounds(130, 505, 210, 30);
        add(l16);
        add(cb6);
        l17.setBounds(5, 545, 100, 30);
        jta1.setBounds(130, 545, 250, 60);
        add(l17);
        add(jta1);
        l18.setBounds(500, 5, 100, 30);
        t6.setBounds(605, 5, 90, 30);
        add(l18);
        add(t6);
        l19.setBounds(500, 40, 250, 30);
        add(l19);
        l20.setBounds(500, 70, 100, 30);
        add(l20);
        l21.setBounds(500, 110, 100, 30);
        t7.setBounds(605, 110, 150, 30);
        add(l21);
        add(t7);
        l22.setBounds(500, 160, 100, 30);
        t8.setBounds(605, 160, 100, 30);
        add(l22);
        add(t8);
        l23.setBounds(500, 200, 100, 30);
        jta2.setBounds(605, 200, 200, 50);
        add(l23);
        add(jta2);
        l24.setBounds(500, 260, 100, 30);
        t9.setBounds(605, 260, 100, 30);
        add(l24);
        add(t9);
        l25.setBounds(500, 300, 100, 30);
        cb7.setBounds(605, 300, 80, 30);
        add(l25);
        add(cb7);
        l26.setBounds(500, 340, 100, 30);
        add(l26);
        l27.setBounds(500, 370, 100, 30);
        t10.setBounds(605, 370, 60, 30);
        add(l27);
        add(t10);
        l28.setBounds(500, 400, 100, 30);
        t11.setBounds(605, 400, 60, 30);
        add(l28);
        add(t11);
        l29.setBounds(500, 430, 100, 30);
        t12.setBounds(605, 430, 60, 30);
        add(l29);
        add(t12);

        l37.setBounds(850, 0, 350, 30);
        add(l37);
        l38.setBounds(850, 35, 100, 30);
        t17.setBounds(1005, 35, 100, 30);
        add(l38);
        add(t17);
        l40.setBounds(850, 70, 200, 30);
        add(l40);
        l41.setBounds(850, 105, 100, 30);
        t19.setBounds(1005, 105, 200, 30);
        add(l41);
        add(t19);
        l42.setBounds(850, 140, 100, 30);
        t20.setBounds(1005, 140, 100, 30);
        add(l42);
        add(t20);
        l43.setBounds(850, 175, 100, 30);
        t21.setBounds(1005, 175, 200, 30);
        add(l43);
        add(t21);
        l44.setBounds(850, 210, 100, 30);
        t22.setBounds(1005, 210, 100, 30);
        add(l44);
        add(t22);
        l45.setBounds(5, 610, 400, 20);
        add(l45);
        l46.setBounds(5, 630, 1300, 20);
        add(l46);

        f = new Font("Arial", Font.BOLD, 18);
        l1.setFont(f);
        l7.setFont(f);
        l14.setFont(f);
        l19.setFont(f);
        l37.setFont(f);

        Color customGreen = new Color(0, 202, 78);
        b1.setBackground(customGreen);
        b1.setForeground(Color.white);
        b1.setBounds(550, 660, 100, 30);
        add(b1);

        bgLabel = new JLabel(new ImageIcon("admissionFormbg.png"));
        bgLabel.setBounds(0, -5, 1300, 730);
        add(bgLabel);

        b1.addActionListener(this);
    }

    @Override
    public void focusGained(FocusEvent fe) {
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                String cg = " ";
                String dl = "B.Tech";
                String pr1 = cb2.getSelectedItem().toString();
                String pr2 = cb3.getSelectedItem().toString();
                String pr3 = cb4.getSelectedItem().toString();
                String cn = t1.getText();
                String cd = t3.getText();
                if (r1.isSelected())
                    cg = "Male";
                if (r2.isSelected())
                    cg = "Female";
                String cc = "General";
                String cm = t4.getText();
                String ce = t2.getText();
                String ad = jta1.getText();
                String ci = t5.getText();
                String st = cb6.getSelectedItem().toString();
                String pi = t6.getText();
                String sn = t7.getText();
                String sb = t9.getText();
                String sc = t8.getText();
                String sa = jta2.getText();
                String sy = cb7.getSelectedItem().toString();
                int p = Integer.parseInt(t10.getText());
                int c = Integer.parseInt(t11.getText());
                int m = Integer.parseInt(t12.getText());
                float a = (float) ((p + c + m) / 3);
                int jee;

                jee = Integer.parseInt(t17.getText());
                String fn = t19.getText();
                String fm = t20.getText();
                String mn = t21.getText();
                String mm = t22.getText();
                if (t4.getText().matches("^[0-9]*$") && t4.getText().length() == 10 && t20.getText().matches("^[0-9]*$")
                        && t20.getText().length() == 10 && t22.getText().matches("^[0-9]*$")
                        && t22.getText().length() == 10 && t2.getText().matches("[\\w]+@[\\w]+\\.[a-zA-Z]{2,3}") && t3.getText().matches("\\d{2}-\\d{2}-\\d{4}") && t6.getText().length() == 5 && t6.getText().matches("^[0-9]*$")) {
                    Database db = new Database();
                    con = db.connect();
                    ps7 = con.prepareStatement("select nextval('seq');");
                    rs = ps7.executeQuery();
                    rs.next();
                    an = rs.getInt(1);
                    System.out.println(" Value : " + an);
                    ps8 = con.prepareStatement("insert into appno values(?)");
                    ps8.setInt(1, an);
                    ps8.executeUpdate();
                    ps = con.prepareStatement("insert into merit_details values(?,?,?,?,?)");
                    ps.setInt(1, an);
                    ps.setString(2, dl);
                    ps.setString(3, pr1);
                    ps.setString(4, pr2);
                    ps.setString(5, pr3);
                    ps.executeUpdate();
                    ps1 = con.prepareStatement("insert into candidate_details values(?,?,?,?,?,?,?)");
                    ps1.setInt(1, an);
                    ps1.setString(2, cn);
                    ps1.setString(3, cd);
                    ps1.setString(4, cg);
                    ps1.setString(5, cc);
                    ps1.setString(6, cm);
                    ps1.setString(7, ce);
                    ps1.executeUpdate();
                    ps2 = con.prepareStatement("insert into candidate_address values(?,?,?,?,?)");
                    ps2.setInt(1, an);
                    ps2.setString(2, ad);
                    ps2.setString(3, ci);
                    ps2.setString(4, st);
                    ps2.setString(5, pi);
                    ps2.executeUpdate();
                    ps3 = con.prepareStatement("insert into school_details values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    ps3.setInt(1, an);
                    ps3.setString(2, sn);
                    ps3.setString(3, sb);
                    ps3.setString(4, sc);
                    ps3.setString(5, sa);
                    ps3.setString(6, sy);
                    ps3.setInt(7, p);
                    ps3.setInt(8, c);
                    ps3.setInt(9, m);
                    ps3.setFloat(10, a);
                    ps3.setInt(11, jee);
                    ps3.setFloat(12, (float) (jee));
                    ps3.executeUpdate();

                    ps6 = con.prepareStatement("insert into parents_details values(?,?,?,?,?)");
                    ps6.setInt(1, an);
                    ps6.setString(2, fn);
                    ps6.setString(3, fm);
                    ps6.setString(4, mn);
                    ps6.setString(5, mm);
                    ps6.executeUpdate();
                    ps9 = con.prepareStatement("insert into fee values(?,?)");
                    ps9.setInt(1, an);
                    ps9.setString(2, "unpaid");
                    ps9.executeUpdate();
                    JOptionPane.showMessageDialog(null, " THANK YOU.... \n YOUR DETAILS HAVE BEEN SUBMITTED");
                    JOptionPane.showMessageDialog(null, " YOUR APPLICATION NO. :" + an);
                    dispose();
                } else {
                    if(!t2.getText().matches("[\\w]+@[\\w]+\\.[a-zA-Z]{2,3}")){
                        JOptionPane.showMessageDialog(null, " ENTER VALID EMAIL ID");
                    }
                    else if(!t4.getText().matches("^[0-9]*$") || t4.getText().length() != 10 || !t20.getText().matches("^[0-9]*$")
                    || t20.getText().length() != 10 || !t22.getText().matches("^[0-9]*$")
                    || t22.getText().length() != 10){
                        JOptionPane.showMessageDialog(null, " ENTER VALID MOBILE NUMBER");
                    }
                    else if(!t3.getText().matches("\\d{2}-\\d{2}-\\d{4}")){
                        JOptionPane.showMessageDialog(null, " ENTER VALID DOB In DD-MM-YYYY");
                    }
                    else if(!t6.getText().matches("^[0-9]*$") || t6.getText().length() != 10){
                        JOptionPane.showMessageDialog(null, " ENTER VALID PINCODE");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, " ENTER VALID DETAILS");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO FIELDS CAN BE LEFT EMPTY" + e);
            }
        }
    }

    public static void main(String[] args) {
        Color customBlue = new Color(53, 204, 237);

        AdmissionForm adf = new AdmissionForm("Admission Form");
        adf.setSize(1300, 730);
        adf.setLocation(30, 0);
        adf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        adf.setResizable(false);
        adf.setVisible(true);
        adf.getContentPane().setBackground(customBlue);
    }
}