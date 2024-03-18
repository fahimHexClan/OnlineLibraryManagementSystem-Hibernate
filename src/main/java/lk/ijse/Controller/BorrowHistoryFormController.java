package lk.ijse.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BorrowBO;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DTO.BookDto;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowHistoryFormController {


        public TableView<BorrowDto> tblBorrows;
        public TableColumn<BorrowDto, String> IdColumn;
        public TableColumn<BorrowDto, String> nameColumn;
        public TableColumn<BorrowDto, String> bookIdColumn;
        public TableColumn<BorrowDto, String> DateColumn;
        public TableColumn<BorrowDto, Integer> CountColumn;
        BorrowBO borrowBO = (BorrowBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BORROW);
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);



            public void initialize() throws Exception {
                if (isOk()) {
                    loadAllBorrows();
                    IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser().getName()));
                    bookIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBook().getID()));
                    DateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
                    CountColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                }
            }

            private boolean isOk() throws Exception {
                User user = userBO.getUserByName(UserLoginController.name);
                if (user != null) {
                    List<BorrowDto> allBorrows = borrowBO.getAllBorrow();
                    List<BorrowDto> userBorrows = new ArrayList<>();
                    for (BorrowDto borrow : allBorrows) {
                        if (borrow.getUser().equals(user)) {
                            userBorrows.add(borrow);
                        }
                    }
                    tblBorrows.getItems().setAll(userBorrows);
                    return true;
                } else {
                    return false;
                }
            }

            private void loadAllBorrows() {
                tblBorrows.getItems().clear();

                try {
                    List<BorrowDto> allBorrows = borrowBO.getAllBorrow();
                    tblBorrows.getItems().addAll(allBorrows);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }}

