package forms;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class PayFee extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4,l5;
 JTextField t1,t2,t3,t4,t5;
 JButton b1;
 int apno;
    public PayFee(String title,int ano)
    {
       super(title);
       apno=ano;
       setLayout(null);
       l1=new JLabel("NAME");
       l2=new JLabel("DEGREE LEVEL");
       l3=new JLabel("COURSE");
       l4=new JLabel("CONTACT NO.");
       l5=new JLabel("FEES");
       t1=new JTextField();
       t2=new JTextField();
       t3=new JTextField();
       t4=new JTextField();
       t5=new JTextField();
       b1=new JButton("PAY");
       l1.setBounds(10, 20, 100, 30);
       t1.setBounds(120, 20, 150, 30);
       add(l1);add(t1);
       l2.setBounds(10, 60, 100, 30);
       t2.setBounds(120, 60, 150, 30);
       add(l2);add(t2);
       l3.setBounds(10, 100, 100, 30);
       t3.setBounds(120, 100, 150, 30);
       add(l3);add(t3);
       l4.setBounds(10, 140, 100, 30);
       t4.setBounds(120, 140, 150, 30);
       add(l4);add(t4);
       l5.setBounds(10, 180, 100, 30);
       t5.setBounds(120, 180, 150, 30);
       add(l5);add(t5);
       b1.setBounds(100, 220, 100, 30);
       add(b1);
       b1.addActionListener(this);
        try 
        {
         Database db=new Database();
         Connection con=db.connect();
         PreparedStatement ps=con.prepareStatement("select * from merit_list where ano=?");
         ps.setInt(1, ano);
         ResultSet rs=ps.executeQuery();
         rs.next();
         t1.setText(rs.getString("cname"));
         t2.setText(rs.getString("dlevel"));
         t3.setText(rs.getString("ca"));
         t4.setText(rs.getString("conno"));
         String dl=rs.getString("dlevel");
         if(dl.equals("B.Tech"))
         {
             t5.setText("1,06,500");
         }
         else
         if(dl.equals("M.Tech"))
         {
           t5.setText("79000");
         }
         t1.setBackground(Color.white);
         t2.setBackground(Color.white);
         t3.setBackground(Color.white);
         t4.setBackground(Color.white);
         t5.setBackground(Color.white);
         t1.setEditable(false);
         t2.setEditable(false);
         t3.setEditable(false);
         t4.setEditable(false);
         t5.setEditable(false);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==b1)
      {
          int result=JOptionPane.showConfirmDialog(null,"Confirm PAYMENT ?","Confirmation Dialog",JOptionPane.OK_CANCEL_OPTION);
          
          if(result==JOptionPane.OK_OPTION)
          {
           JOptionPane.showMessageDialog(null,"FEE PAID....Now you can generate fee reciept");
           dispose();
              try 
              {
                Database db=new Database();
                Connection con=db.connect();
                PreparedStatement ps1=con.prepareStatement("update fee set status=? where ano=?");
                ps1.setString(1,"paid");
                ps1.setInt(2,apno);
                ps1.executeUpdate();
              } catch (Exception e) 
              {
                  e.printStackTrace();
              }
          }
      }
    }
    
  public static void main(String[] args)
    {
     PayFee obj=new PayFee("PAYMENT",6901);  
        obj.setSize(900,600);
        obj.setLocation(500,200);
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.setVisible(true);
    }

}
