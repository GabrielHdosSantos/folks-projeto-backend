package br.com.folks.english.service;

import br.com.folks.english.model.RepositionClasses;
import br.com.folks.english.model.Student;
import br.com.folks.english.model.Teacher;
import br.com.folks.english.repo.RepositionClassesRepo;
import br.com.folks.english.repo.StudentRepo;
import br.com.folks.english.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class RepositionClassesService {

    @Autowired
    private RepositionClassesRepo repo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    public RepositionClasses addReposition(RepositionClasses repositionClasses, Long idStudent, Long idTeacher) {
        List<RepositionClasses> list = new ArrayList<>();

        Student student = studentRepo.getById(idStudent);
        Teacher teacher = teacherRepo.getById(idTeacher);

        repositionClasses.setStudent(student);
        repositionClasses.setTeacher(teacher);


        list.add(repositionClasses);

        student.setRepositionClasses(list);
        teacher.setRepositionClasses(list);


        studentRepo.save(student);
        teacherRepo.save(teacher);

        return repo.save(repositionClasses);

    }

    public RepositionClasses update(RepositionClasses repositionClasses, Long id) {

        repositionClasses.setId(id);

        return repo.save(repositionClasses);

    }

    public List<RepositionClasses> repositionClassesList(Long id) {
        List<RepositionClasses> list = repo.findByStudent_id(id);

        return list;

    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
