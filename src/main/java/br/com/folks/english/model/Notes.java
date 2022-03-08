package br.com.folks.english.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
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
