package Ijse.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    @ManyToMany(mappedBy = "books")
    private List<LibraryBranchEntity> libraryBranches;

    @OneToMany(mappedBy = "book")
    private List<TransactionEntity> transactions;
}
