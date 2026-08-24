package com.fundoo.fundooapp.exception;

public class LabelNotFoundException extends RuntimeException {
    public LabelNotFoundException(int id) {
        super("Label not found with id: " + id);
    }
}