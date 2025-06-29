package com.example.sms.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Represents a Student entity in the Student Management System.
 * This class is mapped to a database table.
 */
@Entity
@Data
public class StudentEntity {

    /**
     * The unique identifier for the student.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the student.
     */
    private String name;

    /**
     * The email address of the student.
     */
    private String email;

    /**
     * The course the student is enrolled in.
     */
    private String course;

    /**
     * The grade of the student in the course.
     */
    private String grade;
}
