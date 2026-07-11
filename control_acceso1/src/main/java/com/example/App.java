package com.example;
import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("reportes"), 600, 400);
        stage.setScene(scene);

        stage.setTitle("Biblioteca | Control de Acceso");

        InputStream streamImagen = getClass().getResourceAsStream("resources/com/example/images/logo.png");
        if (streamImagen == null) {
            streamImagen = getClass().getResourceAsStream("images/logo.png");
        }
        
        if (streamImagen != null) {
            stage.getIcons().add(new Image(streamImagen));
        } else {
            System.out.println("[Advertencia] No se pudo cargar el icono del Stage. Comprueba la ruta.");
        }
        stage.setMaximized(true);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}