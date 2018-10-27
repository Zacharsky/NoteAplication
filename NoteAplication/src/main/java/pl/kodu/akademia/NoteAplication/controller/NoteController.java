package pl.kodu.akademia.NoteAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kodu.akademia.NoteAplication.exception.ResourceNotFoundException;
import pl.kodu.akademia.NoteAplication.model.Note;
import pl.kodu.akademia.NoteAplication.repository.NoteRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;


    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);

    }

    @GetMapping("/notes/(id)")
    public Note getNoteById(@PathVariable(value = "id") Long noteId){
        return  noteRepository.findById(noteId)
                .orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PostMapping("/notes/(id)")
    public Note updadeNoteById(@PathVariable(value = "id") Long noteId, Note noteDetails){

        Note note = noteRepository.findById(noteId)
                .orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }

    @DeleteMapping("/notes/(id)")
    public ResponseEntity<Object> deleteNote(@PathVariable(value = "id") Long noteId){

        Note note = noteRepository.findById(noteId)
                .orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
       return ResponseEntity.ok().build();

    }
}
