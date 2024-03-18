package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.CrudDao;
import lk.ijse.DAO.Custom.BranchDao;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Borrow;
import lk.ijse.Entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
    @Override
    public boolean save(Branch entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Branch entity) throws SQLException, ClassNotFoundException {
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
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from Branch where BranchId='"+id+"'", Branch.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Branch> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Branch> list = session.createNativeQuery("SELECT * FROM Branch", Branch.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<String> getIds() {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<String> ids = session.createQuery("SELECT b.BranchId FROM Branch b", String.class).list();
        transaction.commit();
        session.close();
        return ids;
    }
}
