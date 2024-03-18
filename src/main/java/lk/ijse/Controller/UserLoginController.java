package lk.ijse.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Entity.User;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginController {
    public AnchorPane UserAnchore;
    public JFXTextField NameTxt;
    static String name;
    public JFXPasswordField PasswordTxt;
    UserBO userBO= (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    public void UserLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        validLogin();

    }

    private void validLogin() throws IOException, SQLException, ClassNotFoundException {
        String username = NameTxt.getText();
        User user = userBO.getUserByName(username);

        if (user == null || user.getName() == null) {
            ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text("Error: Username not found or incorrect. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();

        } else {
            // Check if the entered password matches the user's password
            if (user.getPassword().equals(PasswordTxt.getText())) {
                // Login successful
               // System.out.println("hri");
              createDashboard();
            } else {
                ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
                Notifications.create()
                        .graphic(imageView)
                        .text("Error: Incorrect password.")
                        .title("WARNING")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .darkStyle()
                        .show();


            }
        }
    }


    private void createDashboard() throws IOException {
        name = NameTxt.getText();
        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/UserMainForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setTitle("Main");
        stage.setFullScreen(true);
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
        NameTxt.clear();
    }

    public void RegisterBtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/View/RegisterForm.fxml"));
        UserAnchore.getChildren().clear();
        UserAnchore.getChildren().setAll(node);
    }
}
