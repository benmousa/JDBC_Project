package com.cybertek.JDBC.Day02;

import com.cybertek.Utilities.DB_Utility;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException  {

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");

        System.out.println( DB_Utility.getColumnDataAtRow(1,4) );
    }
}
