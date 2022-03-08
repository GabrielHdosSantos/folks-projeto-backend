package br.com.folks.english.repo;

import br.com.folks.english.dto.ClassRoomDTO;
import br.com.folks.english.dto.StudentDTO;
import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRoom, Long> {

    @Query(value = "" +
            "SELECT t.name, cr.book, cr.days, cr.hour \n" +
            "FROM teacher t\n" +
            "JOIN class_room cr on cr.teacher_id = t.id " +
            "WHERE teacher_id = :id", nativeQuery = true)
    List<Tuple> findClassTeacher(@Param("id") Long id);

    @Query(value = "" +
            "SELECT t.name, cr.book, cr.days, cr.hour \n" +
            "FROM teacher t\n" +
            "JOIN class_room cr on cr.teacher_id = t.id", nativeQuery = true)
    List<Tuple> findAllClass();

    Optional<List<ClassRoom>> findByStudentsId(Long id);

    @Query(value = "SELECT s.name as \"nome\", s.age, s.ativo, s.cpf " +
            "FROM student s" +
            "WHERE class_room_id = :id", nativeQuery = true)
    List<Tuple> findAllClassStudents(Long id);


}
