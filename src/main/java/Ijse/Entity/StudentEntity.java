package Ijse.Entity;

import jakarta.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String contactNum;
    private String name;


    public StudentEntity() {
    }

    public StudentEntity(String name, String address, String contactNum) {
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
    }

    public StudentEntity(Integer id, String name, String address, String contactNum) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNum='" + contactNum + '\'' +
                '}';
    }
}
