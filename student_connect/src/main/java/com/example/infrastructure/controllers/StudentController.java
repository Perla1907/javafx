package com.example.infrastructure.controllers;

import com.example.domain.Student;
import com.example.usecase.StudentsUseCase;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StudentController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private TextArea txtAreaLista;

    private final StudentsUseCase useCase = new StudentsUseCase();
    
    @FXML
    public void handleRegistrar() {
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            
            mostrarAlerta("Campos Incompletos", "Por favor, rellene todos los campos del formulario");
            return;

        }
    
        Student nuevoEstudiante = new Student(nombre, direccion, telefono, correo);
        
        useCase.registerStudent(nuevoEstudiante);
        actualizarLista();
        limpiarCampos();
        
    }
    
    private void actualizarLista() {

        StringBuilder sb = new StringBuilder();
        sb.append("======= ESTUDIANTES REGISTRADOS =======\n\n");
        
        for (Student s : useCase.getAllStudents()) {
            sb.append(s.toString()).append("\n");
            sb.append("--------------------------------------------------\n");
        }

        txtAreaLista.setText(sb.toString());
        
    }
        
    private void limpiarCampos() {
        txtNombre.clear();
        txtDireccion.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtNombre.requestFocus();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
