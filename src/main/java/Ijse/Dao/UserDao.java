
package Ijse.Dao;

import Ijse.Entity.UserEntity;

import java.util.List;

public interface UserDao {


    boolean saveUser(UserEntity userEntity);

    boolean deleteUser(int id);

    boolean updateUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    boolean checkUser(UserEntity userEntity);

    List<UserEntity> searchUser(String keyword);

    int getMaxUserId();
}

