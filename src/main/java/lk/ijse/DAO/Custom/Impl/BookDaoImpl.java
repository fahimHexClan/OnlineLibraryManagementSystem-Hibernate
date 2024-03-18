package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.BookDao;

import lk.ijse.DTO.BookDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public boolean save(Book entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Book entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from Book where ID='"+id+"'",Book.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Book> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Book> list = session.createNativeQuery("SELECT * FROM Book", Book.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<String> getIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<String> ids = session.createQuery("SELECT b.id FROM Book b", String.class).list();
        transaction.commit();
        session.close();
        return ids;
    }

    public BookDto getBookById(String ID) throws Exception {
        Transaction transaction = null;
        BookDto bookDto = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Book WHERE ID = :bookId";
            Query query = session.createQuery(hql);
            query.setParameter("bookId", ID);
            Book book = (Book) query.uniqueResult();
            if (book != null) {
                bookDto = new BookDto(book.getID(), book.getAuthour(), book.getGenre(), book.getTitle(), book.getStatus(), null);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookDto;
    }

    @Override
    public List<Book> getAllsBooks() {

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            List<Book> list = session.createNativeQuery("SELECT * FROM Book", Book.class).list();
            transaction.commit();
            session.close();
            return list;
        }

    @Override
    public int getBookCount() {
        Session session = null;
        Transaction transaction = null;
        Long count = 0L;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(ID) FROM Book");
            count = (Long) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return count.intValue();

    }



    public List<BookDto> getAllBooks() throws SQLException, ClassNotFoundException {
        List<BookDto> books = new ArrayList<>();
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "FROM Book";
            Query query = session.createQuery(hql);
            List<Book> bookList = query.list();
            for (Book book : bookList) {
                BookDto bookDto = new BookDto(book.getID(), book.getAuthour(), book.getGenre(), book.getTitle(), book.getStatus(), null);
                books.add(bookDto);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return books;
    }
}