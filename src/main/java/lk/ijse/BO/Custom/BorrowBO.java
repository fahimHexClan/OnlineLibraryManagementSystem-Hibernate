package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.Entity.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface BorrowBO extends SuperBO {
    boolean addBorrow(BorrowDto borrowDto) throws SQLException, ClassNotFoundException;

    String generateCustomerID() throws SQLException;

    List<BorrowDto> getAllBorrow() throws Exception;
    //   boolean addBorrow(BorrowDto dto) throws Exception;
}
