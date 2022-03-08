package br.com.folks.english.controller;

import br.com.folks.english.model.RepositionClasses;
import br.com.folks.english.service.RepositionClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repositionClass")
public class RepositionClassesController {

    @Autowired
    private RepositionClassesService service;

    @PostMapping("student/{idStudent}/teacher/{idTeacher}")
    public ResponseEntity<RepositionClasses> addReposition(@RequestBody RepositionClasses repositionClasses, @PathVariable Long idStudent, @PathVariable Long idTeacher) {

        RepositionClasses obj = service.addReposition(repositionClasses, idStudent, idTeacher);

        return new ResponseEntity<>(obj, HttpStatus.CREATED);

    }

    @PatchMapping("{id}")
    public ResponseEntity<RepositionClasses> updateReposition(@RequestBody RepositionClasses repositionClasses, @PathVariable Long id) {

        RepositionClasses obj = service.update(repositionClasses, id);

        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @GetMapping("{idStudent}")
    public ResponseEntity<List<RepositionClasses>> findStudentRepositon(@PathVariable Long idStudent) {

        List<RepositionClasses> list = service.repositionClassesList(idStudent);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


}
