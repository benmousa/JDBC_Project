package com.cybertek.JDBC.Day02;

import com.cybertek.Utilities.DB_Utility;

public class db_pRACTICE02 {
    public static void main(String[] args) {

        DB_Utility.createConnection();
        DB_Utility.runQuery("SELECT * FROM REGIONS");


    }
}
