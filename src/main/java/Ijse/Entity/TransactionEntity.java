package Ijse.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
