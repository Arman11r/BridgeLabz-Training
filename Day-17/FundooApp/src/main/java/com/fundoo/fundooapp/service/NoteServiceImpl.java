package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.NoteRequest;
import com.fundoo.fundooapp.dto.NoteResponse;
import com.fundoo.fundooapp.dto.ReminderMessage;
import com.fundoo.fundooapp.dto.ReminderRequest;
import com.fundoo.fundooapp.entity.Note;
import com.fundoo.fundooapp.entity.User;
import com.fundoo.fundooapp.exception.InvalidNoteStateException;
import com.fundoo.fundooapp.exception.NoteNotFoundException;
import com.fundoo.fundooapp.repository.NoteRepository;
import com.fundoo.fundooapp.repository.UserRepository;
import com.fundoo.fundooapp.specification.NoteSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.fundoo.fundooapp.jms.ReminderProducer;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final ReminderProducer reminderProducer;

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
    @Override
    public NoteResponse pinUnpinNote(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        if (note.isDeleted()) {
            throw new InvalidNoteStateException("Cannot pin a trashed note");
        }

        note.setPined(!note.isPined());
        return toResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponse archiveNote(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        if (note.isDeleted()) {
            throw new InvalidNoteStateException("Cannot archive a trashed note");
        }

        note.setArchived(!note.isArchived());
        note.setPined(false); // archiving un-pins, same reasoning as trashing
        return toResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponse trashNote(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        note.setDeleted(true);
        note.setPined(false);   // business rule: trashing auto-unpins
        note.setArchived(false);
        return toResponse(noteRepository.save(note));
    }

    @Override
    public void deleteForever(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        noteRepository.delete(note); // real hard delete, distinct from trashNote
    }

    @Override
    public List<NoteResponse> getArchiveList(String email) {
        User owner = getUserByEmail(email);
        return noteRepository.findByOwnerAndIsArchivedTrueAndIsDeletedFalse(owner)
                .stream().map(this::toResponse).toList();
    }

    @Override
    public List<NoteResponse> getTrashList(String email) {
        User owner = getUserByEmail(email);
        return noteRepository.findByOwnerAndIsDeletedTrue(owner)
                .stream().map(this::toResponse).toList();
    }

    @Override
    public List<NoteResponse> searchNotes(String email, String titleText, String state, String labelName) {
        User owner = getUserByEmail(email);
        Specification<Note> spec = NoteSpecification.search(owner, titleText, state, labelName);
        return noteRepository.findAll(spec)
                .stream().map(this::toResponse).toList();
    }

    @Override
    public List<NoteResponse> getNotesByLabel(String email, String labelName) {
        User owner = getUserByEmail(email);
        Specification<Note> spec = NoteSpecification.search(owner, null, null, labelName);
        return noteRepository.findAll(spec)
                .stream().map(this::toResponse).toList();
    }
    @Override
    public NoteResponse addUpdateReminder(String email, int noteId, ReminderRequest req) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        note.getReminders().add(req.getReminderTime());
        Note saved = noteRepository.save(note);

        // fire-and-forget -- returns to the client instantly, real "processing" happens async
        reminderProducer.sendReminder(new ReminderMessage(noteId, email, req.getReminderTime()));

        return toResponse(saved);
    }

    @Override
    public NoteResponse removeReminder(String email, int noteId, LocalDateTime reminderTime) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        note.getReminders().remove(reminderTime); // actually removed, not just flagged inactive
        Note saved = noteRepository.save(note);
        return toResponse(saved);
    }

    @Override
    public List<LocalDateTime> getReminderList(String email, int noteId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
        return note.getReminders();
    }
}