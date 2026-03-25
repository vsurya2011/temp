package com.student.config;

import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = DBConfig.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            properties.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}