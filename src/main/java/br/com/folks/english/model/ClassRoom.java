package br.com.folks.english.model;

import br.com.folks.english.enums.Days;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class ClassRoom implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String book;

    @Enumerated(EnumType.STRING)
    private Days days;

    private String hour;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "classRoom")
    @JsonIgnore
    private List<Student> students;

    @OneToMany(mappedBy = "classRoom")
    private List<Notes> anotations;

    public ClassRoom(Long id, String book, Days days, String hour, Teacher teacher, List<Student> students, List<Notes> anotations) {
        this.id = id;
        this.book = book;
        this.days = days;
        this.hour = hour;
        this.teacher = teacher;
        this.students = students;
        this.anotations = anotations;
    }

    @Deprecated
    public ClassRoom(){}
}
