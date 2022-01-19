package br.com.folks.english.controller;

import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/class")
@RestController
@CrossOrigin(origins = "*")
public class ClassRoomController {

    @Autowired
    private ClassRoomService service;

    @PostMapping
    public ResponseEntity<ClassRoom> addClass(@RequestBody ClassRoom classRoom) {
        ClassRoom newClass = service.addClass(classRoom);
        return new ResponseEntity<>(newClass, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClassRoom> updateClass(@RequestBody ClassRoom classRoom, @PathVariable("") Long id) {
        ClassRoom newClass = service.updateClass(classRoom, id);
        return new ResponseEntity<>(newClass, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ClassRoom>> all() {
        List<ClassRoom> classRooms = service.all();
        return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> findById(@PathVariable("id") Long id) {
        ClassRoom newClass = service.findById(id);
        return new ResponseEntity<>(newClass, HttpStatus.OK);
    }

    @PatchMapping("class/{idclass}/teacher/{idteacher}")
    public ResponseEntity<ClassRoom> assignClassToTeacher(@PathVariable("idclass") Long idclass, @PathVariable("idteacher") Long idteacher) {

        ClassRoom newClassRoom = service.assignClassToTeacher(idclass, idteacher);

        return new ResponseEntity<>(newClassRoom, HttpStatus.OK);

    }

}
