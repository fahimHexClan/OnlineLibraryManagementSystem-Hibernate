package lk.ijse.BO.Custom.Impl;

import lk.ijse.BO.Custom.ReturnBo;
import lk.ijse.DAO.Custom.BorrowDao;
import lk.ijse.DAO.Custom.ReturnDao;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.DTO.ReturnDto;
import lk.ijse.Entity.Borrow;
import lk.ijse.Entity.Return;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnBoImpl implements ReturnBo {
    ReturnDao returnDao = (ReturnDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RETURN);

    @Override
    public boolean addReturn(ReturnDto dto) throws SQLException, ClassNotFoundException {
        return returnDao.save(new Return(dto.getId(), dto.getUser(), dto.getBook(), dto.getDate(), dto.getQuantity()));
    }

    @Override
    public String generateCustomerID() throws SQLException {
        return returnDao.generateID();
    }

    @Override
    public List<ReturnDto> getAllReturn() throws Exception {
        List<ReturnDto> allreturn = new ArrayList<>();
        List<Return> all = returnDao.getAll();
        for (Return c : all) {
            allreturn.add(new ReturnDto(c.getId(), c.getUser(), c.getBook(), c.getDate(), c.getQuantity()));
        }
        return allreturn;
    }
}