package Ijse.Dao;

import lk.Ijse.Entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    boolean save(StudentEntity studentEntity);
    boolean delete(Integer id);
    boolean update(StudentEntity studentEntity);
    List<StudentEntity> search(String keyword);

    List<StudentEntity> getAll();
}
