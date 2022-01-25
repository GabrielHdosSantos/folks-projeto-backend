package br.com.folks.english.dto;

public class ClassRoomDTO {

    public Object teacherNome;
    public Object book;
    public Object days;
    public Object hour;


    public ClassRoomDTO(Object teacherNome, Object book, Object days, Object hour) {
        this.teacherNome = teacherNome;
        this.book = book;
        this.days = days;
        this.hour = hour;
    }

    public ClassRoomDTO(){}
}
