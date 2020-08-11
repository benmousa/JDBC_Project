package com.cybertek.JDBC.Day01;

import java.sql.*;

public class DB_Connection {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";

        Connection con = DriverManager.getConnection (connectionStr, userName, passWord);

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");

        resultSet.next();

        System.out.println("first column value using index -->"+ resultSet.getString(1));

        System.out.println("first column value using column name -->"+ resultSet.getString("REGION_ID"));

        System.out.println("second column value using index -->"+ resultSet.getString(2));
        System.out.println("second column value using column name -->"+ resultSet.getString("REGION_NAME"));

        System.out.println("        ---------------------------------------------------------------/n");

        resultSet.next();
        System.out.println("first column value using index -->"+ resultSet.getString(1));

        System.out.println("first column value using column name -->"+ resultSet.getString("REGION_ID"));

        System.out.println("second column value using index -->"+ resultSet.getString(2));
        System.out.println("second column value using column name -->"+ resultSet.getString("REGION_NAME"));



        System.out.println("THE END");
    }
}
