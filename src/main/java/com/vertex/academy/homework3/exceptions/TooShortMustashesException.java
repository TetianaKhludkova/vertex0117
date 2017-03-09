package com.vertex.academy.homework3.exceptions;

/**
 * Created by andrew_yashin on 3/9/17.
 */
public class TooShortMustashesException extends Exception {
    public TooShortMustashesException() {
        super("sorry, too short mustashes exception");
    }

    public TooShortMustashesException(String message) {
        super(message);
    }
}
