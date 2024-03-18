package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.ReturnDao;
import lk.ijse.DTO.ReturnDto;
import lk.ijse.Entity.Borrow;
import lk.ijse.Entity.Return;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReturnDaoImpl implements ReturnDao {


    @Override
    public boolean save(Return entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Return entity) throws SQLException, ClassNotFoundException {
        return false;
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
    public List<Return> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Return> list = session.createNativeQuery("SELECT * FROM Return", Return.class).list();
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
        return null;
    }
}
