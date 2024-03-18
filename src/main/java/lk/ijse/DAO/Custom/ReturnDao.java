package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDao;
import lk.ijse.DTO.ReturnDto;
import lk.ijse.Entity.Return;

import java.sql.SQLException;

public interface ReturnDao extends CrudDao<Return> {
    String generateID() throws SQLException;
}
