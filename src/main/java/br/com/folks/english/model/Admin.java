package br.com.folks.english.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Admin implements Serializable {

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
    private boolean isActive;

    public Admin(String name, String secondName, int age, String email, String password, String cpf, boolean isActive) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.isActive = isActive;
    }

    @Deprecated
    public Admin(){}

}
