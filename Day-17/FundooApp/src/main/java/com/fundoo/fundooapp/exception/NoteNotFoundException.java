package com.fundoo.fundooapp.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(int noteId) {
        super("Note not found with id: " + noteId);
    }
}