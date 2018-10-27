package pl.kodu.akademia.NoteAplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodu.akademia.NoteAplication.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
