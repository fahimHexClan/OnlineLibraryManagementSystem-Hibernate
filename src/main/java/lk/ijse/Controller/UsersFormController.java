package lk.ijse.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DTO.BookDto;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.DTO.UserDto;
import org.controlsfx.control.Notifications;

import java.sql.SQLException;
import java.util.List;

public class UsersFormController {
    public TableView<UserDto> tblUser;
    public TableColumn NameColumn;
    public TableColumn EmailColumn;
    public TableColumn Actioncolumn;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize() throws Exception {

        loadAllUsers();
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        Actioncolumn.setCellFactory(param -> new UsersFormController.ActionButtonTableCell());


    }
    class ActionButtonTableCell extends TableCell<UserDto, String> {

        private final Button deleteButton = new Button("Delete");

        {
            deleteButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff");

            deleteButton.setOnAction(event -> {
                UserDto v = getTableView().getItems().get(getIndex());
                // userBO.deleteUser(v.getName());
                loadAllUsers();

                ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
                Notifications.create()
                        .graphic(imageView)
                        .text(" Book Deleted. ")
                        .title("Successful")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .darkStyle()
                        .show();
            });
        }
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(deleteButton);
            }
        }
    }
    


    private void loadAllUsers() {
        tblUser.getItems().clear();

        try {
            List<UserDto> allUser = userBO.getAllUser();
            tblUser.getItems().addAll(allUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}


