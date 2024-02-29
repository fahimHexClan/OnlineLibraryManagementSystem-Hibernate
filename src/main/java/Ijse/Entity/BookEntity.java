package Ijse.Entity;

import jakarta.persistence.*;

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "library_branch_id")
    private LibraryBranchEntity libraryBranch;
}
