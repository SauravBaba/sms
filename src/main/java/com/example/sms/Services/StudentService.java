package com.example.sms.Services;

import com.example.sms.Entity.StudtentEntity;
import com.example.sms.Repostitories.StudentRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepostiory repo;

    public List<StudtentEntity> getAllStudents() {
        return repo.findAll();
    }

    public Optional<StudtentEntity> getStudentById(Long id) {
        return repo.findById(id);
    }

    public StudtentEntity createStudent(StudtentEntity student) {
        return repo.save(student);
    }


}
