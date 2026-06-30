package com.example.usecase;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Student;

public class StudentsUseCase {

    private final List<Student> studentList = new ArrayList<>();

    public void registerStudent(Student student) {
        // Aquí se pueden añadir validaciones de negocio en el futuro
        studentList.add(student);
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }
}
