package br.com.folks.english.dto;

import br.com.folks.english.model.Student;

public class StudentDTO {

    public Object nome;
    public Object age;
    public Object ativo;
    public Object cpf;

    public StudentDTO(Object nome, Object age, Object ativo, Object cpf) {
        this.nome = nome;
        this.age = age;
        this.ativo = ativo;
        this.cpf = cpf;
    }

    public StudentDTO() {
    }

}
