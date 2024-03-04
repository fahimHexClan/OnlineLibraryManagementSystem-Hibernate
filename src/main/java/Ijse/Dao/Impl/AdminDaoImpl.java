package Ijse.Dao.Impl;

import Ijse.Dao.AdminDao;
import Ijse.Entity.AdminEntity;
import Ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDaoImpl implements AdminDao {
    public boolean saveAdmin(AdminEntity adminEntity) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(adminEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkAdmin(AdminEntity adminEntity) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            AdminEntity user = session.createQuery("FROM AdminEntity WHERE id = :id AND password = :password", AdminEntity.class)
                    .setParameter("id", adminEntity.getId())
                    .setParameter("password", adminEntity.getPassword())
                    .uniqueResult();
            transaction.commit();
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public int getGeneratedId() {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.createNativeQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'LibraryManagement' AND TABLE_NAME = 'AdminEntity';").getSingleResult();
            transaction.commit();
            return id.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return -1 if there's an error
        }
    }


}