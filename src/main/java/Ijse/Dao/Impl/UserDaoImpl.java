
package Ijse.Dao.Impl;

import Ijse.Dao.UserDao;
import Ijse.Entity.UserEntity;
import Ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public boolean saveUser(UserEntity userEntity) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(userEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, id);
            if (userEntity != null) {
                session.delete(userEntity);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(userEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM UserEntity", UserEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean checkUser(UserEntity userEntity) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            UserEntity user = session.createQuery("FROM UserEntity WHERE id = :id AND password = :password", UserEntity.class)
                    .setParameter("id", userEntity.getId())
                    .setParameter("password", userEntity.getPassword())
                    .uniqueResult();
            transaction.commit();
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<UserEntity> searchUser(String keyword) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Query<UserEntity> query = session.createQuery("FROM UserEntity WHERE id = :id OR name LIKE :name OR address LIKE :address OR email LIKE :email");
            query.setParameter("id", Integer.parseInt(keyword));
            query.setParameter("address", "%" + keyword + "%");
            query.setParameter("name", "%" + keyword + "%");
            query.setParameter("email", "%" + keyword + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public int getMaxUserId() {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("SELECT COALESCE(MAX(u.id), 0) FROM UserEntity u", Integer.class).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }}



