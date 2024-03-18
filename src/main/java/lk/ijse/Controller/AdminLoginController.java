package lk.ijse.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class AdminLoginController {
    public JFXTextField Name;
    public JFXPasswordField Code;
    String UserName="Fahim";
    String code="1234";
    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        if(UserName.equals(Name.getText())){
            if(code.equals(Code.getText())){
                createdashboard();}
            else {
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
        else {
            ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text("Error: Username not found or incorrect. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        }

    }

    private void createdashboard() throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/main.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setTitle("Main");
        stage.setFullScreen(true);
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }
}
