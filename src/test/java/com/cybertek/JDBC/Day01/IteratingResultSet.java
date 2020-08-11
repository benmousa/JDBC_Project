package com.cybertek.JDBC.Day01;

import java.sql.*;

public class IteratingResultSet {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";
        Connection con = DriverManager.getConnection (connectionStr, userName, passWord);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");

        while (resultSet.next() == true){
            System.out.println(resultSet.getString("REGION_ID")+" "+ resultSet.getString("REGION_NAME"));
        }
        /*
        resultSet.next();
        System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getString(1)+" "+ resultSet.getString("REGION_NAME"));

        resultSet.next();
        System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2));

       // resultSet.next();
        //System.out.println(resultSet.getString(1)+" "+ resultSet.getString("REGION_NAME"));

        System.out.println(resultSet.next());
        */
    }
}
