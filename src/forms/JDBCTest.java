package forms;

import java.sql.*;

public class JDBCTest {

    public static String urld = "jdbc:oracle:thin:@localhost:1521:admin";
    public static String user = "sys as sysdba";
    public static String pass = "root";
    public static Connection con = null;

    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection(urld, user, pass);
            System.out.println("Connection Successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        JDBCTest jp = new JDBCTest();
        jp.connect();
    }
}