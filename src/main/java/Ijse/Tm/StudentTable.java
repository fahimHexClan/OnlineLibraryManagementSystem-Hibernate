package Ijse.Tm;

import javafx.scene.control.Button;

public class StudentTable {
    private Integer id;
    private String address;
    private String contactNum;
    private String name;
    private Button colDelete;
    private Button colUpdate;

    public StudentTable() {
    }

    public StudentTable(Integer id, String address, String contactNum, String name, Button colDelete, Button colUpdate) {
        this.id = id;
        this.address = address;
        this.contactNum = contactNum;
        this.name = name;
        this.colDelete = colDelete;
        this.colUpdate = colUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getColDelete() {
        return colDelete;
    }

    public void setColDelete(Button colDelete) {
        this.colDelete = colDelete;
    }

    public Button getColUpdate() {
        return colUpdate;
    }

    public void setColUpdate(Button colUpdate) {
        this.colUpdate = colUpdate;
    }

    @Override
    public String toString() {
        return "StudentTable{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", name='" + name + '\'' +
                ", colDelete=" + colDelete +
                ", colUpdate=" + colUpdate +
                '}';
    }
}
