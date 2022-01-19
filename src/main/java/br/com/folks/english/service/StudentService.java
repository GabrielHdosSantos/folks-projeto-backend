package br.com.folks.english.service;

import br.com.folks.english.model.Student;
import br.com.folks.english.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public Student addStudent(Student student){
        return repo.save(student);
    }

    public Student updateStudent(Student student, Long id){
        student.setId(id);
        return repo.save(student);
    }

    public List<Student> all(){
        return repo.findAll();
    }

    public Student findById(Long id){
        return repo.getById(id);
    }

    public void deleteStudent(Long id){
        repo.deleteById(id);
    }


}
