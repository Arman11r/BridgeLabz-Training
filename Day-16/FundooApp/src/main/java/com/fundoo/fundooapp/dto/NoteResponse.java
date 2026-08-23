package com.fundoo.fundooapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteResponse {
    private int noteId;
    private String title;
    private String description;
    private boolean isPined;
    private boolean isArchived;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;
}