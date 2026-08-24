package com.fundoo.fundooapp.controller;

import com.fundoo.fundooapp.dto.NoteRequest;
import com.fundoo.fundooapp.dto.NoteResponse;
import com.fundoo.fundooapp.dto.ReminderRequest;
import com.fundoo.fundooapp.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @PostMapping("/pinUnpinNotes/{noteId}")
    public ResponseEntity<NoteResponse> pinUnpin(Authentication auth, @PathVariable int noteId) {
        return ResponseEntity.ok(noteService.pinUnpinNote(auth.getName(), noteId));
    }

    @PostMapping("/archiveNotes/{noteId}")
    public ResponseEntity<NoteResponse> archive(Authentication auth, @PathVariable int noteId) {
        return ResponseEntity.ok(noteService.archiveNote(auth.getName(), noteId));
    }

    @PostMapping("/trashNotes/{noteId}")
    public ResponseEntity<NoteResponse> trash(Authentication auth, @PathVariable int noteId) {
        return ResponseEntity.ok(noteService.trashNote(auth.getName(), noteId));
    }

    @DeleteMapping("/deleteForeverNotes/{noteId}")
    public ResponseEntity<Void> deleteForever(Authentication auth, @PathVariable int noteId) {
        noteService.deleteForever(auth.getName(), noteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getArchiveNotesList")
    public ResponseEntity<List<NoteResponse>> archiveList(Authentication auth) {
        return ResponseEntity.ok(noteService.getArchiveList(auth.getName()));
    }

    @GetMapping("/getTrashNotesList")
    public ResponseEntity<List<NoteResponse>> trashList(Authentication auth) {
        return ResponseEntity.ok(noteService.getTrashList(auth.getName()));
    }

    @GetMapping("/search")
    public ResponseEntity<List<NoteResponse>> search(Authentication auth,
                                                     @RequestParam(required = false) String title,
                                                     @RequestParam(required = false) String state,
                                                     @RequestParam(required = false) String label) {
        return ResponseEntity.ok(noteService.searchNotes(auth.getName(), title, state, label));
    }

    @GetMapping("/getNotesListByLabel/{labelName}")
    public ResponseEntity<List<NoteResponse>> byLabel(Authentication auth, @PathVariable String labelName) {
        return ResponseEntity.ok(noteService.getNotesByLabel(auth.getName(), labelName));
    }
    @PostMapping("/addUpdateReminderNotes/{noteId}")
    public ResponseEntity<NoteResponse> addReminder(Authentication auth, @PathVariable int noteId,
                                                    @Valid @RequestBody ReminderRequest req) {
        return ResponseEntity.ok(noteService.addUpdateReminder(auth.getName(), noteId, req));
    }

    @PostMapping("/removeReminderNotes/{noteId}")
    public ResponseEntity<NoteResponse> removeReminder(Authentication auth, @PathVariable int noteId,
                                                       @RequestParam LocalDateTime reminderTime) {
        return ResponseEntity.ok(noteService.removeReminder(auth.getName(), noteId, reminderTime));
    }

    @GetMapping("/getReminderNotesList/{noteId}")
    public ResponseEntity<List<LocalDateTime>> getReminders(Authentication auth, @PathVariable int noteId) {
        return ResponseEntity.ok(noteService.getReminderList(auth.getName(), noteId));
    }
}