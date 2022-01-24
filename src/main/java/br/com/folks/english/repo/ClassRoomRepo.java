package br.com.folks.english.repo;

import br.com.folks.english.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRoom, Long> {

    @Query(value = "SELECT t.name, cr.book, cr.days, cr.hour \n" +
            "FROM teacher t\n" +
            "join class_room cr on cr.teacher_id = t.id where teacher_id = :id", nativeQuery = true)
    List<Tuple> findClassTeacher(@Param("id") Long id);

    @Query(value = "SELECT t.name, cr.book, cr.days, cr.hour \n" +
            "FROM teacher t\n" +
            "join class_room cr on cr.teacher_id = t.id", nativeQuery = true)
    List<Tuple> findAllClass();

}
