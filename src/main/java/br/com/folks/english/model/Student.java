package br.com.folks.english.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private String email;
    private String password;
    private String cpf;
    private String identification;

    @ManyToOne
    private ClassRoom classRoom;
    private boolean isActive;

    public Student(String name, String secondName, int age, String email, String password, String cpf, String identification,ClassRoom classRoom, boolean isActive) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.identification = identification;
        this.classRoom = classRoom;
        this.isActive = isActive;
    }

    @Deprecated
    public Student() {
    }


}
