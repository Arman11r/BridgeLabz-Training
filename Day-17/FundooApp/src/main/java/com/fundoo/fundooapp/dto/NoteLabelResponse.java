package com.fundoo.fundooapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteLabelResponse {
    private int id;
    private String label;
}