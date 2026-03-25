package com.student.util;

import com.student.config.DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    DBConfig.getUrl(),
                    DBConfig.getUsername(),
                    DBConfig.getPassword()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}