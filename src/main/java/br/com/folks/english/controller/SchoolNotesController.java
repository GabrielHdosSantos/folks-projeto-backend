package br.com.folks.english.controller;

import br.com.folks.english.model.SchoolNotes;
import br.com.folks.english.model.Student;
import br.com.folks.english.service.SchoolNotesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("schoolNotes")
public class SchoolNotesController {

    @Autowired
    private SchoolNotesService service;


    @PostMapping("{idStudent}")
    public ResponseEntity<SchoolNotes> addNotes(@RequestBody SchoolNotes schoolNotes, @PathVariable Long idStudent) {

        SchoolNotes obj = service.addSchoolNotes(schoolNotes, idStudent);

        return new ResponseEntity<>(obj, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<List<SchoolNotes>> listStudentNotes(@PathVariable Long id) {

        List<SchoolNotes> list = service.findStudentNotes(id);

        return new ResponseEntity<>(list, HttpStatus.OK);


    }


}
