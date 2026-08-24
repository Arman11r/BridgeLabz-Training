package com.fundoo.fundooapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteLabelRequest {
    @NotBlank(message = "Label is required")
    private String label;
}