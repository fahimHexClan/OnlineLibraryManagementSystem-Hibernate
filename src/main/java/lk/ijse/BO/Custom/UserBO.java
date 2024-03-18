package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.UserDto;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    boolean addUser(UserDto userDto) throws SQLException, ClassNotFoundException;
    User getUserByName(String name) throws SQLException, ClassNotFoundException;

    List<UserDto> getAllUser() throws Exception;

    boolean deleteUser(String name) throws SQLException, ClassNotFoundException;

    int getUserCount();




}
