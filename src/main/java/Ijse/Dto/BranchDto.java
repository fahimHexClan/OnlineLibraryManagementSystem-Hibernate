package Ijse.Dto;

import Ijse.Entity.BookEntity;
import Ijse.Entity.TransactionEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BranchDto {
    private Long id;
    private String name;
    private String location;
    private List<BookEntity> books;
    private List<TransactionEntity> transactions;

    public BranchDto(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
