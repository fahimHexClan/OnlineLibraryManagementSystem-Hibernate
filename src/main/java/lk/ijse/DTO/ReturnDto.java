package lk.ijse.DTO;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;

public class ReturnDto {
    private String id;


    private String user;


    private String book;

    private String Date;


    private int quantity;

    public ReturnDto() {
    }

    public ReturnDto(String id, String user, String book, String date, int quantity) {
        this.id = id;
        this.user = user;
        this.book = book;
        Date = date;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ReturnDto{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", book=" + book +
                ", Date='" + Date + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


