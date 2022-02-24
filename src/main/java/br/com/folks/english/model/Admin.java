package br.com.folks.english.model;

import br.com.folks.english.enums.InfosP;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Admin extends User implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome não pode ser vazio")
    @NotBlank(message = "O nome deve ser preenchido!")
    private String name;

    @NotBlank(message = "O nome não pode ser vazio")
    @NotEmpty(message = "O nome deve ser preenchido!")
    private String secondName;

    @Min(0)
    @Max(70)
    private int age;

    @Email
    @NotEmpty(message = "Você não pode inserir um e-mail vazio")
    @NotBlank(message = "Você deve inserir um e-mail!")
    private String email;

    @NotBlank(message = "Você deve inserir um cpf!")
    @NotEmpty(message = "Você não pode cadastrar um cpf vazio")
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
