package br.com.folks.english.service;

import br.com.folks.english.model.RepositionClasses;
import br.com.folks.english.model.Student;
import br.com.folks.english.repo.RepositionClassesRepo;
import br.com.folks.english.repo.StudentRepo;
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

    public RepositionClasses addReposition(RepositionClasses repositionClasses, Long id) {
        List<RepositionClasses> list = new ArrayList<>();


        Student student = studentRepo.getById(id);
        repositionClasses.setStudent(student);
        list.add(repositionClasses);
        student.setRepositionClasses(list);
        studentRepo.save(student);

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
