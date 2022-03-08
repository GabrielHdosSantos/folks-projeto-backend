package br.com.folks.english.repo;

import br.com.folks.english.resultSets.RepositionResultSet;
import br.com.folks.english.model.RepositionClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface RepositionClassesRepo extends JpaRepository<RepositionClasses, Long> {

   @Query(value = "SELECT s.name as \"StudentName\", t.name as \"TeacherName\", c.class_date " +
           "FROM reposition_classes c join student s, teacher t " +
           "WHERE s.id = :id", nativeQuery = true)
   List<RepositionResultSet> findByStudent_id(Long id);


   @Query(value = "SELECT s.name as \"StudentName\", t.name as \"TeacherName\", c.class_date " +
           "FROM reposition_classes c join student s, teacher t " +
           "WHERE t.id = :id", nativeQuery = true)
   List<RepositionResultSet> findByTeacher_id(Long id);


   @Query(value = "SELECT s.name as \"StudentName\", t.name as \"TeacherName\", c.class_date " +
           "FROM reposition_classes c join student s, teacher t " +
           "WHERE class_date =:date", nativeQuery = true)
   List<RepositionResultSet> findRepositionClassesByClassDate(String date);


}
