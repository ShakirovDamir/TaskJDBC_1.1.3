package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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

    public static SessionFactory getSessionFactory(){
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.setProperty(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.URL, url);
        properties.setProperty(Environment.USER, user);
        properties.setProperty(Environment.PASS, password);
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


//    public Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, user, password);
////            System.out.println("Connection successful!");
//        } catch (Exception ex) {
//            System.out.println("Connection failed.");
//            ex.printStackTrace();
//        }
//        return connection;
//    }
}

