package br.com.folks.english.service;

import br.com.folks.english.dto.ClassRoomDTO;
import br.com.folks.english.dto.StudentDTO;
import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.model.Student;
import br.com.folks.english.model.Teacher;
import br.com.folks.english.repo.ClassRoomRepo;
import br.com.folks.english.repo.StudentRepo;
import br.com.folks.english.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.ValueRef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClassRoomService {

    @Autowired
    private ClassRoomRepo repo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentRepo studentRepo;

    public ClassRoom addClass(ClassRoom classRoom) {
        return repo.save(classRoom);
    }

    public ClassRoom updateClass(ClassRoom classRoom, Long id) {

        classRoom.setId(id);
        return repo.save(classRoom);
    }

    public List<ClassRoomDTO> all() {
        List<Tuple> result = repo.findAllClass();
        List<ClassRoomDTO> classes = new ArrayList<>();
        for (Tuple value : result) {
            ClassRoomDTO classRoomDTO = new ClassRoomDTO(value.get(0), value.get(1), value.get(2), value.get(3));
            classes.add(classRoomDTO);

        }
        return classes;

    }

    public ClassRoom findById(Long id) {
        return repo.getById(id);
    }

    public void deleteClass(Long id) {
        repo.deleteById(id);
    }

    public ClassRoom assignClassToTeacher(Long idClass, Long idTeacher) {

        List<ClassRoom> classRooms = new ArrayList<>();

        ClassRoom newClass = repo.getById(idClass);
        classRooms.add(newClass);
        Teacher newTeacher = teacherRepo.getById(idTeacher);
        newTeacher.setClassRoomList(classRooms);
        newClass.setTeacher(newTeacher);

        return newClass;

    }


    public ClassRoom assignClassToStudent(Long idClass, Long idStudent) {

        List<Student> students = new ArrayList<>();

        ClassRoom newClass = repo.getById(idClass);
        Student student = studentRepo.getById(idStudent);
        student.setClassRoom(newClass);
        students.add(student);
        newClass.setStudents(students);

        return newClass;

    }

    public List<ClassRoomDTO> findTeacherClass(Long id) {


        List<ClassRoomDTO> classRoomDTOS = new ArrayList<>();
        List<Tuple> result = repo.findClassTeacher(id);

        for (Tuple value : result) {
            ClassRoomDTO newClass = new ClassRoomDTO(value.get(0), value.get(1), value.get(2), value.get(3));
            classRoomDTOS.add(newClass);

        }
        return classRoomDTOS;

    }

    public Optional<List<ClassRoom>> findStudentClass(Long id) {

        Optional<List<ClassRoom>> lista = repo.findByStudentsId(id);

        if (Optional.of(lista).isPresent()) {
            return lista;
        } else {
            //passar exception
            return null;
        }

    }

    public List<StudentDTO> findClassStudents(Long id) {

        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Tuple> resultSet = repo.findAllClassStudents(id);

        for (Tuple value : resultSet) {

            StudentDTO studentDTO = new StudentDTO(value.get(0), value.get(1), value.get(2), value.get(3));
            studentDTOS.add(studentDTO);

        }


        return studentDTOS;


    }

}
