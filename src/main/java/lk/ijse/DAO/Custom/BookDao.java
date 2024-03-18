package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDao;
import lk.ijse.DTO.BookDto;
import lk.ijse.Entity.Book;

import java.sql.SQLException;
import java.util.List;


public interface BookDao extends CrudDao<Book> {
    List<BookDto> getAllBooks() throws SQLException, ClassNotFoundException ;
    BookDto getBookById(String ID) throws Exception;

    List<Book> getAllsBooks();

    int getBookCount();
}
