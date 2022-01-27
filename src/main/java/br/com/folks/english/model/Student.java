package br.com.folks.english.model;

import br.com.folks.english.enums.InfosP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Student extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private String email;
    private String cpf;
    private String identification;
    @Enumerated(EnumType.STRING)
    private InfosP orientation;

    @ManyToOne
    private ClassRoom classRoom;
    @BooleanFlag
    private boolean ativo;

    public Student(String login, String password, String name, String secondName, int age, String email, String cpf, String identification, InfosP orientation, ClassRoom classRoom, boolean ativo) {
        super(login, password);
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
        this.identification = identification;
        this.orientation = orientation;
        this.classRoom = classRoom;
        this.ativo = ativo;
    }

    @Deprecated
    public Student() {
    }


}
