package br.com.folks.english.repo;

import br.com.folks.english.dto.SchoolNotesDto;
import br.com.folks.english.model.SchoolNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolNotesRepo extends JpaRepository<SchoolNotes, Long> {

    @Query(value = "\n" +
            "select s.value as \"nota\", stu.name as \"nome\" from " +
            "folksss.school_notes s, folksss.student stu " +
            "where s.student_id = :idstudent and stu.id = :idstudent", nativeQuery = true)
    List<SchoolNotesDto> findStudent_nameAndValueByStudent_Id(@Param("idstudent") Long id);


}
