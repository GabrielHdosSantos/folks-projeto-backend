package br.com.folks.english.controller;

import br.com.folks.english.dto.ClassRoomDTO;
import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<ClassRoomDTO>> all() {
        List<ClassRoomDTO> classRooms = service.all();
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

    @PatchMapping("class/{idclass}/student/{idstudent}")
    public ResponseEntity<ClassRoom> assignClassToStudent(@PathVariable("idclass") Long idclass, @PathVariable("idstudent") Long idteacher) {

        ClassRoom newClassRoom = service.assignClassToStudent(idclass, idteacher);

        return new ResponseEntity<>(newClassRoom, HttpStatus.OK);

    }

    @GetMapping("/class/{id}")
    public ResponseEntity<List<ClassRoomDTO>> findClassTeacher(@PathVariable("id") Long id) {
        List<ClassRoomDTO> result = service.findTeacherClass(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<List<ClassRoom>>> findStudentClass(@PathVariable("id") Long id){
        Optional<List<ClassRoom>> result = service.findStudentClass(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
