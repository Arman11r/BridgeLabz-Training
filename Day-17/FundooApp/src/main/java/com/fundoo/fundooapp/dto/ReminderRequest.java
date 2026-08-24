package com.fundoo.fundooapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderRequest {
    @NotNull(message = "Reminder time is required")
    private LocalDateTime reminderTime;
}