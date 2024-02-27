package Ijse.Bo.custom.impl;

import jakarta.transaction.SystemException;
import lk.Ijse.Bo.custom.StudentBo;
import lk.Ijse.Dao.Impl.StudentDaoImpl;
import lk.Ijse.Dao.StudentDao;
import lk.Ijse.Dto.StudentDto;
import lk.Ijse.Entity.StudentEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean saveStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException, SystemException {
        return studentDao.save(new StudentEntity(studentDto.getName(), studentDto.getAddress(), studentDto.getContactNum()));
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.delete(id);
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException, SystemException {
        return studentDao.update(new StudentEntity(studentDto.getId(), studentDto.getName(), studentDto.getAddress(), studentDto.getContactNum()));
    }

    @Override
    public List<StudentDto> searchStudent(String keyword) throws SQLException, ClassNotFoundException, SystemException {
        List<StudentEntity> studentEntities = studentDao.search(keyword);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity entity : studentEntities) {
            studentDtos.add(new StudentDto(entity.getId(), entity.getName(), entity.getAddress(), entity.getContactNum()));
        }
        return studentDtos;
    }
    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentDao.getAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity entity : studentEntities) {
            studentDtos.add(new StudentDto(entity.getId(), entity.getName(), entity.getAddress(), entity.getContactNum()));
        }
        return studentDtos;
    }


}
