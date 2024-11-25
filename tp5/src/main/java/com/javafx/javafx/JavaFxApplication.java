package com.javafx.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/main-view.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Gestion des Professeurs");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] args) {
        launch();
    }
}