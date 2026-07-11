package com.example;

import java.io.IOException;
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
    private void reportesArea() {
        cargarVista("reportes_area.fxml");
    }

    @FXML
    private void reportesDia() {
        cargarVista("reportes_area.fxml");
    }

    // Método utilitario centralizado para alternar las vistas en el contenedor principal
    private void cargarVista(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlFile));
            Parent vista = loader.load();
            mainContainer.setCenter(vista);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista: " + fxmlFile);
        }
    }

   
}
