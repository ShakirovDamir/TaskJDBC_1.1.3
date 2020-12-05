package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;


public class Util {
    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://" +
            "localhost:" +
            "3306/" +
            "mydbtest?" +
            "serverTimezone=Europe/Moscow&use" +
            "useSSL=false";

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.setProperty(Environment.DRIVER,"com.mysql.jdbc.Driver");
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.URL, url);
        properties.setProperty(Environment.USER, user);
        properties.setProperty(Environment.PASS, password);
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Connection successful!");
        } catch (Exception ex) {
            System.out.println("Connection failed.");
            ex.printStackTrace();
        }
        return connection;
    }
}

