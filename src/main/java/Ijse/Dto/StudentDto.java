package Ijse.Dto;

public class StudentDto {

    private int Id;
    private String Address;
    private String ContactNum;
    private String name;


    public StudentDto(int id, String name, String address, String contactNum) {
        Id = id;
        this.name = name;
        Address = address;
        ContactNum = contactNum;
    }
    public StudentDto(String name, String address, String contactNum) {
        this.name = name;
        Address = address;
        ContactNum = contactNum;
    }


    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNum() {
        return ContactNum;
    }

    public void setContactNum(String contactNum) {
        ContactNum = contactNum;
    }
}