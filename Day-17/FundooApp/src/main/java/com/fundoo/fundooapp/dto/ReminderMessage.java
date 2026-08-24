package com.fundoo.fundooapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReminderMessage implements Serializable {
    private int noteId;
    private String userEmail;
    private LocalDateTime reminderTime;
}