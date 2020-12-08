package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Transaction transaction;
    private SessionFactory sessionFactory;
    private Session session;

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE users (" +
                "  id INT NOT NULL AUTO_INCREMENT," +
                "  name VARCHAR(255) NOT NULL," +
                "  lastName VARCHAR(255) NOT NULL," +
                "  age INT NOT NULL," +
                "  PRIMARY KEY (id));").executeUpdate();
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    @Override
    public void dropUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("DROP TABLE users").executeUpdate();
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User user = new User(name, lastName, age);
        session.save(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Override
    public List<User> getAllUsers() {

        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List <User> users = session.createQuery("From User").list();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("delete from users").executeUpdate();
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
