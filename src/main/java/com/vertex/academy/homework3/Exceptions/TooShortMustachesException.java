package com.vertex.academy.homework3.Exceptions;

/**
 * Created by Tanya on 10.03.2017.
 */
public class TooShortMustachesException extends Exception {

    public TooShortMustachesException() {
        super("Not enough mustashes exception");
    }

    public TooShortMustachesException(String message) {
        super(message);
    }

}
