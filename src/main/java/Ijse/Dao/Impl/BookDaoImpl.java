package Ijse.Dao.Impl;

import Ijse.Dao.BookDao;
import Ijse.Entity.BookEntity;
import Ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDaoImpl implements BookDao {
    @Override
    public boolean saveUser(BookEntity bookEntity) {

            try (Session session = FactoryConfiguration.getInstance().getSession()) {
                Transaction transaction = session.beginTransaction();
                session.persist(bookEntity);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    }

