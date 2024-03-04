package Ijse.Controller;

import Ijse.Bo.custom.AdminBo;
import Ijse.Bo.custom.impl.AdminBoImpl;
import Ijse.Dto.AdminDto;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpPageController {

    public JFXTextField txtId;
    public JFXTextField txtPassword;
    public void initialize() {
        // meken wenne sign up ekata issellama id eka load karaganna Object create karanawa
        AdminBo adminBo = new AdminBoImpl();

        // a create karapu object eke  getgenarateid  method eka call karanawa
        int generatedId = adminBo.getGeneratedId();
        //meken wenne txtid ekata generate karapu id eka set karanawa
        txtId.setText(String.valueOf(generatedId));
    }

    public void SignUpOnAction(ActionEvent actionEvent) throws IOException {
        //fx eken gathhta txtid,name ekata meyalawa set karanawa
        String id = txtId.getText();
        String password = txtPassword.getText();

        // Validate ekak danawa password emoty wennethuwa ganna
        if (password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        // dto ekata data 2 set karanawa
        AdminDto adminDto = new AdminDto();
        adminDto.setId(Integer.parseInt(id));
        adminDto.setPassword(password);

        //a dto ekata set karagaththa eka Bo ekata yawala dto eken entity ekata maru karanawa
        AdminBo adminBo = new AdminBoImpl();
        // uda set karapu eka save unanam eya allert ekak dala log in ekata navigate karanawa
        if (adminBo.SaveAdmin(adminDto)) {

            // meken wenne
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Successfully saved.");
            alert.showAndWait();

            // Navigate karanawa
            navigateToLogInPage(actionEvent);
        } else {
            // error msg ekak aawanam alert ekak show wenawa
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid ID or Password. Please try again.");
            alert.showAndWait();
        }
    }

    void navigateToLogInPage(ActionEvent actionEvent) throws IOException {
        // fxml file eka load karanawa  ,path eka set karanawa
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminLogInForm.fxml"));
        Parent root = loader.load();

        // scene eka set karala ekata root eka assign karanawa
        Scene scene = new Scene(root);

        // stage ekak create karala ekata action ka danawa
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // a stage ekata scene eka set karla show karnawa
        stage.setScene(scene);
        stage.show();
    }
}