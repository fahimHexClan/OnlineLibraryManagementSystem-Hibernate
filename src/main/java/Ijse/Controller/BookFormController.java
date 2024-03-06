package Ijse.Controller;

import Ijse.Bo.custom.BookBo;
import Ijse.Bo.custom.impl.BookBoImpl;
import Ijse.Dto.BookDto;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BookFormController {

    public ComboBox ComboGenre;
    public ComboBox ComboIsAvailable;
    public JFXTextField txtId;
    public JFXTextField txtTitle;
    public JFXTextField txtAuthor;
    public TableView tblView;
    public TableColumn tblId;
    public TableColumn tblTitle;
    public TableColumn tblAuthor;
    public TableColumn tblgenre;
    public TableColumn tblStatus;
    BookBo bookBo=new BookBoImpl();

    public void SaveOnAction(ActionEvent actionEvent) {
        BookDto bookDto = new BookDto();
        bookDto.setId(Long.valueOf(txtId.getText()));
        bookDto.setTitle(txtTitle.getText());
        bookDto.setAuthor(txtAuthor.getText());
        bookDto.setGenre(ComboGenre.getItems().toString());
        bookDto.setAvailable(Boolean.parseBoolean(ComboIsAvailable.getItems().toString()));

        if (bookBo.saveUser(bookDto)) {
            loadAllUsers();
            ClearOnAction();
            showAlert(Alert.AlertType.INFORMATION, "User Added", "User has been added successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to add user.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String error, String s) {

//sanajd
    }

    private void loadAllUsers() {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction() {
    }
}
