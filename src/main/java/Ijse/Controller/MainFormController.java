package Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {
    public AnchorPane SubAnchorPane;
    public AnchorPane MainAnchorpane;



    

    public void UserOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/userForm.fxml"));
        SubAnchorPane.getChildren().setAll(node);
    }

    public void BookOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/bookForm.fxml"));
        SubAnchorPane.getChildren().setAll(node);
    }

    public void BrancOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/branchForm.fxml"));
        SubAnchorPane.getChildren().setAll(node);
    }

    public void TransectionOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/TransectionForm .fxml"));
        SubAnchorPane.getChildren().setAll(node);
    }

    public void DashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/mainForm.fxml"));
        MainAnchorpane.getChildren().setAll(node);
    }


}
