package com.cybertek.JDBC.Day02;

import com.cybertek.Utilities.DB_Utility;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException  {

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");




        DB_Utility.runQuery("SELECT * FROM EMPLOYEES");

        System.out.println("DB_Utility.getColumnCount() = " + DB_Utility.getColumnCount());

        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount());



        System.out.println( DB_Utility.getRowDataAsList(4));

        System.out.println("DB_Utility.getColumnDataAsList(4) = " + DB_Utility.getColumnDataAsList("FIRST_NAME"));


    }
}
