package lk.ijse.BO.Custom.Impl;

import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DAO.Custom.UserDao;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DTO.UserDto;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDao userDao = (UserDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean addUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.save(new User(dto.getName(), dto.getEmail(), dto.getPassword(),null));

    }
    public User getUserByName(String name) throws SQLException, ClassNotFoundException {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<UserDto> getAllUser() throws Exception {
        List<UserDto> alluser= new ArrayList<>();
        List<User> all = userDao.getAll();
        for (User c : all) {
            alluser.add(new UserDto(c.getName(), c.getEmail(), c.getPassword(),null));      }
        return alluser;
    }

    @Override
    public boolean deleteUser(String name) throws SQLException, ClassNotFoundException {
        return userDao.delete(name);
    }

    @Override
    public int getUserCount() {
        return userDao.getUserCount();
    }


}
