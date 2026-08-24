package com.fundoo.fundooapp.repository;

import com.fundoo.fundooapp.entity.Note;
import com.fundoo.fundooapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer>, JpaSpecificationExecutor<Note> {
    List<Note> findByOwnerAndIsDeletedFalse(User owner);
    List<Note> findByOwnerAndIsArchivedTrueAndIsDeletedFalse(User owner);
    List<Note> findByOwnerAndIsDeletedTrue(User owner);
    Optional<Note> findByNoteIdAndOwner(int noteId, User owner);
}