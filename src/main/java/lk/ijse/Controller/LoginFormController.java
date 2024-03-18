package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane loginFuntions;
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/View/UserLogin.fxml"));
        loginFuntions.getChildren().clear();
        loginFuntions.getChildren().setAll(node);
    }

    public void UserBtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/View/UserLogin.fxml"));
        loginFuntions.getChildren().clear();
        loginFuntions.getChildren().setAll(node);
    }

    public void AdminBtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/View/AdminLogin.fxml"));
        loginFuntions.getChildren().clear();
        loginFuntions.getChildren().setAll(node);
    }
}
