package com.cybertek.JDBC.Day02;

import com.cybertek.Utilities.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException  {

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");

        while ( rs.next() == true){
            System.out.println(rs.getString(1));
        }


        System.out.println("DB_Utility.getColumnCount() = " + DB_Utility.getColumnCount());


        rs.first();
        for(int i = 1; i <= DB_Utility.getColumnCount(); i++){
            System.out.print(rs.getString(i) +" \t");
        }


    }
}
