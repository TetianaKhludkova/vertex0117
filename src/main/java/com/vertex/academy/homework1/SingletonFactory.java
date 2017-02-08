package com.vertex.academy.homework1;

import java.util.Random;

/**
 * Produces instances "turnkey" calling Builder for instantiation.
 */
public class SingletonFactory {

    private Random r = new Random();
    private static volatile SingletonFactory factory;

    private SingletonFactory() {
    }


    public static SingletonFactory getInstance() {
        if (factory == null) {
            synchronized (SingletonFactory.class) {
                if (factory == null) {

                    factory = new SingletonFactory();
                }
            }
        }

        return factory;
    }


    public Figure getFigure(FigureName shape) {
        switch (shape) {
            case CIRCLE:

                return new Circle.Builder().
                        setPoint(new Point(r.nextInt(100), r.nextInt(100))).
                        setRadius(r.nextDouble() * 100).
                        build();

            case OVAL:

                return new Ellipse(new Circle.Builder().setPoint(new Point(r.nextInt(100), r.nextInt(100))).
                        setRadius(r.nextDouble() * 100).
                        build());

            case SQUARE:

                return new Square.Builder().
                        setPoint(new Point(r.nextInt(100), r.nextInt(100))).
                        setSide(r.nextInt() * 100).
                        build();

            case RECTANGULAR:

                return new Rectangle(new Square.Builder().
                        setPoint(new Point(r.nextInt(100), r.nextInt(100))).
                        setSide(r.nextInt() * 100).
                        build());
        }

        throw new IllegalArgumentException("There is no such figure");
    }


    enum FigureName {
        CIRCLE, OVAL, SQUARE, RECTANGULAR
    }
}
