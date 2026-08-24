package com.fundoo.fundooapp.exception;

public class DuplicateLabelException extends RuntimeException {
    public DuplicateLabelException(String label) {
        super("Label already exists: " + label);
    }
}