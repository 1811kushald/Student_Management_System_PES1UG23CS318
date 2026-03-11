package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET /api/students: Fetches a list of all student records[cite: 51, 52].
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // POST /api/students: Creates a new student record based on user input[cite: 49, 50].
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        try {
            // Validate incoming requests and ensure required fields are present [cite: 55, 56]
            if(student.getName() == null || student.getEmail() == null || student.getCourse() == null) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }
            Student savedStudent = service.addStudent(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}