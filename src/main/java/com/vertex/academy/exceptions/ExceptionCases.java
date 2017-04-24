package com.vertex.academy.exceptions;

/**
 * Created by sweet_home on 18.02.17.
 */
public class ExceptionCases {

    public Object myMethod() {
        try (ClosableResource closableResource = new ClosableResource()) {
            System.out.println("in try");
        }


        return null;
    }

    public static void main(String[] args) {
        ExceptionCases cases = new ExceptionCases();
        cases.myMethod();
        System.out.println("After method call");
    }

}
