package forms;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeeReciept extends JFrame implements ActionListener,Runnable{
    JTextArea jta1;
    JButton b1,b2;
    Font f;
    private Connection con;
    private PreparedStatement ps,ps1;
    private ResultSet rs,rs1;
    String tf,name,status;
    String bb,dl;
    String ef,course;
    String t,conno;
    public FeeReciept(String title,int ano)  {
        super(title);
        try{
            Database db=new Database();
            con=db.connect();
            ps=con.prepareStatement("select * from merit_list where ano=?");
            ps.setInt(1, ano);
            rs=ps.executeQuery();
            rs.next();
            name=rs.getString("cname");
            dl=rs.getString("dlevel");
            course=rs.getString("ca");
            conno=rs.getString("conno");
            if(dl.equals("B.Tech")){
                tf="88500";
                bb="12000";
                ef="1000";
                t="106500";        
            }else if(dl.equals("M.Tech")){
                tf="63000";
                bb="10000";
                ef="1000";
                t ="79000";
            }      
            ps1=con.prepareStatement("select * from fee where ano=?");
            ps1.setInt(1, ano);
            rs1=ps1.executeQuery();
            rs1.next();
            status=rs1.getString("status");
        }catch (Exception e){
            e.printStackTrace();
        }
        b1=new JButton("Save");
        b2=new JButton("Print");
        f=new Font("Arial",Font.BOLD,16);
        setLayout(null);
        String s1="\n" +"\t\t\t Amrita University"+"\n";
        String s2= "\t\t                       FEE RECIEPT"+"\n";
        String s3="\t1. Name                     : "+name+"\t9. Fee Status :  "+status+"\n";
        String s4="\t2. Degree Level       : "+dl+"\n";
        String s5="\t3. Course                  : "+course+"\n";
        String s6="\t4. Contact No.          : "+conno+"\n";
        String s7="\t5. Academic Fee      : "+tf+"\n";
        String s8="\t6. University Fee     : "+bb+"\n";
        String s9="\t7. Student Act. Fee : "+ef+"\n";
        String s10="\t8. Total                       : "+t+"\n";
        jta1=new JTextArea();
        jta1.append(s1+"\n");
        jta1.append(s2+"\n");
        jta1.append(s3+"\n");
        jta1.append(s4+"\n");
        jta1.append(s5+"\n");
        jta1.append(s6+"\n");
        jta1.append(s7+"\n");
        jta1.append(s8+"\n");
        jta1.append(s9+"\n");
        jta1.append(s10+"\n");
        b1.setBounds(250,420,80,30);
        b2.setBounds(350,420,80,30);
        add(b1);add(b2);
        add(jta1);
        jta1.setBounds(10, 10, 720, 400);
        jta1.setEditable(false);
        jta1.setFont(f);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            JOptionPane optionPane = new JOptionPane("Printer Not Available", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            try {
                Thread.sleep(1);
                dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(FeeReciept.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource()==b1){
            JOptionPane.showMessageDialog(null,"Saved");
            try {
                Thread.sleep(1);
                dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(FeeReciept.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args){
        FeeReciept obj=new FeeReciept("Fee Reciept",6901);  
        obj.setSize(900,600);
        obj.setLocation(250,200);
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.setResizable(false);
        obj.setVisible(true);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

