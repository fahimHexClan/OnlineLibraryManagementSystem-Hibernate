package lk.ijse.Controller;

import javafx.scene.control.Label;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.UserBO;

import java.io.IOException;
import java.sql.SQLException;

public class DashboardController {
    public Label BookCount;
    public Label UserCount;
    public Label NameLabel;
    String name;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        name=UserLoginController.name;
        NameLabel.setText(name);
        setBookCount();
        setUserCount();
    }

    private void setUserCount() {
        UserCount.setText(String.valueOf(userBO.getUserCount()));
    }

    private void setBookCount() {
       BookCount.setText(String.valueOf(bookBO.getBookCount()));
    }

}
