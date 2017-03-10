package com.vertex.academy.homework3.Exceptions;

/**
 * Created by Tanya on 10.03.2017.
 */
public class LackOfBroochesException extends Exception {

    public LackOfBroochesException() {
        super("Not enough brooches exception");
    }

    public LackOfBroochesException(String message) {
        super(message);
    }

}
