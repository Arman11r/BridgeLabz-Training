package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.NoteLabelRequest;
import com.fundoo.fundooapp.dto.NoteLabelResponse;
import com.fundoo.fundooapp.entity.Note;
import com.fundoo.fundooapp.entity.NoteLabel;
import com.fundoo.fundooapp.entity.User;
import com.fundoo.fundooapp.exception.DuplicateLabelException;
import com.fundoo.fundooapp.exception.LabelNotFoundException;
import com.fundoo.fundooapp.exception.NoteNotFoundException;
import com.fundoo.fundooapp.repository.NoteLabelRepository;
import com.fundoo.fundooapp.repository.NoteRepository;
import com.fundoo.fundooapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteLabelServiceImpl implements NoteLabelService {

    private final NoteLabelRepository noteLabelRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public NoteLabelResponse createLabel(String email, NoteLabelRequest req) {
        User owner = getUserByEmail(email);

        if (noteLabelRepository.existsByLabelAndOwnerAndIsDeletedFalse(req.getLabel(), owner)) {
            throw new DuplicateLabelException(req.getLabel());
        }

        NoteLabel label = new NoteLabel();
        label.setLabel(req.getLabel());
        label.setOwner(owner);

        NoteLabel saved = noteLabelRepository.save(label);
        return new NoteLabelResponse(saved.getId(), saved.getLabel());
    }

    @Override
    public NoteLabelResponse updateLabel(String email, int id, NoteLabelRequest req) {
        User owner = getUserByEmail(email);
        NoteLabel label = noteLabelRepository.findByIdAndOwner(id, owner)
                .orElseThrow(() -> new LabelNotFoundException(id));

        label.setLabel(req.getLabel());
        NoteLabel updated = noteLabelRepository.save(label);
        return new NoteLabelResponse(updated.getId(), updated.getLabel());
    }

    @Override
    public void deleteLabel(String email, int id) {
        User owner = getUserByEmail(email);
        NoteLabel label = noteLabelRepository.findByIdAndOwner(id, owner)
                .orElseThrow(() -> new LabelNotFoundException(id));

        label.setDeleted(true); // soft delete
        noteLabelRepository.save(label);
    }

    @Override
    public List<NoteLabelResponse> getLabelList(String email) {
        User owner = getUserByEmail(email);
        return noteLabelRepository.findByOwnerAndIsDeletedFalse(owner)
                .stream()
                .map(l -> new NoteLabelResponse(l.getId(), l.getLabel()))
                .toList();
    }

    @Override
    public void addLabelToNote(String email, int noteId, int labelId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
        NoteLabel label = noteLabelRepository.findByIdAndOwner(labelId, owner)
                .orElseThrow(() -> new LabelNotFoundException(labelId));

        note.getLabels().add(label);
        noteRepository.save(note);
    }

    @Override
    public void removeLabelFromNote(String email, int noteId, int labelId) {
        User owner = getUserByEmail(email);
        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
        NoteLabel label = noteLabelRepository.findByIdAndOwner(labelId, owner)
                .orElseThrow(() -> new LabelNotFoundException(labelId));

        note.getLabels().remove(label);
        noteRepository.save(note);
    }
}