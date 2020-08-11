package com.cybertek.Utilities;


import java.sql.*;

public class DB_Utility {

    private static Connection conn ;
    private static ResultSet resultSet;
    private static int columnCount;

    public static void createConnection() {

        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";

        try{
            conn = DriverManager.getConnection (connectionStr, userName, passWord);
            System.out.println("Connection Successful");
        } catch (SQLException e){
            System.out.println("Connection has FAILED");
            e.printStackTrace();
        }
    }


    public static ResultSet runQuery (String Query)  {
        try{
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(Query);
        }catch( SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public static int getColumnCount () {
        try{
            ResultSetMetaData rsmd = resultSet.getMetaData();
            columnCount = rsmd.getColumnCount();
        }catch (SQLException e){
            System.out.println("Error while connecting the columns");
            e.printStackTrace();
        }
        return columnCount;
    }
}
