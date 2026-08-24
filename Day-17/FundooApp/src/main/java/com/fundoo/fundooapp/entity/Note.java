package com.fundoo.fundooapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    private String title;

    @Column(length = 2000)
    private String description;

    private boolean isPined = false;
    private boolean isArchived = false;
    private boolean isDeleted = false;

    private String color;
    private String typeOfNote; // TEXT, CHECKLIST, IMAGE, LINK

    private String imageUrl;
    private String linkUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "note_note_labels",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<NoteLabel> labels = new HashSet<>();
    @ElementCollection
    private List<LocalDateTime> reminders = new ArrayList<>();
}