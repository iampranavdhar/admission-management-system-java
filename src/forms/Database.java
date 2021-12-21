package forms;

import java.sql.*;

public class Database {
    public static String urld = "jdbc:postgresql://localhost:5432/java_eval";
    public static String user = "postgres";
    public static String pass = "";
    public static Connection con = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(urld, user, pass);
            System.out.println("Connection Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Database db = new Database();
        Connection con = db.connect();
    }
}