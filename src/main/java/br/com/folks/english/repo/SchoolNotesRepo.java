package br.com.folks.english.repo;

import br.com.folks.english.model.SchoolNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SchoolNotesRepo extends JpaRepository<SchoolNotes, Long> {

    List<SchoolNotes> findByStudent_Id(Long id);


}
