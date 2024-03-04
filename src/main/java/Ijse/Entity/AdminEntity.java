package Ijse.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    @OneToOne
    @JoinColumn(name = "library_branch_id")
    private LibraryBranchEntity libraryBranch;
}
