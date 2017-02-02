package com.vertex.academy.homework1;

import java.util.Random;

/**
 * Decorates Circle
 */
public class Ellipse extends FigureDecorator {


    public Ellipse(Figure figure) {
        super(figure);
    }

    @Override
    public void draw() {
        System.out.println("Ellipse:" + toString());
    }
}
