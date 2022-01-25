package br.com.folks.english.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Notes implements Serializable {

    private final static Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observations;

    private LocalDate classDate;

    @ManyToOne
    @JsonIgnore
    private ClassRoom classRoom;

    public Notes(String observations, LocalDate classDate, ClassRoom classRoom) {
        this.observations = observations;
        this.classDate = classDate;
        this.classRoom = classRoom;
    }

    @Deprecated
    public Notes(){}
}
