package lk.ijse.Controller;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.BorrowBO;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DTO.BookDto;
import lk.ijse.DTO.BorrowDto;
import lk.ijse.DTO.CartDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Borrow;
import lk.ijse.Entity.User;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserBorrowFormController {
    public Label NameLabel;
    public JFXTextField SearchBooks;
    public JFXTextField BookAuthor;
    public JFXTextField BookGenre;
    public JFXTextField BookTitle;
    public JFXTextField BookAvailabilityStatus;
    public JFXTextField DueDate;
    public JFXTextField BorrowCount;
    public TableView<CartDto> tblBooks;
    public TableColumn<CartDto, String> IdColumn;
    public TableColumn<CartDto, String> TitleColumn;
    public TableColumn<CartDto, String> AuthorColumn;

    public TableColumn<CartDto, Integer> CountColumn;
    public TableColumn<CartDto, String> DateColumn;
    public TableColumn <CartDto, String>GenerColumn;

    private final ObservableList<CartDto> observableList = FXCollections.observableArrayList();
    public AnchorPane BorrowAnchore;
    public JFXTextField BorrowId;
    private int cartSelectedRow = -1;

    private final BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);
    BorrowBO borrowBO = (BorrowBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BORROW);
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    String name;
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        String name = UserLoginController.name;
        NameLabel.setText(name);
        loadBookId();
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("Authour"));
        GenerColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        CountColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void loadBookId() throws SQLException, ClassNotFoundException {
        List<String> BID = bookBO.getBookIds();
        TextFields.bindAutoCompletion(SearchBooks, BID);
    }

    public void SearchBtnOnaction(ActionEvent actionEvent) throws Exception {
        setData();
    }

    private void setData() throws Exception {
        String searchText = SearchBooks.getText().trim();
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
            BookAvailabilityStatus.setText(String.valueOf(book.getStatus()));
        } else {
            // If no matching book is found, display a warning message
            new Alert(Alert.AlertType.WARNING, "No matching record found.").show();
        }
    }



    public void BorrowBtnOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      //  System.out.println(generateNewId());
        String id = BorrowId.getText();

        String bookId = SearchBooks.getText();
        String dueDate = DueDate.getText();
        String userName = UserLoginController.name;
        int Qty = Integer.parseInt(BorrowCount.getText());

        // Retrieve the book and user objects from the database
        Book book = bookBO.getBookById(bookId);
        User user = userBO.getUserByName(userName);

        if (book != null && user != null) {
            // Create a new Borrow object
            BorrowDto borrowDto = new BorrowDto(id, user, book, dueDate, Qty);

            try {
                // Add the Borrow object to the database
                borrowBO.addBorrow(borrowDto);

updateBooks();
                // Show a success notification
                ImageView imageView = new ImageView(new Image("/Asset/icons8-done-96.png"));
                Notifications.create()
                        .graphic(imageView)
                        .text(" Borrow Added. ")
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
                        .text("Borrow Not Added. ")
                        .title("WARNING")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .darkStyle()
                        .show();
            }
        }
    }

    private void updateBooks() {
        String ID = SearchBooks.getText();
        String Author = BookAuthor.getText();
        String Genre = BookGenre.getText();
        String Title = BookTitle.getText();
        int Status = Integer.parseInt(BookAvailabilityStatus.getText());
        int Count = Integer.parseInt(BorrowCount.getText());
        int qty=Status-Count;
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
        }catch (Exception e) {
            e.printStackTrace();
            // Show an error notification
            ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text("Borrow Not Added. ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();

    }
    }
    public void AddToCartBtnOnAction(ActionEvent actionEvent) {
        String ID = SearchBooks.getText();
        String Author = BookAuthor.getText();
        String Genre = BookGenre.getText();
        String Title = BookTitle.getText();
        int Status = Integer.parseInt(BookAvailabilityStatus.getText());
        int Count = Integer.parseInt(BorrowCount.getText());
        String Date = DueDate.getText();

        if (Status < Count) {
            // Show warning if count is incorrect
            ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
            Notifications.create()
                    .graphic(imageView)
                    .text("Incorrect quantity ")
                    .title("WARNING")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .darkStyle()
                    .show();
            return;
        }

        CartDto tm = new CartDto(ID, Author, Genre, Title, Count, Date);
        int rowIndex = isExist(tm);
        if (rowIndex == -1) {
            // Book does not exist in the cart, add it
            observableList.add(tm);
        } else {
            // Book already exists in the cart, update its count
            CartDto existingTm = observableList.get(rowIndex);
            int newCount = existingTm.getCount() + Count;
            if(newCount<=Status){
                existingTm.setCount(newCount);
                observableList.set(rowIndex, existingTm);
            }else {
                ImageView imageView = new ImageView(new Image("/Asset/icons8-close-100.png"));
                Notifications.create()
                        .graphic(imageView)
                        .text("Incorrect quantity ")
                        .title("WARNING")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .darkStyle()
                        .show();
            }

        }

        tblBooks.setItems(observableList);
    }

    private int isExist(CartDto tm) {
        for (int i = 0; i < observableList.size(); i++) {
            if (tm.getID().equals(observableList.get(i).getID())) {
                return i;
            }
        }
        return -1;
    }

    private String generateNewId() {
        String newId = null;
        try {
            newId = borrowBO.generateCustomerID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        }

        if (newId == null || newId.isEmpty()) {
            return "BR00-001";
        } else {
            int newCustomerId = Integer.parseInt(newId.replace("BR00-", "")) + 1;
            return String.format("BR00-%03d", newCustomerId);
        }
    }

    private String getLastCustomerId() {
        try {
            List<BorrowDto> tempList = borrowBO.getAllBorrow(); // Assuming you have a method to retrieve all borrowings
            Collections.sort(tempList, Comparator.comparing(BorrowDto::getId));
            return tempList.get(tempList.size() - 1).getId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to get last customer ID " + e.getMessage()).show();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ReturnBtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/View/ReturnForm.fxml"));
        BorrowAnchore.getChildren().clear();
        BorrowAnchore.getChildren().setAll(node);

    }

    public void BorrowHistoryBtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/View/BorrowHistoryForm.fxml"));
        BorrowAnchore.getChildren().clear();
        BorrowAnchore.getChildren().setAll(node);
    }
}
