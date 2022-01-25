package br.com.folks.english.repo;

import br.com.folks.english.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long> {


    List<Notes> findAllByclassRoomId(Long id);

}
