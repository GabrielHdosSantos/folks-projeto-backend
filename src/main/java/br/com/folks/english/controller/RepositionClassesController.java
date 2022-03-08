package br.com.folks.english.controller;

import br.com.folks.english.resultSets.RepositionResultSet;
import br.com.folks.english.model.RepositionClasses;
import br.com.folks.english.service.RepositionClassesService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("repositionClass")
public class RepositionClassesController {

    @Autowired
    private RepositionClassesService service;

    @GetMapping("find/repositionByDate")
    public ResponseEntity<List<RepositionResultSet>> findRepositionByDate(
            @RequestParam String date) {

        List<RepositionResultSet> list =
                service.findRepositionByClassDate(date);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @PostMapping("student/{idStudent}/teacher/{idTeacher}")
    public ResponseEntity<RepositionClasses> addReposition(
            @RequestBody RepositionClasses repositionClasses,
            @PathVariable Long idStudent,
            @PathVariable Long idTeacher) {

        RepositionClasses obj =
                service.addReposition(repositionClasses, idStudent, idTeacher);

        return new ResponseEntity<>(obj, HttpStatus.CREATED);

    }

    @PatchMapping("update/{id}")
    public ResponseEntity<RepositionClasses> updateReposition(
            @RequestBody RepositionClasses repositionClasses,
            @PathVariable Long id) {

        RepositionClasses obj =
                service.update(repositionClasses, id);

        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @GetMapping("find/student/{idStudent}")
    public ResponseEntity<List<RepositionResultSet>> findStudentRepositon(
            @PathVariable Long idStudent) {

        List<RepositionResultSet> list =
                service.repositionStudentList(idStudent);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("find/teacher/{idTeacher}")
    public ResponseEntity<List<RepositionResultSet>> findTeacherRepositon(
            @PathVariable Long idTeacher) {

        List<RepositionResultSet> list =
                service.repositionTeacherList(idTeacher);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


}
