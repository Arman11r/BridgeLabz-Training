package com.fundoo.fundooapp.service;

import com.fundoo.fundooapp.dto.NoteLabelRequest;
import com.fundoo.fundooapp.dto.NoteLabelResponse;

import java.util.List;

public interface NoteLabelService {
    NoteLabelResponse createLabel(String email, NoteLabelRequest req);
    NoteLabelResponse updateLabel(String email, int id, NoteLabelRequest req);
    void deleteLabel(String email, int id);
    List<NoteLabelResponse> getLabelList(String email);
    void addLabelToNote(String email, int noteId, int labelId);
    void removeLabelFromNote(String email, int noteId, int labelId);
}