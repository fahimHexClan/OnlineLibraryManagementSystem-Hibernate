package Ijse.Bo.custom.impl;

import Ijse.Bo.custom.BookBo;
import Ijse.Dao.BookDao;
import Ijse.Dao.Impl.BookDaoImpl;
import Ijse.Dto.BookDto;
import Ijse.Entity.BookEntity;
import Ijse.Entity.UserEntity;

public class BookBoImpl implements BookBo {
    BookDao bookDao=new BookDaoImpl();

    @Override
    public boolean saveUser(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setGenre(bookDto.getGenre());
        bookEntity.setAvailable(bookDto.isAvailable());

        return bookDao.saveUser(bookEntity);    }
}
