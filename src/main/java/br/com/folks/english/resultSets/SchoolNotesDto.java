package br.com.folks.english.resultSets;

import br.com.folks.english.model.SchoolNotes;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.SqlResultSetMapping;


public interface SchoolNotesDto {

    String getNome();
    Double getNota();

}
