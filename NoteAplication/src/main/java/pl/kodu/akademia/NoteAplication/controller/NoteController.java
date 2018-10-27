package pl.kodu.akademia.NoteAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.kodu.akademia.NoteAplication.model.Note;
import pl.kodu.akademia.NoteAplication.repository.NoteRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;



    @GetMapping(":/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);

    }
}
