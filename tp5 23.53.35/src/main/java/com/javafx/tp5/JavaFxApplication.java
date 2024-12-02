package com.javafx.tp5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFxApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFxApplication.class.getResource("professeur-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Professor Management System");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}