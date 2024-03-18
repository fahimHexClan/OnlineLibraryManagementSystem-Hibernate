package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.BorrowBO;
import lk.ijse.BO.Custom.ReturnBo;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DTO.BookDto;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.DTO.ReturnDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReturnFormController {
    int id=0;

    public JFXTextField BookAuthor;
    public JFXTextField BookId;
    public JFXTextField BookGenre;
    public JFXTextField BookTitle;
    public JFXTextField ReturnBookCount;
    private final BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    ReturnBo returnBo = (ReturnBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RETURN);
    public Label NameLabel;
    String name;
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
name=UserLoginController.name;
NameLabel.setText(name);
        loadBookId();
    }
    public void ReturnBtnOnAction(ActionEvent actionEvent) throws Exception {
        id=id+1;
        System.out.println(id);
        updateReturn();


        String searchText = BookId.getText().trim();
        BookDto book = null;
        int Status = 0;

        if (!searchText.isEmpty()) {
            // If an ID is provided, retrieve the book by ID
            book = bookBO.getBook(searchText);
        } else {
            // If no ID is provided, display a warning message
            new Alert(Alert.AlertType.WARNING, "Please enter a book ID.").show();
            return;
        }

        if (book != null) {
            // If the book is found, set the data to the UI components
             Status = Integer.parseInt(String.valueOf(book.getStatus()));
            System.out.println(Status);

        } else {
            // If no matching book is found, display a warning message
            new Alert(Alert.AlertType.WARNING, "No matching record found.").show();
        }
        String ID = BookId.getText();
        String Author = BookAuthor.getText();
        String Genre = BookGenre.getText();
        String Title = BookTitle.getText();

        int Count = Integer.parseInt(ReturnBookCount.getText());
        int qty = Status + Count;
        try {
            System.out.println(qty);
            bookBO.UpdateBook(new BookDto(ID, Author, Genre, Title, qty, null));
            ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text(" Transaction Success. ")
                    .title("Successful")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
            // Show an error notification
            ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text("Transaction Not Added. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();

        }
    }

    private void updateReturn() throws SQLException, ClassNotFoundException {
        ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
        Notifications.create()
                .graphic(imageView)
                .text(" Return Added. ")
                .title("Successful")
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT)
                .darkStyle()
                .show();
    }


    public void SearchBtnOnaction(ActionEvent actionEvent) throws Exception {
        setData();
    }

    private void setData() throws Exception {
        String searchText = BookId.getText().trim();
        BookDto book = null;

        if (!searchText.isEmpty()) {
            // If an ID is provided, retrieve the book by ID
            book = bookBO.getBook(searchText);
        } else {
            // If no ID is provided, display a warning message
            new Alert(Alert.AlertType.WARNING, "Please enter a book ID.").show();
            return;
        }

        if (book != null) {
            // If the book is found, set the data to the UI components
            BookTitle.setText(book.getTitle());
            BookAuthor.setText(book.getAuthour());
            BookGenre.setText(book.getGenre());

        } else {
            // If no matching book is found, display a warning message
            new Alert(Alert.AlertType.WARNING, "No matching record found.").show();
        }
    }
    private void loadBookId() throws SQLException, ClassNotFoundException {
        List<String> BID = bookBO.getBookIds();
        TextFields.bindAutoCompletion(BookId, BID);
    }


}
