
package Ijse.Controller;

import Ijse.Bo.custom.UserBo;
import Ijse.Bo.custom.impl.UserBoImpl;
import Ijse.Dto.UserDto;
import com.jfoenix.controls.JFXTextField;
import jakarta.transaction.SystemException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class UserFormCotroller {

    @FXML
    private TableView<UserDto> UserTable;

    @FXML
    private TableColumn<?, ?> tblAddress;

    @FXML
    private TableColumn<?, ?> tblEmail;

    @FXML
    private TableColumn<?, ?> tblId;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;
    UserBo userBo = new UserBoImpl();
    @FXML
    private void initialize() {
        // Initialize the columns in the table
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Load all users into the table
        loadAllUsers();
    }



    @FXML
    void AddOnAction(ActionEvent event) {
        UserDto userDto = new UserDto();
        userDto.setId(Integer.parseInt(txtId.getText()));
        userDto.setName(txtName.getText());
        userDto.setEmail(txtEmail.getText());
        userDto.setAddress(txtAddress.getText());

        if (userBo.saveUser(userDto)) {
            loadAllUsers();
            ClearAllOnAction();
            showAlert(Alert.AlertType.INFORMATION, "User Added", "User has been added successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to add user.");
        }
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {
        UserDto selectedUser = UserTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            if (userBo.deleteUser(selectedUser.getId())) {
                loadAllUsers();
                showAlert(Alert.AlertType.INFORMATION, "User Deleted", "User has been deleted successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete user.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No User Selected", "Please select a user to delete.");
        }
    }

    @FXML
    void UpdateOnAction(ActionEvent event) {
        UserDto userDto = new UserDto();
        userDto.setId(Integer.parseInt(txtId.getText()));
        userDto.setName(txtName.getText());
        userDto.setEmail(txtEmail.getText());
        userDto.setAddress(txtAddress.getText());

        if (userBo.updateUser(userDto)) {
            loadAllUsers();
            ClearAllOnAction();
            showAlert(Alert.AlertType.INFORMATION, "User Updated", "User has been updated successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to update user.");
        }
    }

    @FXML
    void SearchOnAction(ActionEvent event) {
        String keyword = txtId.getText();
        List<UserDto> userDtos = userBo.searchUser(keyword);

        if (userDtos.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "No matching records found").show();
            ClearAllOnAction(); // Clear fields
        } else {
            UserDto firstResult = userDtos.get(0);
            txtId.setText(String.valueOf(firstResult.getId()));
            txtName.setText(firstResult.getName());
            txtAddress.setText(firstResult.getAddress());
            txtEmail.setText(firstResult.getEmail());
        }
    }


    private void loadAllUsers() {
        ObservableList<UserDto> userList = FXCollections.observableArrayList(userBo.getAllUsers());
        UserTable.setItems(userList);
    }

    private void ClearAllOnAction() {
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}

