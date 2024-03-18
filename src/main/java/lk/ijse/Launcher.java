package lk.ijse;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/LoginForm.fxml"))));
        primaryStage.centerOnScreen();
        primaryStage.show();

    }
}
