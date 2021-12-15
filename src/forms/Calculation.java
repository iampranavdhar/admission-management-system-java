package forms;

import java.sql.*;

public class Calculation {
  private Connection con;
  private PreparedStatement ps, ps1, ps2, ps3;
  private ResultSet rs, rs1, rs2;
  public static float cse_cutoff, it_cutoff, ece_cutoff, eee_cutoff;

  public void calculate() {
    try {

      Database db = new Database();
      con = db.connect();
      ps = con.prepareStatement("select * from merit_details order by ano");
      rs = ps.executeQuery();
      ps1 = con.prepareStatement("select * from school_details order by ano");
      rs1 = ps1.executeQuery();
      ps2 = con.prepareStatement("select * from candidate_details order by ano");
      rs2 = ps2.executeQuery();

      ps3 = con.prepareStatement("insert into merit_list values(?,?,?,?,?,?,?,?,?,?,?)");
      while (rs.next() && rs1.next() && rs2.next()) {
        String lev = rs.getString("dlevel");
        int id = rs.getInt("ano");
        String p1 = rs.getString("p1");
        String p2 = rs.getString("p2");
        String p3 = rs.getString("p3");
        int cgpa = rs1.getInt("jee");
        String name = rs2.getString("cname");
        String cat = rs2.getString("ccat");
        String ph = rs2.getString("cmob");
        String gn = rs2.getString("cgender");
        String ca = "nil";
        ps3.setInt(1, id);
        ps3.setString(2, name);
        ps3.setString(3, cat);
        ps3.setString(4, lev);
        ps3.setInt(5, cgpa);
        ps3.setString(6, p1);
        ps3.setString(7, p2);
        ps3.setString(8, p3);
        ps3.setString(9, ca);
        ps3.setString(10, ph);
        ps3.setString(11, gn);
        ps3.executeUpdate();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Database db = new Database();
      con = db.connect();
      ps = con.prepareStatement("select * from merit_list");
      rs = ps.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("ano");
        int gpa = rs.getInt("gpa");
        String p1 = rs.getString("p1");
        String cat = rs.getString("category");
        String level = rs.getString("dlevel");
        if (gpa >= cse_cutoff && cat.equals("General") && p1.equals("Computer Science and Engineering")
            && level.equals("B.Tech")) {
          String ca = "Computer Science and Engineering";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= it_cutoff && cat.equals("General") && p1.equals("Information Technology") && level.equals("B.Tech")) {
          String ca = "Information Technology";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= ece_cutoff && cat.equals("General") && p1.equals("Electronics and Communication")
            && level.equals("B.Tech")) {
          String ca = "Electronics and Communication";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= eee_cutoff && cat.equals("General") && p1.equals("Electrical and Electronics") && level.equals("B.Tech")) {
          String ca = "Electrical and Electronics";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }

      }
    } catch (Exception e)

    {
      e.printStackTrace();
    }
    try {
      Database db = new Database();
      con = db.connect();
      ps = con.prepareStatement("select * from merit_list");
      rs = ps.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("ano");
        float gpa = rs.getFloat("gpa");
        String p2 = rs.getString("p2");
        String cat = rs.getString("category");
        String c = rs.getString("ca");
        String level = rs.getString("dlevel");
        if (gpa >= cse_cutoff && cat.equals("General") && p2.equals("Computer Science and Engineering") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Computer Science and Engineering";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= it_cutoff && cat.equals("General") && p2.equals("Information Technology") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Information Technology";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= ece_cutoff && cat.equals("General") && p2.equals("Electronics and Communication") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Electronics and Communication";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= eee_cutoff && cat.equals("General") && p2.equals("Electrical and Electronics") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Electrical and Electronics";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      Database db = new Database();
      con = db.connect();
      ps = con.prepareStatement("select * from merit_list");
      rs = ps.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("ano");
        float gpa = rs.getFloat("gpa");
        String p3 = rs.getString("p3");
        String cat = rs.getString("category");
        String c = rs.getString("ca");
        String level = rs.getString("dlevel");
        if (gpa >= cse_cutoff && cat.equals("General") && p3.equals("Computer Science and Engineering") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Computer Science and Engineering";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= it_cutoff && cat.equals("General") && p3.equals("Information Technology") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Information Technology";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= ece_cutoff && cat.equals("General") && p3.equals("Electronics and Communication") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Electronics and Communication";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
        if (gpa >= eee_cutoff && cat.equals("General") && p3.equals("Electrical and Electronics") && c.equals("nil")
            && level.equals("B.Tech")) {
          String ca = "Electrical and Electronics";
          ps1 = con.prepareStatement("update merit_list set ca=? where ano=?");
          ps1.setString(1, ca);
          ps1.setInt(2, id);
          ps1.executeUpdate();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Calculation cal = new Calculation();
    cal.calculate();
    System.out.println("done");
  }
}
