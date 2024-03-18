package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.BorrowDao;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Borrow;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    @Override
    public boolean save(Borrow entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Borrow entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Borrow> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Borrow> list = session.createNativeQuery("SELECT * FROM Borrow", Borrow.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<String> getIds() {
        return null;
    }

    @Override
    public String generateID() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        String maxId = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT MAX(b.id) FROM Borrow b");
            List<String> result = query.list();
            if (!result.isEmpty()) {
                maxId = result.get(0);
            }
            if (maxId == null) {
                maxId = "BR00-001";
            } else {
                int newBorrowId = Integer.parseInt(maxId.replace("BR00-", "")) + 1;
                maxId = String.format("BR00-%03d", newBorrowId);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            throw new SQLException("Failed to generate borrow ID", e);
        } finally {
            session.close();
        }
        return maxId;
    }
}
