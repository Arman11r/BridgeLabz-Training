package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.NoteRequest;
import com.fundoo.fundooapp.dto.NoteResponse;
import com.fundoo.fundooapp.dto.ReminderRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteService {
    NoteResponse createNote(String email, NoteRequest req);
    List<NoteResponse> getAllNotes(String email);
    NoteResponse getNoteById(String email, int noteId);
    NoteResponse updateNote(String email, int noteId, NoteRequest req);
    void deleteNote(String email, int noteId);
    NoteResponse pinUnpinNote(String email, int noteId);
    NoteResponse archiveNote(String email, int noteId);
    NoteResponse trashNote(String email, int noteId);
    void deleteForever(String email, int noteId);
    List<NoteResponse> getArchiveList(String email);
    List<NoteResponse> getTrashList(String email);
    List<NoteResponse> searchNotes(String email, String titleText, String state, String labelName);
    List<NoteResponse> getNotesByLabel(String email, String labelName);
    NoteResponse addUpdateReminder(String email, int noteId, ReminderRequest req);
    NoteResponse removeReminder(String email, int noteId, LocalDateTime reminderTime);
    List<LocalDateTime> getReminderList(String email, int noteId);
}