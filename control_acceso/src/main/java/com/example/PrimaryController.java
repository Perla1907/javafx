package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void cambiarArea() throws IOException {
        App.setRoot("reportes_area1");
    }
}
