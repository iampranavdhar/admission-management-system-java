package forms;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
public class Fee extends JFrame
{
  JLabel l1,l2,l3,l4,l5,bgLabel;
  JLabel a1,a2,a3,a4;
  JLabel b1,b2,b3,b4;
  JLabel c1,c2,c3,c4;
  JLabel i1,i2,i3,i4,z3,z4,z5;
  Font f1,f2;
  public Fee(String title)
  {
      super(title);
    f1 = new Font("Constania",Font.BOLD,20);
    f2 = new Font("Algerian", Font.BOLD,15);
    
    l1 = new JLabel("Course");
    l1.setFont(f1);
    i1 = new JLabel("Computer Science and Engineering");
    i2 = new JLabel("Information Technology");
    i3 = new JLabel("Electronics and Communication");
    i4 = new JLabel("Electrical and Electronics");


    
    l3 = new JLabel("Academic/Tution Fee");
    l3.setFont(f2);
    z3 = new JLabel("(Per Year)");
    z3.setFont(f2);
    
    a1 = new JLabel("88,500");
    a2 = new JLabel("88,500");
    a3 = new JLabel("88,500");
    a4 = new JLabel("88,500");

    l4 = new JLabel("University Exam Fee");
    l4.setFont(f2);
    z4 = new JLabel("(Per Year)");
    z4.setFont(f2);
    
    b1 = new JLabel("12,000");     
    b2 = new JLabel("12,000");     
    b3 = new JLabel("12,000");     
    b4 = new JLabel("12,000");     
    

    l5 = new JLabel("Total Amount");
    l5.setFont(f2);
    z5 = new JLabel("(Per Year)");
    z5.setFont(f2);
    
    c1 = new JLabel("1,05,000");
    c2 = new JLabel("1,05,000");
    c3 = new JLabel("1,05,000");
    c4 = new JLabel("1,05,000");

    setLayout(null);
    l1.setBounds(50,260,300,30);
    l1.setForeground(Color.blue);
    i1.setBounds(50,300,250,30);
    i2.setBounds(50,340,250,30);
    i3.setBounds(50,380,250,30);
    i4.setBounds(50,420,250,30);

    l3.setBounds(345,260,200,20);
    l3.setForeground(Color.blue);
    z3.setBounds(345,280,200,20);
    z3.setForeground(Color.blue);
    
    a1.setBounds(395,300,100,30);
    a1.setForeground(Color.red);
    a2.setBounds(395,340,100,30);
    a2.setForeground(Color.red);
    a3.setBounds(395,380,100,30);
    a3.setForeground(Color.red);
    a4.setBounds(395,420,100,30);
    a4.setForeground(Color.red);

    l4.setBounds(545,260,200,20);
    l4.setForeground(Color.blue);
    z4.setBounds(545,280,200,20);
    z4.setForeground(Color.blue);
    
    b1.setBounds(595,300,100,30);
    b1.setForeground(Color.red);
    b2.setBounds(595,340,100,30);
    b2.setForeground(Color.red);
    b3.setBounds(595,380,100,30);
    b3.setForeground(Color.red);
    b4.setBounds(595,420,100,30);
    b4.setForeground(Color.red);

    l5.setBounds(745,260,200,20);
    l5.setForeground(Color.blue);
    z5.setBounds(745,280,200,20);
    z5.setForeground(Color.blue);
    
    c1.setBounds(795,300,100,30);
    c1.setForeground(Color.red);
    c2.setBounds(795,340,100,30);
    c2.setForeground(Color.red);
    c3.setBounds(795,380,100,30);
    c3.setForeground(Color.red);
    c4.setBounds(795,420,100,30);
    c4.setForeground(Color.red);

    add(l1);
    add(l3);add(l4);
    add(l5);

    add(i1);
    add(i2);add(i3);
    add(i4);
    add(z3);add(z4);
    add(z5);

    add(a1);add(a2);
    add(a3);add(a4);
    add(b1);add(b2);
    add(b3);add(b4);
    add(c1);add(c2);
    add(c3);add(c4);

    bgLabel = new JLabel(new ImageIcon("feebg.png"));
    bgLabel.setBounds(0, 0, 900, 600);
    add(bgLabel);

  }
     public static void main(String[] args)
    {
      Fee obj=new Fee("Fee Structure");  
        obj.setSize(900,600);
        obj.setLocation(40,100);
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.setResizable(false);
        obj.setVisible(true);
  }        
              
  }