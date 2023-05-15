package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private final String driverClassName = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_diwakar";
    private final String username = "freedb_diwakar";
    private final String password = "WwaaJ#GwBt7WUT4";

    Connection connectToDb() throws ClassNotFoundException, SQLException {
        //Load driver class
        Class.forName(driverClassName);
        return DriverManager.getConnection(url,username,password);
    }

}
