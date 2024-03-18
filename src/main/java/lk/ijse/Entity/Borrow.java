package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Borrow {
    @Id

    private String id;

    @ManyToOne
    @JoinColumn(name = "user_Name")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private String dueDate;


    private int quantity;

    public Borrow() {
    }

    public Borrow(String id, User user, Book book, String dueDate, int quantity) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dueDate = dueDate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public java.lang.String toString() {
        return "Borrow{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", dueDate=" + dueDate +
                ", quantity=" + quantity +
                '}';
    }
}
