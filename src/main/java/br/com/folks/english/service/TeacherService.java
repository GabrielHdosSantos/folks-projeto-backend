package br.com.folks.english.service;

import br.com.folks.english.model.Teacher;
import br.com.folks.english.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherRepo repo;

    public Teacher addTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher, Long id) {
        teacher.setId(id);
        return repo.save(teacher);
    }

    public List<Teacher> all() {
        return repo.findAll();
    }

    public Teacher findById(Long id) {
        return repo.getById(id);
    }

    public void deleteTeacher(Long id) {
        repo.deleteById(id);
    }

}
