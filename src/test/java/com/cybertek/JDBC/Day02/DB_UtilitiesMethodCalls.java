package com.cybertek.JDBC.Day02;

import com.cybertek.Utilities.DB_Utility;

public class DB_UtilitiesMethodCalls {
    public static void main(String[] args) {

        DB_Utility.createConnection();
        DB_Utility.runQuery("SELECT * FROM JOBS");

       // DB_Utility.displayAllData();

    //    System.out.println("getColumnCount() = " + DB_Utility.getColumnCount());
    //    System.out.println("getRowCount() = " + DB_Utility.getRowCount());

    //    System.out.println("DB_Utility.getRowDataAsList(3) = " + DB_Utility.getRowDataAsList(3));

    //    System.out.println("DB_Utility.getColumnDataAsList(2) = " + DB_Utility.getColumnDataAsList(2));

    //    System.out.println("DB_Utility.getColumnDataAsList(\"JOB_TITLE\") = \n" + DB_Utility.getColumnDataAsList("JOB_TITLE"));

    //    System.out.println("DB_Utility.getColumnDataAtRow(3, 2) = \n" + DB_Utility.getColumnDataAtRow(3, 2));

        System.out.println("DB_Utility.getColumnDataAtRow(3, \"JOB_TITLE\") = \n " + DB_Utility.getColumnDataAtRow(3, "JOB_TITLE"));


    }
}
