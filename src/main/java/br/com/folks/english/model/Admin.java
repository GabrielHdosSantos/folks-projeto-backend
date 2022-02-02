package br.com.folks.english.model;

import br.com.folks.english.enums.InfosP;
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
public class Admin extends User implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private String email;
    private String cpf;

    @BooleanFlag
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private InfosP orientation;

    public Admin(String login, String password, String name, String secondName, int age, String email, String cpf, boolean ativo, InfosP orientation) {
        super(login, password);
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
        this.ativo = ativo;
        this.orientation = orientation;
    }

    @Deprecated
    public Admin(){}

}
