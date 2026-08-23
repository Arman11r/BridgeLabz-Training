package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.NoteRequest;
import com.fundoo.fundooapp.dto.NoteResponse;

import java.util.List;

public interface NoteService {
    NoteResponse createNote(String email, NoteRequest req);
    List<NoteResponse> getAllNotes(String email);
    NoteResponse getNoteById(String email, int noteId);
    NoteResponse updateNote(String email, int noteId, NoteRequest req);
    void deleteNote(String email, int noteId);
}