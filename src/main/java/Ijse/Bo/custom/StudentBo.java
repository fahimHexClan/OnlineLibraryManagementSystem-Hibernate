package Ijse.Bo.custom;

import jakarta.transaction.SystemException;
import lk.Ijse.Dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentBo {
    boolean saveStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException, SystemException;

    boolean deleteStudent(int id);

    boolean updateStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException, SystemException;

    List<StudentDto> searchStudent(String keyword) throws SQLException, ClassNotFoundException, SystemException;

    List<StudentDto> getAllStudents();
}
