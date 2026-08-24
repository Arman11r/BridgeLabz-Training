package com.fundoo.fundooapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "note_labels")
@Data
public class NoteLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;
    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}