package com.hibernate;

import com.hibernate.entity.Owner;
import org.h2.tools.Server;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Properties;

public class App {
    public static void main(String[] args){

        try {
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            String url = "http://localhost:8082";
            System.out.println("H2 Console started at " + url);
            // Try to open in default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Desktop not supported. Please open manually: " + url);
            }
        } catch (SQLException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        Properties props = new Properties();
        try(InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("h2.properties")){
            props.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }

        Configuration configuration=new Configuration().addAnnotatedClass(Owner.class).setProperties(props);

        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();

        configuration.buildSessionFactory(serviceRegistry);

    }
}