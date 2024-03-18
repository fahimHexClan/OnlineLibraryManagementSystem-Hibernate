package lk.ijse.BO.Custom;


import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.BookDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface BookBO extends SuperBO {
    boolean addBook(BookDto dto) throws Exception ;
    boolean UpdateBook(BookDto dto) throws Exception ;


    List<BookDto> getAllBooks() throws Exception;
     BookDto getBooks(String ID) throws Exception;


    boolean deleteBook(String id) throws SQLException, ClassNotFoundException;

    List<String> getBookIds();
    BookDto getBook(String ID) throws Exception;


    Book getBookById(String bookId) throws SQLException, ClassNotFoundException;

    int getBookCount();
}


