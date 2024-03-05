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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLogInController {

    public JFXPasswordField txtPassword;
    public JFXTextField txtId;
    public RadioButton btnRadio;
    public JFXTextField txtShowPassword;
    boolean passClicked;
    private UserBo userBo = new UserBoImpl();


    public void SignInOnAction(ActionEvent actionEvent) throws IOException {

            String id = txtId.getText();
            String password = txtPassword.getText();

            UserDto userDto = new UserDto();
            userDto.setId(Integer.parseInt(id));
            userDto.setPassword(password);

            if (userBo.checkUser(userDto)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UserDashBoaardForm.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid ID or Password. Please try again.");
                alert.showAndWait();
            }
        }


    public void SignUpOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/userSignUp.fxml"));
        Parent root = loader.load();

        // scene eka set karala ekata root eka assign karanawa
        Scene scene = new Scene(root);

        // stage ekak create karala ekata action ka danawa
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // a stage ekata scene eka set karla show karnawa
        stage.setScene(scene);
        stage.show();
    }

    public void btnRadioOnAction(ActionEvent actionEvent) {
        if (!passClicked) {
            passClicked = true;
            String passwordText = txtPassword.getText();
            txtShowPassword.setText(passwordText);
            txtPassword.setVisible(false);
            txtShowPassword.setVisible(true);
        } else {
            passClicked = false;
            txtPassword.setVisible(true);
            txtShowPassword.setVisible(false);
        }

    }
}
