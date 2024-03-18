package lk.ijse.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DTO.UserDto;

import org.controlsfx.control.Notifications;

public class RegisterFormController {
    public JFXTextField EmailTxt;
    public JFXPasswordField PasswordTxt;
    public JFXTextField NameTxt;
    UserBO userBO= (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    public void RegisterBtnOnAction(ActionEvent actionEvent) {
        String Name=NameTxt.getText();
        String Password=PasswordTxt.getText();
        String Email=EmailTxt.getText();


        try {
            userBO.addUser(new UserDto(Name,Email,Password,null));


            ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text(" User Added. ")
                    .title("Successful")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
            ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text("User Not Added. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        }
    }
}
