package Ijse.Dto;

public class AdminDto {
    private int id;
    private String Password;

    public AdminDto() {
    }

    public AdminDto(int id, String password) {
        this.id = id;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "id=" + id +
                ", Password='" + Password + '\'' +
                '}';
    }
}
