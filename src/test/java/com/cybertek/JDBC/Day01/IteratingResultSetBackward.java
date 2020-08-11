package com.cybertek.JDBC.Day01;

import java.sql.*;

public class IteratingResultSetBackward {
    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";
        Connection con = DriverManager.getConnection (connectionStr, userName, passWord);
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");

        resultSet.afterLast();

        while(resultSet.previous() == true){
            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
        }
        System.out.println(".......more moving ......");

        resultSet.absolute(2);
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

        resultSet.first();
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

        resultSet.last();
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

        System.out.println("resultSet.getRow() = " + resultSet.getRow());


    }
}
