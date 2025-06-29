package com.example.sms.Services;

import com.example.sms.Entity.StudentEntity;
import com.example.sms.Repostitories.StudentRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    /**
     * Autowired StudentRepository to interact with the database.
     */
    @Autowired
    private StudentRepostiory repo;

    /**
     * Retrieves a list of all students from the database.
     *
     * @return A list of {@link StudentEntity} objects.
     */
    public List<StudentEntity> getAllStudents() {
        return repo.findAll();
    }

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id The ID of the student to retrieve.
     * @return An {@link Optional} containing the {@link StudentEntity} if found, or empty if not.
     */
    public Optional<StudentEntity> getStudentById(Long id) {
        System.out.println("hello");
        return repo.findById(id);
    }

    /**
     * Creates a new student record in the database.
     *
     * @param student The {@link StudentEntity} object to be saved.
     * @return The saved {@link StudentEntity} object.
     */
    public StudentEntity createStudent(StudentEntity student) {
        return repo.save(student);
    }

    /**
     * Updates an existing student record in the database.
     * If the student with the given ID is found, its details are updated.
     *
     * @param id The ID of the student to update.
     * @param student The {@link StudentEntity} object containing the updated details.
     * @return The updated {@link StudentEntity} object if found and updated, otherwise {@code null}.
     */
    public StudentEntity updateStudent(Long id , StudentEntity student) {
        Optional<StudentEntity> studentData = repo.findById(id);
        if (studentData.isPresent()) {
            StudentEntity newStudent = studentData.get();
            // Update student properties with new values
            newStudent.setName(student.getName());
            newStudent.setEmail(student.getEmail());
            newStudent.setCourse(student.getCourse());
            newStudent.setGrade(student.getGrade());
            // Save the updated student entity
            return repo.save(newStudent);
        }else {
            // Return null if student with given ID is not found
            return null;
        }

    }

    /**
     * Deletes a student record from the database by their ID.
     *
     * @param id The ID of the student to delete.
     */
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}