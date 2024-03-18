package lk.ijse.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    String name;
    String email;
    String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Borrow> borrows = new HashSet<>();



    public User() {
    }

    public User(String name, String email, String password, Set<Borrow> borrows) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.borrows = borrows;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.lang.String getEmail() {
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

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", borrows=" + borrows +
                '}';
    }
}
