package br.com.folks.english.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Adress implements Serializable {

    private final static Long SerialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da rua não pode ser vazio")
    @NotEmpty(message = "O nome deve ser preenchido!")
    private String streetName;

    @NotNull
    private int number;

    private String description;

    public Adress(Long id, String streetName, int number, String description) {
        this.id = id;
        this.streetName = streetName;
        this.number = number;
        this.description = description;
    }

    @Deprecated
    public Adress(){}
}
