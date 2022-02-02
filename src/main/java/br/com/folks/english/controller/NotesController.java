package br.com.folks.english.controller;

import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.model.Notes;
import br.com.folks.english.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.List;

@RequestMapping("/notes")
@RestController
public class NotesController {

    @Autowired
    private NotesService service;


    @PostMapping("/{id}")
    public ResponseEntity<Notes> add(@RequestBody Notes notes, @PathVariable("id") Long id) {
        Notes newObj = service.add(notes, id);

        return new ResponseEntity<>(newObj, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Notes>> findClass(@PathVariable("id") Long id) {
        List<Notes> list = service.list(id);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Notes> update(@RequestBody Notes notes, @PathVariable("id") Long id) {
        Notes newNotes = service.updateNotes(notes, id);

        return new ResponseEntity<>(newNotes, HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
