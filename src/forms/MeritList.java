package forms;

import javax.swing.*;
import java.sql.*;

public class MeritList extends JFrame {
  JTextArea jta = new JTextArea();
  JScrollPane sp1 = new JScrollPane(jta);

  public MeritList(String title) {
    super(title);
    setLayout(null);
    sp1.setBounds(3, 3, 350, 650);
    add(sp1);
    sp1.setVisible(true);
    try {
      String s1 = "Amrita Vishwa Vishyapeetham";
      String s2 = "Merit List";
      Database db = new Database();
      Connection con = db.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select * from merit_list order by ano");
      jta.append("\t                        " + s1 + "\n\t                    " + s2 + "\n\n\n");
      while (rs.next()) {
        String x = rs.getString("ca");
        String y = rs.getString("gender");
        if (!x.equals("nil") && y.equals("Male")) {
          jta.append("Application No:" + rs.getString("ano")
              + "\nName:" + rs.getString("cname")
              + "\nG.P.A.:" + rs.getFloat("gpa")
              + "\nCourse Alloted:" + rs.getString("ca") + "\nHostel Block A"
              + "\n\n");
        } else if (!x.equals("nil") && y.equals("Female")) {
          jta.append("Application No:" + rs.getString("ano")
              + "\nName:" + rs.getString("cname")
              + "\nG.P.A.:" + rs.getFloat("gpa")
              + "\nCourse Alloted:" + rs.getString("ca") + "\nHostel Block B"
              + "\n\n");
        } else {
          jta.append("Application No:" + rs.getString("ano")
              + "\nName:" + rs.getString("cname")
              + "\nG.P.A.:" + rs.getFloat("gpa")
              + "\nCourse Alloted:" + rs.getString("ca") + "\n\n");
        }
      }
      jta.setEditable(false);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    MeritList ml = new MeritList("LIST");
    ml.setSize(900, 600);
    ml.setLocation(500, 10);
    ml.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ml.setResizable(false);
    ml.setVisible(true);
  }
}