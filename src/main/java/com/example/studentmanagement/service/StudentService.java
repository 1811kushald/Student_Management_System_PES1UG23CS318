package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Retrieve all students [cite: 40]
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Create: Add a new student record [cite: 36, 37]
    public Student addStudent(Student student) throws Exception {
        // Prevent duplicate email registration 
        if (repository.existsByEmail(student.getEmail())) {
            throw new Exception("Duplicate student details not allowed. Email already exists."); // Duplicate student details not allowed [cite: 67]
        }
        return repository.save(student);
    }
}