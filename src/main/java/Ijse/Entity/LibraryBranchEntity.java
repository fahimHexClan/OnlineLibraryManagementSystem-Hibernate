package Ijse.Entity;

import jakarta.persistence.*;

import java.util.List;

public class LibraryBranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "libraryBranch", cascade = CascadeType.ALL)
    private List<BookEntity> books;
}
