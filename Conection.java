package sample;
import java.sql.*;

public class Conection {
    public static  Connection getConnect(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","mysql");
            Statement stat = conn.createStatement();
            String sql = "select * from workers";
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            int id_col = rs.getInt("ID");
            String first = rs.getString("First_Name");
            String last = rs.getString("Last_Name");
            String job = rs.getString("Job");
            String p = id_col + " " + first + " " + last + " " + job;
            System.out.println(p);

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
