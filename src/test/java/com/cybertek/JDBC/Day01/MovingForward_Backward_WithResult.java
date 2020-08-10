package com.cybertek.JDBC.Day01;

import java.sql.*;

public class MovingForward_Backward_WithResult {
    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";
        Connection con = DriverManager.getConnection (connectionStr, userName, passWord);
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM COUNTRIES");

        System.out.println("THE END ");
    }
}
