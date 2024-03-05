package Ijse.Controller;

import Ijse.Bo.custom.UserBo;
import Ijse.Bo.custom.impl.UserBoImpl;
import Ijse.Dto.UserDto;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class UserSignUpFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtId;
    private UserBo userBo = new UserBoImpl();
    public void initialize() {
        int maxId = userBo.getMaxUserId();
        // Increment the maximum ID to generate the next ID
        int nextId = maxId + 1;

        // Set the next ID in the txtId text field
        txtId.setText(String.valueOf(nextId));
    }


    public void SignInOnAction(ActionEvent actionEvent) throws IOException {


            String id = txtId.getText();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            String password = txtPassword.getText();

            UserDto userDto = new UserDto();
            userDto.setId(Integer.parseInt(id));
            userDto.setName(name);
            userDto.setEmail(email);
            userDto.setAddress(address);
            userDto.setPassword(password);

            if (userBo.saveUser(userDto)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("User registered successfully!");
                alert.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UserLogIn.fxml"));
                Parent root = loader.load();

                // scene eka set karala ekata root eka assign karanawa
                Scene scene = new Scene(root);

                // stage ekak create karala ekata action ka danawa
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                // a stage ekata scene eka set karla show karnawa
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to register user. Please try again.");
                alert.showAndWait();
            }
        }

    }

