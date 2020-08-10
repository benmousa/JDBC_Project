package com.cybertek.JDBC.Day01;

import java.sql.*;

public class Country_Table {
    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";
        Connection con = DriverManager.getConnection (connectionStr, userName, passWord);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1");

        while (resultSet.next() == true){
            System.out.println(resultSet.getString("COUNTRY_ID")+" "+
                               resultSet.getString("COUNTRY_NAME")+" "+
                               resultSet.getString("REGION_ID"));
        }
        System.out.println("THE END ");
    }
}
