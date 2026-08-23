package com.fundoo.fundooapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;
}