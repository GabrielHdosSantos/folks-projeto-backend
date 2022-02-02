package br.com.folks.english.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    private String streetName;
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
