package com.fundoo.fundooapp.controller;

import com.fundoo.fundooapp.dto.NoteLabelRequest;
import com.fundoo.fundooapp.dto.NoteLabelResponse;
import com.fundoo.fundooapp.service.NoteLabelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoteLabelController {

    private final NoteLabelService noteLabelService;

    @PostMapping("/noteLabels")
    public ResponseEntity<NoteLabelResponse> create(Authentication auth, @Valid @RequestBody NoteLabelRequest req) {
        return ResponseEntity.status(201).body(noteLabelService.createLabel(auth.getName(), req));
    }

    @PatchMapping("/noteLabels/{id}")
    public ResponseEntity<NoteLabelResponse> update(Authentication auth, @PathVariable int id,
                                                    @Valid @RequestBody NoteLabelRequest req) {
        return ResponseEntity.ok(noteLabelService.updateLabel(auth.getName(), id, req));
    }

    @DeleteMapping("/noteLabels/{id}/deleteNoteLabel")
    public ResponseEntity<Void> delete(Authentication auth, @PathVariable int id) {
        noteLabelService.deleteLabel(auth.getName(), id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/noteLabels/getNoteLabelList")
    public ResponseEntity<List<NoteLabelResponse>> list(Authentication auth) {
        return ResponseEntity.ok(noteLabelService.getLabelList(auth.getName()));
    }

    @PostMapping("/notes/{noteId}/addLabelToNotes/{labelId}/add")
    public ResponseEntity<Void> addLabel(Authentication auth, @PathVariable int noteId, @PathVariable int labelId) {
        noteLabelService.addLabelToNote(auth.getName(), noteId, labelId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/notes/{noteId}/addLabelToNotes/{labelId}/remove")
    public ResponseEntity<Void> removeLabel(Authentication auth, @PathVariable int noteId, @PathVariable int labelId) {
        noteLabelService.removeLabelFromNote(auth.getName(), noteId, labelId);
        return ResponseEntity.ok().build();
    }
}