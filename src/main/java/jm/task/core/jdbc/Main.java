package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();
        userService.saveUser("Damir", "Shakirov", (byte) 28);
        userService.saveUser("Igor", "Nikiforov", (byte) 49);
        userService.saveUser("Michael", "Zelenkov", (byte) 50);
        userService.saveUser("Andrew", "Volik", (byte) 47);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}













