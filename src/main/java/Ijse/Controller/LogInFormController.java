package Ijse.Controller;

import Ijse.Bo.custom.AdminBo;
import Ijse.Bo.custom.impl.AdminBoImpl;
import Ijse.Dto.AdminDto;
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

public class LogInFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtId;


    public void LogInOnAction(ActionEvent actionEvent) throws IOException {
        //fx eken gathha  txtid,password ekatai set karagannawa
        String id = txtId.getText();
        String password = txtPassword.getText();

        //id eka match una nttm  alert eka show karanna kiyanawa
        if (!id.matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid ID format. Please enter a valid ID.");
            alert.showAndWait();
            return;
        }

        // ui eke gaththa data tika dto ekata set karanawa
        AdminDto adminDto = new AdminDto();
        adminDto.setId(Integer.parseInt(id));
        adminDto.setPassword(password);

        // bo object eka create karala eke dtabase eke thiyana
        // sign page eka add karapu data ekai loginpage eke add karapu data ekath hari navigete wenawa main ekata
        AdminBo adminBo = new AdminBoImpl();
        if (adminBo.checkAdmin(adminDto)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainForm.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            // nttm error alert ekak pennawa
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid ID or Password. Please try again.");
            alert.showAndWait();
        }
    }



    public void SignupOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUpPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
