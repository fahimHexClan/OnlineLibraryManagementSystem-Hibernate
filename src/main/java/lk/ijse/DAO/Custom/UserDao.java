package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDao;
import lk.ijse.Entity.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {
    List<User> getAllUsers();

    int getUserCount();
}
