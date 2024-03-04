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
public class LibraryBranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToMany
    @JoinTable(name = "library_branch_book",
            joinColumns = @JoinColumn(name = "library_branch_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<BookEntity> books;

    @OneToMany(mappedBy = "libraryBranch")
    private List<TransactionEntity> transactions;

    @OneToOne(mappedBy = "libraryBranch")
    private AdminEntity admin;

}
