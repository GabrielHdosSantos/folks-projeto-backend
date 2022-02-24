package br.com.folks.english.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolNotes implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double value;

    @NotBlank(message = "Você deve referenciar sobre do que é essa nota")
    @NotEmpty(message = "A referencia da nota deve ser preenchida")
    private String description;

    @ManyToOne
    private Student student;


}
