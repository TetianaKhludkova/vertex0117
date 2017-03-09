package com.vertex.academy.homework3.exceptions;

/**
 * Created by andrew_yashin on 3/9/17.
 */
public class LackOfBroochesException extends Exception {

    public LackOfBroochesException() {
        super("sorry, lack of brooches");
    }

    public LackOfBroochesException(String message) {
        super(message);
    }
}
