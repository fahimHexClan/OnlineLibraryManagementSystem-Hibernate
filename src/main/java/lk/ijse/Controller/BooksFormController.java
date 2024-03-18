package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.DTO.BookDto;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import java.sql.SQLException;
import java.util.List;

public class BooksFormController {
    public TableView<BookDto> tblBooks;
    BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    public JFXTextField BookId;
    public JFXTextField BookAuthor;
    public JFXTextField BookGenre;
    public JFXTextField BookTitle;
    public JFXTextField BookAvailabilityStatus;
    public TableColumn<BookDto, String> IdColumn;
    public TableColumn<BookDto, String> TitleColumn;
    public TableColumn<BookDto, String> AuthorColumn;
    public TableColumn<BookDto, String> GenerColumn;
    public TableColumn<BookDto, String> StatusColumn;
    public TableColumn<BookDto, String> ActionColumn;
    public JFXButton AddBookBtn;
    public JFXButton updateBookbtn;

    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllBooks();
        loadBookId();

        // ActionColumn.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));

        IdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("Authour"));
        GenerColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        ActionColumn.setCellFactory(param -> new BooksFormController.ActionButtonTableCell()); // Add this line
    }
    private void loadBookId() throws SQLException, ClassNotFoundException {
        List<String> BID = bookBO.getBookIds();
        TextFields.bindAutoCompletion(BookId,BID);
    }

    public void IdSuggestOnAction(ActionEvent actionEvent) {

    }

    class ActionButtonTableCell extends TableCell<BookDto, String> {

        private final Button deleteButton = new Button("Delete");

        {
            deleteButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff");

            deleteButton.setOnAction(event -> {
                BookDto v = getTableView().getItems().get(getIndex());
                try {
                    bookBO.deleteBook(v.getID());
                    loadAllBooks();
                    clear();
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
    public void loadAllBooks() {
        tblBooks.getItems().clear();
        ObservableList<BookDto> items=  (ObservableList<BookDto>) tblBooks.getItems();;

        try {

            List<BookDto> allBooks = bookBO.getAllBooks();
            System.out.println(allBooks);

            for (BookDto c : allBooks) {
                items.add(new BookDto(c.getID(), c.getAuthour(), c.getGenre(),c.getTitle(),c.getStatus(),null));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void AddBookBtnOnActon(ActionEvent actionEvent) {
        String ID=BookId.getText();
        String Authour=BookAuthor.getText();
        String Genre=BookGenre.getText();
        String Title=BookTitle.getText();
        int Status=Integer.parseInt(BookAvailabilityStatus.getText());
        try {
            bookBO.addBook(new BookDto(ID, Authour, Genre, Title, Status,null));
            loadAllBooks();
            clear();
            ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text(" Book Added. ")
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
                    .text("Book Not Added. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        }
    }


    public void updateBookbtnOnAction(ActionEvent actionEvent) {
        String ID=BookId.getText();
        String Authour=BookAuthor.getText();
        String Genre=BookGenre.getText();
        String Title=BookTitle.getText();
        int Status=Integer.parseInt(BookAvailabilityStatus.getText());
        try {
            bookBO.UpdateBook(new BookDto(ID, Authour, Genre, Title, Status,null));
            loadAllBooks();
            clear();
            ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text(" Book Updated. ")
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
                    .text("Book Not Updated. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
        }
    }
    public void clear(){
        BookAuthor.clear();
        BookGenre.clear();
        BookTitle.clear();
        BookAvailabilityStatus.clear();
    }
}
