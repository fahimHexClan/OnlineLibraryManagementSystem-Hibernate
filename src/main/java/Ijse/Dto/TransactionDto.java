package Ijse.Dto;

import Ijse.Entity.BookEntity;
import Ijse.Entity.UserEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDto {
    private Long id;
    private String type; // Borrowing or returning
    private String timestamp;
    private UserEntity user;
    private BookEntity book;
}
