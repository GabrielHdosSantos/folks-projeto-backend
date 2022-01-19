package br.com.folks.english.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Teacher implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private String email;
    private String password;
    private String cpf;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<ClassRoom> classRoomList;
    private boolean isActive;

    public Teacher(String name, String secondName, int age, String email, String password, String cpf, boolean isActive) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.isActive = isActive;
    }

    @Deprecated
    public Teacher(){}
}
