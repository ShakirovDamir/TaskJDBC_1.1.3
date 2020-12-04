package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
        userDao.saveUser("Damir", "Shakirov", (byte) 28);
        userDao.saveUser("Igor", "Nikiforov", (byte) 49);
        userDao.saveUser("Michael", "Zelenkov", (byte) 50);
        userDao.saveUser("Andrew", "Volik", (byte) 47);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

//         private static UserService userService = new UserServiceImpl();
//         userService.createUsersTable();
//        userService.saveUser("Damir", "Shakirov", (byte) 28);
//        userService.saveUser("Igor", "Nikiforov", (byte) 49);
//        userService.saveUser("Michael", "Zelenkov", (byte) 50);
//        userService.saveUser("Andrew", "Volik", (byte) 47);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

    }
}













