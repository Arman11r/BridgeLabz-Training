package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.NoteRequest;
import com.fundoo.fundooapp.dto.NoteResponse;
import com.fundoo.fundooapp.entity.Note;
import com.fundoo.fundooapp.entity.User;
import com.fundoo.fundooapp.exception.NoteNotFoundException;
import com.fundoo.fundooapp.repository.NoteRepository;
import com.fundoo.fundooapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public NoteResponse createNote(String email, NoteRequest req) {
        User owner = getUserByEmail(email);

        Note note = new Note();
        note.setTitle(req.getTitle());
        note.setDescription(req.getDescription());
        note.setColor(req.getColor());
        note.setTypeOfNote(req.getTypeOfNote());
        note.setImageUrl(req.getImageUrl());
        note.setLinkUrl(req.getLinkUrl());
        note.setOwner(owner);

        Note saved = noteRepository.save(note);
        return toResponse(saved);
    }

    @Override
    public List<NoteResponse> getAllNotes(String email) {
        User owner = getUserByEmail(email);
        return noteRepository.findByOwnerAndIsDeletedFalse(owner)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public NoteResponse getNoteById(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
        return toResponse(note);
    }

    @Override
    public NoteResponse updateNote(String email, int noteId, NoteRequest req) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        note.setTitle(req.getTitle());
        note.setDescription(req.getDescription());
        note.setColor(req.getColor());
        note.setTypeOfNote(req.getTypeOfNote());
        note.setImageUrl(req.getImageUrl());
        note.setLinkUrl(req.getLinkUrl());

        Note updated = noteRepository.save(note);
        return toResponse(updated);
    }

    @Override
    public void deleteNote(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        note.setDeleted(true);
        noteRepository.save(note);
    }

    private NoteResponse toResponse(Note note) {
        return new NoteResponse(
                note.getNoteId(), note.getTitle(), note.getDescription(),
                note.isPined(), note.isArchived(), note.getColor(),
                note.getTypeOfNote(), note.getImageUrl(), note.getLinkUrl()
        );
    }
}