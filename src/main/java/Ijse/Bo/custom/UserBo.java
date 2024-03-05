package Ijse.Bo.custom;

import Ijse.Dto.UserDto;

import java.util.List;

public interface UserBo {

    boolean saveUser(UserDto userDto);

    boolean deleteUser(int id);

    boolean updateUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    boolean checkUser(UserDto userDto);

    List<UserDto> searchUser(String keyword);

    int getMaxUserId();
}
