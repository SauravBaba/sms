package com.example.sms.Controllers;


import com.example.sms.Entity.StudentEntity;
import com.example.sms.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
/**
 * REST controller for managing student-related operations.
 * Provides endpoints for retrieving, creating, updating, and deleting student records.
 */
class StudentController {

    @Autowired
    private StudentService service;

    /**
     * Retrieves a list of all students.
     *
     * @return A list of {@link StudentEntity} objects representing all students.
     */
    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return service.getAllStudents();
    }

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The {@link StudentEntity} object if found, otherwise {@code null}.
     */
    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return service.getStudentById(id).orElse(null);
    }

    /**
     * Creates a new student record.
     *
     * @param student The {@link StudentEntity} object containing the details of the student to create.
     * @return The created {@link StudentEntity} object.
     */
    @PostMapping()
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return service.createStudent(student);
    }

    /**
     * Updates an existing student record.
     *
     * @param id The ID of the student to update.
     * @param student The {@link StudentEntity} object containing the updated details of the student.
     * @return The updated {@link StudentEntity} object.
     */
    @PutMapping("/{id}")
    public StudentEntity updateStudent(@PathVariable Long id , @RequestBody StudentEntity student) {
        return service.updateStudent(id, student);
    }

    /**
     * Deletes a student record by their unique ID.
     *
     * @param id The ID of the student to delete.
     */
    @DeleteMapping("/{id}")
    public void  deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }


}