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

        resultSet.next();
        System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                resultSet.getString("COUNTRY_NAME"));

        resultSet.next();
        System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                resultSet.getString("COUNTRY_NAME"));

        resultSet.previous();
        System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                resultSet.getString("COUNTRY_NAME"));

        resultSet.first();
        System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                resultSet.getString("COUNTRY_NAME"));

        resultSet.last();
        System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                resultSet.getString("COUNTRY_NAME"));

        resultSet.absolute(5);
        System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                resultSet.getString("COUNTRY_NAME"));

        resultSet.close();
        statement.close();
        con.close();
        System.out.println("THE END ");
    }
}
