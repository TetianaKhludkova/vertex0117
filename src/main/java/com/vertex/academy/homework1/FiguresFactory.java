package com.vertex.academy.homework1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class FiguresFactory {

    private static volatile FiguresFactory figuresFactory;

    private FiguresFactory(){}

    public static FiguresFactory getInstance(){
        if(figuresFactory == null){
            synchronized (FiguresFactory.class){
                if(figuresFactory == null)
                    figuresFactory = new FiguresFactory();
            }
        }

        return figuresFactory;
    }

    // TODO: 05.02.17 don't you like to set us some constants to be sure that you use right number in other part of code? 
    public Figure getFigure(int type){
        switch (type){
            case 1: return new Oval.Builder()
                    .setCenter(ThreadLocalRandom.current().nextDouble(0, 100),
                            ThreadLocalRandom.current().nextDouble(0, 100))
                    .setHeight(ThreadLocalRandom.current().nextDouble(0, 100))
                    .setLength(ThreadLocalRandom.current().nextDouble(0, 100))
                    .getFigure();

            case 2: return new Rectangular.RectangularBuilder()
                    .setHeight(ThreadLocalRandom.current().nextDouble(0, 100))
                    .setLength(ThreadLocalRandom.current().nextDouble(0, 100))
                    .setLeftDownPoint(ThreadLocalRandom.current().nextDouble(0, 100),
                            ThreadLocalRandom.current().nextDouble(0, 100))
                    .getFigure();

            case 3: return new Square(ThreadLocalRandom.current().nextDouble(0, 100),
                    ThreadLocalRandom.current().nextDouble(0, 100),
                    ThreadLocalRandom.current().nextDouble(0, 100));

            default: return new Circle(ThreadLocalRandom.current().nextDouble(0, 100),
                    ThreadLocalRandom.current().nextDouble(0, 100),
                    ThreadLocalRandom.current().nextDouble(0, 100));

        }
    }
}
