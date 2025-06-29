package com.example.sms.Controllers;


import com.example.sms.Entity.StudtentEntity;
import com.example.sms.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudtentEntity> getAllStudents() {
       return service.getAllStudents();}

    @GetMapping("/{id}")
    public StudtentEntity getStudentById(@PathVariable Long id) {
        return service.getStudentById(id).get();}

    @PostMapping()
     public StudtentEntity createStudent(@RequestBody StudtentEntity student) {
        return service.createStudent(student);
    }


}
