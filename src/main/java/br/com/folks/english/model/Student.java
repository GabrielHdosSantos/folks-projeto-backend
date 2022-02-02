package br.com.folks.english.model;

import br.com.folks.english.enums.InfosP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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

    public Student(Long id, String streetName, int number, String description, String login, String password, Long id1, String name, String secondName, int age, String email, String cpf, String identification, InfosP orientation, ClassRoom classRoom, boolean ativo) {
        super(id, streetName, number, description, login, password);
        this.id = id1;
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
