package lk.ijse.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao{
    boolean save(T entity) throws SQLException, ClassNotFoundException ;
    boolean update(T entity) throws SQLException, ClassNotFoundException ;
    boolean exist(String entity) throws SQLException, ClassNotFoundException ;
    boolean delete(String entity) throws SQLException, ClassNotFoundException ;
    List<T> getAll()  throws Exception;
    List<String> getIds();

}
