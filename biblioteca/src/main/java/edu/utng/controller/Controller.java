package edu.utng.controller;

import java.io.IOException;

import edu.utng.app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    private BorderPane mainContainer;

    @FXML
    private void libro() {
        cargarVista("libro_view.fxml");
    }

    @FXML
    private void usuario() {
        cargarVista("usuario_view.fxml");
    }

    // Método utilitario centralizado para alternar las vistas en el contenedor principal
    private void cargarVista(String fxmlFile) {
        try {
            // Añadimos "/" al inicio para que busque desde la raíz del classpath
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/edu/utng/" + fxmlFile));
            Parent vista = loader.load();
            mainContainer.setCenter(vista);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista: " + fxmlFile);
        }
    }  
}
