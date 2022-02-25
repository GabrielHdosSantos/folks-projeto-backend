package br.com.folks.english.repo;

import br.com.folks.english.model.RepositionClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RepositionClassesRepo extends JpaRepository<RepositionClasses, Long> {

   List<RepositionClasses> findByStudent_id(Long id);

}
