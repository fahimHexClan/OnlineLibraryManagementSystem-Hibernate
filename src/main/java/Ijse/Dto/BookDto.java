package Ijse.Dto;

import Ijse.Entity.LibraryBranchEntity;
import Ijse.Entity.TransactionEntity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;
    private List<LibraryBranchEntity> libraryBranches;
    private List<TransactionEntity> transactions;

    public BookDto(Long id, String title, String author, String genre, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }
}
