package br.com.folks.english.service;

import br.com.folks.english.resultSets.SchoolNotesDto;
import br.com.folks.english.model.SchoolNotes;
import br.com.folks.english.model.Student;
import br.com.folks.english.repo.SchoolNotesRepo;
import br.com.folks.english.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SchoolNotesService {

    @Autowired
    private SchoolNotesRepo repo;

    @Autowired
    private StudentRepo studentRepo;

    public SchoolNotes addSchoolNotes(SchoolNotes schoolNotes, Long idStudent) {

        List<SchoolNotes> notes = new ArrayList<>();
        notes.add(schoolNotes);

        Student student = studentRepo.getById(idStudent);

        student.setSchoolNotes(notes);
        schoolNotes.setStudent(student);
        studentRepo.save(student);

        return repo.save(schoolNotes);

    }

    public SchoolNotes update(SchoolNotes schoolNotes, Long id) {

        schoolNotes.setId(id);

        return repo.save(schoolNotes);

    }

    public List<SchoolNotesDto> findStudentNotes(Long id){
        List<SchoolNotesDto> notes = repo.findStudent_nameAndValueByStudent_Id(id);

        return notes;
    }


}
