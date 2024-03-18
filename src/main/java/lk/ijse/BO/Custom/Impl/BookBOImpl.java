package lk.ijse.BO.Custom.Impl;


import lk.ijse.BO.Custom.BookBO;
import lk.ijse.DAO.Custom.BookDao;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DTO.BookDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BookDao bookDao = (BookDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public boolean addBook(BookDto dto) throws Exception {

        return bookDao.save(new Book(dto.getID(), dto.getAuthour(), dto.getGenre(), dto.getTitle(), dto.getStatus(),null));
    }

    @Override
    public boolean UpdateBook(BookDto dto) throws Exception {
        return bookDao.update(new Book(dto.getID(), dto.getAuthour(), dto.getGenre(), dto.getTitle(), dto.getStatus(),null));

    }

    @Override
    public List<BookDto> getAllBooks() throws Exception {
        List<BookDto> allBooks= new ArrayList<>();
        List<Book> all = bookDao.getAll();
        for (Book c : all) {
            allBooks.add(new BookDto(c.getID(), c.getAuthour(), c.getGenre(),c.getTitle(),c.getStatus(),null));        }
        return allBooks;

    }
    @Override
    public BookDto getBook(String ID) throws Exception {
        // Retrieve a single book by its ID
        return bookDao.getBookById(ID);
    }

    @Override
    public Book getBookById(String bookId) throws SQLException, ClassNotFoundException {

            List<Book> books = bookDao.getAllsBooks();
            for (Book book : books) {
                if (book.getID().equals(bookId)) {
                    return book;
                }
            }
            return null;
        }

    @Override
    public int getBookCount() {
        return bookDao.getBookCount();
    }


    @Override
    public BookDto getBooks(String ID) throws Exception {
        List<BookDto> allBooks = bookDao.getAllBooks();
        for (BookDto book : allBooks) {
            if (book.getID().equals(ID)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean deleteBook(String id) throws SQLException, ClassNotFoundException {
        return bookDao.delete(id);
    }

    @Override
    public List<String> getBookIds() {
        return bookDao.getIds();
    }




}
