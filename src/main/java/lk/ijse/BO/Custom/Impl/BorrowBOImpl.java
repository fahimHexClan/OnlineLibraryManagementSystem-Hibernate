package lk.ijse.BO.Custom.Impl;

import lk.ijse.BO.Custom.BorrowBO;
import lk.ijse.DAO.Custom.BorrowDao;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DTO.BookDto;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Borrow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowBOImpl implements BorrowBO {
    BorrowDao borrowDao = (BorrowDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BORROW);
    @Override
    public boolean addBorrow(BorrowDto dto) throws SQLException, ClassNotFoundException {
        return borrowDao.save(new Borrow(dto.getId(), dto.getUser(), dto.getBook(), dto.getDueDate(), dto.getQuantity()));
    }

    @Override
    public String generateCustomerID() throws SQLException {
        return borrowDao.generateID();
    }

    @Override
    public List<BorrowDto> getAllBorrow() throws Exception {
        List<BorrowDto> allBorrow= new ArrayList<>();
        List<Borrow> all = borrowDao.getAll();
        for (Borrow c : all) {
            allBorrow.add(new BorrowDto(c.getId(), c.getUser(), c.getBook(),c.getDueDate(),c.getQuantity()));        }
        return allBorrow;
    }


}
