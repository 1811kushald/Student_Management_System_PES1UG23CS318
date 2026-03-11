package com.example.studentmanagement.model;

import jakarta.persistence.*;

@Entity // Proper use of @Entity 
public class Student {

    @Id // Proper use of @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID works 
    private Long id; // Auto-generated unique identifier [cite: 31]

    @Column(nullable = false)
    private String name; // name [cite: 32]

    @Column(nullable = false, unique = true)
    private String email; // email [cite: 33]

    @Column(nullable = false)
    private String course; // course [cite: 34]

    // Constructors
    public Student() {}

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}