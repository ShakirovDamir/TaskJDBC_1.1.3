package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://" +
            "localhost:" +
            "3306/" +
            "mydbtest?" +
            "serverTimezone=Europe/Moscow&use" +
            "useSSL=false";

   public Connection databaseConnection() {
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
