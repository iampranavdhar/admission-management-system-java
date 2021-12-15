package forms;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class SeatMatrix extends JFrame implements ActionListener {
  JButton seat_matrix;

  SeatMatrix(String title) {
    super(title);
    seat_matrix = new JButton("B.Tech");
    setLayout(null);
    seat_matrix.setBounds(30, 50, 80, 30);
    seat_matrix.setForeground(Color.blue);
    add(seat_matrix);
    seat_matrix.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getActionCommand() == "B.Tech") {
      SeatMatrixB smb = new SeatMatrixB("B.Tech SeatMatrix");
      smb.setSize(900, 600);
      smb.setLocation(250, 150);
      smb.setVisible(true);
    }
  }

  public static void main(String[] args) {
    SeatMatrix obj = new SeatMatrix("Seat Matrix");
    obj.setSize(900, 600);
    obj.setLocation(250, 150);
    obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    obj.setVisible(true);
  }
}
