package lk.ijse.Controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.DTO.BookDto;

import java.sql.SQLException;
import java.util.List;

public class UserBookFormController {
    public TableView<BookDto> tblBooks;
    BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);
    public TableColumn<BookDto, String> IdColumn;
    public TableColumn<BookDto, String> TitleColumn;
    public TableColumn<BookDto, String> AuthorColumn;
    public TableColumn<BookDto, String> GenerColumn;
    public TableColumn<BookDto, String> StatusColumn;

    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllBooks();




        IdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("Authour"));
        GenerColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void loadAllBooks() {
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
}
