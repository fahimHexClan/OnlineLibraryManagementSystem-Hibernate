package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.BranchBO;
import lk.ijse.DTO.BookDto;
import lk.ijse.DTO.BranchDto;
import lk.ijse.Entity.Branch;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import java.sql.SQLException;
import java.util.List;

public class BranchFormController {

    BranchBO branchBO= (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BRANCH);
    public JFXTextField BranchId;
    public JFXTextField BranchName;
    public JFXTextField BranchLocation;
    public TableView<BranchDto> tblBranchs;
    public TableColumn<BranchDto, String> IdColumn;
    public TableColumn<BranchDto, String> NameColumn;
    public TableColumn<BranchDto, String> LocationColumn;
    public TableColumn<BranchDto, String> ActionColumn;
    public void initialize() throws SQLException, ClassNotFoundException {
      loadAllBranchs();
        loadBranchId();


        // ActionColumn.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));

        IdColumn.setCellValueFactory(new PropertyValueFactory<>("BranchId"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("BranchName"));
        LocationColumn.setCellValueFactory(new PropertyValueFactory<>("BranchLocation"));

        ActionColumn.setCellFactory(param -> new BranchFormController.ActionButtonTableCell()); // Add this line
    }
    class ActionButtonTableCell extends TableCell<BranchDto, String> {

        private final Button deleteButton = new Button("Delete");

        {
            deleteButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff");

            deleteButton.setOnAction(event -> {
                BranchDto v = getTableView().getItems().get(getIndex());
                try {
                    branchBO.deleteBranch(v.getBranchId());
                   loadAllBranchs();
                   // clear();
                    ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
                    Notifications.create()
                            .graphic(imageView)
                            .text(" Book Deleted. ")
                            .title("Successful")
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.TOP_RIGHT)
                            .darkStyle()
                            .show();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
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

    private void loadAllBranchs() {
        tblBranchs.getItems().clear();
        ObservableList<BranchDto> items=  (ObservableList<BranchDto>) tblBranchs.getItems();;

        try {

            List<BranchDto> allBranchs = branchBO.getAllBranchs();
            System.out.println(allBranchs);

            for (BranchDto c : allBranchs) {
                items.add(new BranchDto(c.getBranchId(), c.getBranchName(), c.getBranchLocation()));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void AddBtnOnActon(ActionEvent actionEvent) {
        String ID=BranchId.getText();
        String name=BranchName.getText();
        String location=BranchLocation.getText();

        try {
            branchBO.addBranch(new BranchDto(ID, name, location));
           loadAllBranchs();

            ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text(" Branch Added. ")
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
                    .text("Branch Not Added. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        }
    }
    private void loadBranchId() throws SQLException, ClassNotFoundException {
        List<String> BID = branchBO.getBranchIds();
        TextFields.bindAutoCompletion(BranchId,BID);
    }

    public void updatebtnOnAction(ActionEvent actionEvent) {
        String ID=BranchId.getText();
        String name=BranchName.getText();
        String location=BranchLocation.getText();

        try {
            branchBO.UpdateBranch(new BranchDto(ID, name, location));
            loadAllBranchs();

            ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text(" Branch Added. ")
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
                    .text("Branch Not Added. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        }
    }
}
