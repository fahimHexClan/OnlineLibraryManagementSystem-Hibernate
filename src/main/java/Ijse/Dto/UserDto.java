package Ijse.Dto;

import Ijse.Entity.TransactionEntity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserDto {
    private int id;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<TransactionEntity> transactions;

    public UserDto(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
