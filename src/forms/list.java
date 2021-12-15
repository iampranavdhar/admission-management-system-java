package forms;
import javax.swing.*;
import java.sql.*;
public class list extends JFrame 
{
    JTextArea jta=new JTextArea();
    JScrollPane sp=new JScrollPane(jta);
    public list(String title)
    {
        super(title);
        setLayout(null);
        sp.setBounds(3, 3, 380, 655);
        add(sp);
        sp.setVisible(true);
        try 
        {
          Database db=new Database();
          Connection con=db.connect();
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select * from candidate_details order by ano");
          Statement st1=con.createStatement();
          ResultSet rs1=st1.executeQuery("select * from merit_details order by ano");
          while(rs.next() && rs1.next())
          {
           jta.append("Application No:"+rs.getString("ano")+"\nName:"+rs.getString("cname")+"\nD.O.B:"+rs.getString("cdob")+"\nGender:"+rs.getString("cgender")+"\nCategory:"+rs.getString("ccat")+"\nMobile:"+rs.getString("cmob")+"\nEmail:"+rs.getString("cemail")+"\n");
           jta.append("Degree Level:"+rs1.getString("dlevel")+"\nPreference 1:"+rs1.getString("p1")+"\nPreference 2:"+rs1.getString("p2")+"\nPreference 3:"+rs1.getString("p3")+"\n\n");
                   
          }
          jta.setEditable(false);
         } catch (Exception e) 
        {
          e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
      list ls=new list("LIST");
      ls.setSize(900,600);
      ls.setLocation(10, 10);
      ls.setDefaultCloseOperation(EXIT_ON_CLOSE);
      ls.setVisible(true);
      ls.setResizable(false);
    }
}
