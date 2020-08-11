package com.cybertek.JDBC.Day01;

import java.sql.*;

public class GettingMoreInfoAboutResultSet {
    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";
        Connection con = DriverManager.getConnection (connectionStr, userName, passWord);
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

        //any more info about ResultSet
        ResultSetMetaData rsmd = resultSet.getMetaData();
        //Counting how many columns in our ResultSet object
        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        //find out column name according the index
        String secondColumnName = rsmd.getColumnName(2);
        System.out.println("secondColumnName = " + secondColumnName);

        //how to list all column names from the ResultSet

        for (int i = 1; i <= columnCount; i++){
            //System.out.println(rsmd.getColumnName(i));
            System.out.println("Number "+i+" Column name is: "+ rsmd.getColumnName(i));
        }



    }
}
