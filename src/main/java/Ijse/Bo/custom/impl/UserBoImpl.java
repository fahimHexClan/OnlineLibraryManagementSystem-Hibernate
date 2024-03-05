package Ijse.Bo.custom.impl;

import Ijse.Bo.custom.UserBo;
import Ijse.Dao.Impl.UserDaoImpl;
import Ijse.Dao.UserDao;
import Ijse.Dto.UserDto;
import Ijse.Entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {

    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setPassword(userDto.getPassword()); // Remember to hash the password

        return userDao.saveUser(userEntity);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setPassword(userDto.getPassword()); // Remember to hash the password

        return userDao.updateUser(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<UserEntity> userEntityList = userDao.getAllUsers();
        for (UserEntity userEntity : userEntityList) {
            UserDto userDto = new UserDto();
            userDto.setId(userEntity.getId());
            userDto.setName(userEntity.getName());
            userDto.setEmail(userEntity.getEmail());
            userDto.setAddress(userEntity.getAddress());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public boolean checkUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setPassword(userDto.getPassword());
        return userDao.checkUser(userEntity);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserEntity> userEntities = userDao.searchUser(keyword);
        List<UserDto> userDtos = new ArrayList<>();
        for (UserEntity entity : userEntities) {
            userDtos.add(new UserDto(entity.getId(), entity.getName(), entity.getAddress(), entity.getEmail()));
        }
        return userDtos;
    }
    public int getMaxUserId() {
        return userDao.getMaxUserId();
    }

}
