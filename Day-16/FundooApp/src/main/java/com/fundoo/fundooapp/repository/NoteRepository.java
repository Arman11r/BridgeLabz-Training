package com.fundoo.fundooapp.repository;

import com.fundoo.fundooapp.entity.Note;
import com.fundoo.fundooapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByOwnerAndIsDeletedFalse(User owner);
    Optional<Note> findByNoteIdAndOwner(int noteId, User owner);
}