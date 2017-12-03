package com.sens.try002.exception;

/**
 * Created by Sensible on 29.11.2017.
 */
public class EmailExistsException extends Exception {

    public EmailExistsException(String message) {
        super(message);
    }
}
