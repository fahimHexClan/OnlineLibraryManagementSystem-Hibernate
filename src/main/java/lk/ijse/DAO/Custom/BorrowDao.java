package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDao;
import lk.ijse.Entity.Borrow;

import java.sql.SQLException;

public interface BorrowDao extends CrudDao<Borrow> {
    String generateID() throws SQLException;
}
