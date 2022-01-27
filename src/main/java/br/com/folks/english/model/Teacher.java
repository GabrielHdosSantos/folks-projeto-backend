package br.com.folks.english.model;

import br.com.folks.english.enums.InfosP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Teacher extends User implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private String email;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private InfosP orientation;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<ClassRoom> classRoomList;

    @BooleanFlag
    private boolean ativo;

    public Teacher(String login, String password, String name, String secondName, int age, String email, String cpf, InfosP orientation, List<ClassRoom> classRoomList, boolean ativo) {
        super(login, password);
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
        this.orientation = orientation;
        this.classRoomList = classRoomList;
        this.ativo = ativo;
    }

    @Deprecated
    public Teacher(){}
}
