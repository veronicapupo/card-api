package com.amefastforward.cardapi.exception;

import javax.swing.text.html.parser.Entity;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
