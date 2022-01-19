package br.com.folks.english.controller;

import br.com.folks.english.model.Student;
import br.com.folks.english.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = service.addStudent(student);

        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        Student patchStudent = service.updateStudent(student, id);

        return new ResponseEntity<>(patchStudent, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> all() {
        List<Student> students = service.all();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(Long id) {
        Student student = service.findById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(Long id){
        service.deleteStudent(id);
    }
}
