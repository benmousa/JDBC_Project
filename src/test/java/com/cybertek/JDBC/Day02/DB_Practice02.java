package com.cybertek.JDBC.Day02;

import com.cybertek.Utilities.DB_Utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB_Practice02 {
    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet resultSet = DB_Utility.runQuery("SELECT * FROM REGIONS");

        Map<String, String> rowMap = new HashMap<>();

       // rowMap.put("REGION_ID", resultSet.getString(1));
        // rowMap.put("REGION_NAME",  resultSet.getString(2));

        ResultSetMetaData rsmd = resultSet.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++){
          //  System.out.println("rsmd.getColumnName(i) = " + rsmd.getColumnName(i));

            rowMap.put(  rsmd.getColumnName(i),  resultSet.getString(i));
        }

        System.out.println("rowMap = " + rowMap);
    }
}
