package sample;

import java.sql.*;

public class Conection {
    public static Connection getConnect(){
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String pass = "mysql";

        try {
            Connection conn = DriverManager.getConnection(url,user,pass);
            return conn;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void signupUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + ","+Const.USERS_LASTNAME + "," +
                Const.USERS_LOGIN +"," + Const.USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?)";


        try {
            PreparedStatement prSt = getConnect().prepareStatement(insert);
            prSt.setString(1,user.getFirstname());
            prSt.setString(2,user.getLastname());
            prSt.setString(3,user.getLogin());
            prSt.setString(4,user.getPassword());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getConnect().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resSet;
    }
}
