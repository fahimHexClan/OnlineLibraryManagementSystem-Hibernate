package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.DTO.ReturnDto;

import java.sql.SQLException;
import java.util.List;

public interface ReturnBo extends SuperBO {
    boolean addReturn(ReturnDto returnDto) throws SQLException, ClassNotFoundException;

    String generateCustomerID() throws SQLException;

    List<ReturnDto> getAllReturn() throws Exception;
}
