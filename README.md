Great! Let’s build the **Student Management System** step-by-step using **Spring Boot** (Beginner Level).

---

## 🎯 **Goal**:

Create a REST API to manage students with the following features:

* Add a student ✅
* Get all students ✅
* Get student by ID ✅
* Update student ✅
* Delete student ✅

---

## 🧱 **Tech Stack**:

* Java 17+
* Spring Boot (3.x+)
* Spring Web
* Spring Data JPA
* H2 Database (in-memory)
* Lombok (to avoid boilerplate code)

---

## ✅ **Step 1: Create Spring Boot Project**

### 👉 Use [Spring Initializr](https://start.spring.io/)

* **Project:** Maven
* **Language:** Java
* **Spring Boot:** 3.1.x or latest
* **Dependencies:**

  * Spring Web
  * Spring Data JPA
  * H2 Database
  * Lombok

Click **Generate**, extract the ZIP and open in IntelliJ or Eclipse.

---

## ✅ **Step 2: Project Structure**

```
student-management/
 ┣ src/
 ┃ ┣ main/
 ┃ ┃ ┣ java/com/example/student/
 ┃ ┃ ┃ ┣ controller/
 ┃ ┃ ┃ ┣ service/
 ┃ ┃ ┃ ┣ repository/
 ┃ ┃ ┃ ┗ model/
 ┃ ┃ ┣ resources/
 ┃ ┃ ┃ ┗ application.properties
```

---

## ✅ **Step 3: Model (Entity)**

📄 `Student.java`

```java
package com.example.student.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String course;
    private Double grade;
}
```

---

## ✅ **Step 4: Repository**

📄 `StudentRepository.java`

```java
package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
```

---

## ✅ **Step 5: Service**

📄 `StudentService.java`

```java
package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = getStudentById(id);
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        student.setGrade(updatedStudent.getGrade());
        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
```

---

## ✅ **Step 6: Controller**

📄 `StudentController.java`

```java
package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
```

---

## ✅ **Step 7: Configuration**

📄 `application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

> Access H2 Console at: `http://localhost:8080/h2-console`

---

## ✅ **Step 8: Run & Test**

* Run the app: `StudentManagementApplication.java`
* Use **Postman** or **cURL** to test these endpoints:

  * `GET    /api/students`
  * `POST   /api/students`
  * `GET    /api/students/{id}`
  * `PUT    /api/students/{id}`
  * `DELETE /api/students/{id}`

---

