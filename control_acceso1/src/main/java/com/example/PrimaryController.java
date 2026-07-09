package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {

    @FXML
    private void cambiarArea() throws IOException {
        App.setRoot("reportes_area1");
    }

    @FXML
    private AnchorPane root; // el AnchorPane raíz del FXML, agrégale fx:id="root"

    @FXML
    public void initialize() {
        root.sceneProperty().addListener((obs, oldScene, scene) -> {
            if (scene != null) {
                scene.widthProperty().addListener((o, ov, nv) -> updateFontScale(scene));
                updateFontScale(scene);
            }
        });
    }

    private void updateFontScale(Scene scene) {
        double base = Math.max(11, Math.min(16, scene.getWidth() / 90.0));
        root.setStyle("-fx-font-size: " + base + "px;");
    }
}
