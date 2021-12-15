package forms;

import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {
    JLabel bgLabel;
    JButton set_cutoff_btn, generate_merit_list_btn, logout_btn, delete_btn, show_merit_list;
    public Admin(String title) {
        super(title);
        set_cutoff_btn = new JButton("Set Course Cutoff");

        generate_merit_list_btn = new JButton("Generate Merit List");
        logout_btn = new JButton("Logout");
        delete_btn = new JButton("Delete merit list");
        show_merit_list = new JButton("Show Merit List");
        set_cutoff_btn.setBackground(Color.yellow);
        generate_merit_list_btn.setBackground(Color.yellow);
        logout_btn.setBackground(Color.yellow);
        delete_btn.setBackground(Color.yellow);
        show_merit_list.setBackground(Color.yellow);
        setLayout(null);

        set_cutoff_btn.setBounds(5, 5, 180, 30);

        add(set_cutoff_btn);

        generate_merit_list_btn.setBounds(190, 5, 180, 30);
        delete_btn.setBounds(375, 5, 180, 30);
        show_merit_list.setBounds(560, 5, 180, 30);

        Color customRed = new Color(255, 96, 92);

        logout_btn.setBounds(745, 5, 180, 30);
        logout_btn.setBackground(customRed);

        add(generate_merit_list_btn);
        add(logout_btn);
        add(delete_btn);
        add(show_merit_list);

        bgLabel = new JLabel(new ImageIcon("adminbg.png"));
        bgLabel.setBounds(0, 0, 900, 600);
        add(bgLabel);

        set_cutoff_btn.addActionListener(this);

        generate_merit_list_btn.addActionListener(this);
        logout_btn.addActionListener(this);
        delete_btn.addActionListener(this);
        show_merit_list.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == set_cutoff_btn) {
            CutoffGenerator lst = new CutoffGenerator("set btech cutoff");
            lst.setSize(900, 600);
            lst.setLocation(50, 50);
            lst.setVisible(true);
        }

        if (ae.getSource() == generate_merit_list_btn) {
            Calculation cs = new Calculation();
            cs.calculate();
            JOptionPane.showMessageDialog(null, "Merit List has been generated");
        }
        if (ae.getSource() == logout_btn) {
            int result = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Confirmation Dialog",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
        if (ae.getSource() == delete_btn) {
            try {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete merit list?",
                        "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_NO_OPTION) {
                    Database db = new Database();
                    Connection con = db.connect();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("delete from merit_list");
                    JOptionPane.showMessageDialog(null, "merit list deleted");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ae.getSource() == show_merit_list) {
            MeritList ml = new MeritList("LIST");
            ml.setSize(900, 600);
            ml.setLocation(500, 10);
            ml.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Admin ad = new Admin("Admin Panel");
        ad.setSize(900, 600);
        ad.setLocation(300, 10);
        ad.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ad.setVisible(true);
        ad.setResizable(false);
        ad.getContentPane();
    }
}