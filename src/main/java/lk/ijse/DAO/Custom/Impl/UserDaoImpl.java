package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;

import lk.ijse.DAO.Custom.UserDao;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String name) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from User where name='"+name+"'", User.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM User", User.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<String> getIds() {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM User", User.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public int getUserCount() {
        Session session = null;
        Transaction transaction = null;
        Long count = 0L;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(name) FROM User");
            count = (Long) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return count.intValue();
    }
    public int countByUsernameAndPassword(String username, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<User> query = session.createQuery("SELECT COUNT(u) FROM User u WHERE u.name = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getResultList().size();
    }
}
