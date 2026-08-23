package com.fundoo.fundooapp.controller;

import com.fundoo.fundooapp.dto.NoteRequest;
import com.fundoo.fundooapp.dto.NoteResponse;
import com.fundoo.fundooapp.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/addNotes")
    public ResponseEntity<NoteResponse> addNote(Authentication auth, @Valid @RequestBody NoteRequest req) {
        String email = auth.getName();
        return ResponseEntity.status(201).body(noteService.createNote(email, req));
    }

    @GetMapping("/getNotesList")
    public ResponseEntity<List<NoteResponse>> getNotesList(Authentication auth) {
        return ResponseEntity.ok(noteService.getAllNotes(auth.getName()));
    }

    @GetMapping("/getNotesDetail/{noteId}")
    public ResponseEntity<NoteResponse> getNoteDetail(Authentication auth, @PathVariable int noteId) {
        return ResponseEntity.ok(noteService.getNoteById(auth.getName(), noteId));
    }

    @PostMapping("/updateNotes/{noteId}")
    public ResponseEntity<NoteResponse> updateNote(Authentication auth, @PathVariable int noteId,
                                                   @Valid @RequestBody NoteRequest req) {
        return ResponseEntity.ok(noteService.updateNote(auth.getName(), noteId, req));
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(Authentication auth, @PathVariable int noteId) {
        noteService.deleteNote(auth.getName(), noteId);
        return ResponseEntity.noContent().build();
    }
}