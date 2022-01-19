package br.com.folks.english.controller;

import br.com.folks.english.model.Teacher;
import br.com.folks.english.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        Teacher newTeacher = service.addTeacher(teacher);

        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long id){
        Teacher newTeacher = service.updateTeacher(teacher, id);
        return new ResponseEntity<>(newTeacher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> teachers(){
        List<Teacher> teachers = service.all();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(Long id){
        Teacher teacher = service.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(Long id){
        service.deleteTeacher(id);
    }

}
