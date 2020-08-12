package com.cybertek.Utilities;


import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class DB_Utility {

    private static Connection conn ;
    private static ResultSet resultSet;
    private static int columnCount;
    private static int rowCount;

    public static void createConnection() {

        String connectionStr = "jdbc:oracle:thin:@100.25.148.1:1521:xe";
        String userName = "hr";
        String passWord = "hr";

        try{
            conn = DriverManager.getConnection (connectionStr, userName, passWord);
            System.out.println("Connection Successful \n");
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

    public static void displayAllData(){

        int columnCount = DB_Utility.getColumnCount();
        try {
            while (resultSet.next() == true ){
                for(int i = 1; i <= columnCount; i++){
                    System.out.print( resultSet.getString( i ) +" \t");
                }
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println("Error while getting all data");
            e.printStackTrace();
        }

    }

    public static String getColumnDataAtRow(int rowNum , int columnIndex){

        String result = "";
        try{
            resultSet.absolute( rowNum);
            result = resultSet.getString(columnIndex);
        } catch (SQLException e){
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }
        return result;
    }

    public static String getColumnDataAtRow(int rowNum , String columnName){

        String result = "";
        try{
            resultSet.absolute( rowNum);
            result = resultSet.getString(columnName);
        } catch (SQLException e){
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getRowDataAsList (int rowNum){

        List<String> rowDataList = new ArrayList<>();

        try{
            resultSet.absolute(rowNum);

            for (int i = 1; i <= getColumnCount(); i++){
                rowDataList.add(resultSet.getString(i));
            }
        }catch (SQLException e){
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }

        return rowDataList;
    }

    public static int getRowCount( ){

        try {
            resultSet.last();
            rowCount = resultSet.getRow();
        } catch (SQLException e){
            System.out.println("Error while getRowCount");
            e.printStackTrace();
        }
        return rowCount;
    }

    public static List<String> getColumnDataAsList(String columnName){

        List<String> columnDataList = new ArrayList<>();
        try{
            resultSet.beforeFirst();

            while ( resultSet.next() ){

                String data = resultSet.getString(columnName);

                columnDataList.add (data);
            }

            resultSet.beforeFirst();

        }catch (SQLException e ){
            System.out.println("Error while getColumnDataAsList");
            e.printStackTrace();
        }
        return columnDataList;
    }

    public static List<String> getColumnDataAsList(int columnIndex){

        List<String> columnDataList = new ArrayList<>();
        try{
            resultSet.beforeFirst();

            while ( resultSet.next() ){

                String data = resultSet.getString(columnIndex);

                columnDataList.add (data);
            }

            resultSet.beforeFirst();

        }catch (SQLException e ){
            System.out.println("Error while getColumnDataAsList");
            e.printStackTrace();
        }
        return columnDataList;
    }

    public static Map<String, String> getRowMap (int rowNum){

        Map< String, String> rowMap = new HashMap<>();

        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            for (int colNum = 1; colNum <= getRowCount(); colNum++){
                String colName = rsmd.getColumnName(colNum);
                String colValue = resultSet.getString(colNum);
                rowMap.put(colName, colValue);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowMap;
    }


}

