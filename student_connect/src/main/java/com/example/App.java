package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("com.example.student_view.fxml"));
        primaryStage.setTitle("StudentConnect - Registro Universitario");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}