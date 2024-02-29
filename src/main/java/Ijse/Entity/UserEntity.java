package Ijse.Entity;

import jakarta.persistence.*;

import java.util.List;

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions;

}
