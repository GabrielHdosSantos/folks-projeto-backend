package br.com.folks.english.service;

import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.model.Teacher;
import br.com.folks.english.repo.ClassRoomRepo;
import br.com.folks.english.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassRoomService {

    @Autowired
    private ClassRoomRepo repo;

    @Autowired
    private TeacherRepo teacherRepo;

    public ClassRoom addClass(ClassRoom classRoom) {
        return repo.save(classRoom);
    }

    public ClassRoom updateClass(ClassRoom classRoom, Long id) {

        classRoom.setId(id);
        return repo.save(classRoom);
    }

    public List<ClassRoom> all() {
        return repo.findAll();
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

}
