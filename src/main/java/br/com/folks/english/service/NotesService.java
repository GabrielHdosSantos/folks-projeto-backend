package br.com.folks.english.service;

import br.com.folks.english.model.ClassRoom;
import br.com.folks.english.model.Notes;
import br.com.folks.english.repo.ClassRoomRepo;
import br.com.folks.english.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NotesService {

    @Autowired
    private NotesRepo repo;

    @Autowired
    private ClassRoomService classRoomService;

    public Notes add(Notes notes, Long id){

        List<Notes> list = new ArrayList<>();

        ClassRoom classRoom = classRoomService.findById(id);

        notes.setClassRoom(classRoom);
        list.add(notes);
        classRoom.setAnotations(list);


        return repo.save(notes);
    }

    public Notes updateNotes(Notes notes, Long id){
        notes.setId(id);
        return repo.save(notes);
    }

    public List<Notes> list (Long id){
      return  repo.findAllByclassRoomId(id);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}
