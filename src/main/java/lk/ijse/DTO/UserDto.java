package lk.ijse.DTO;

import lk.ijse.Entity.Book;

import java.util.List;

public class UserDto {
    String name;
    String email;
    String password;
    List<Book> books;

    public UserDto() {
    }

    public UserDto(String name, String email, String password, List<Book> books) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", books=" + books +
                '}';
    }
}
