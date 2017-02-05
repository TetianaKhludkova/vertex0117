package com.vertex.academy.homework1;

/**
 * Decorates Circle
 */
public class Ellipse extends FigureDecorator {
// TODO: 05.02.17 where is builder for this figure? 

    public Ellipse(Figure figure) {
        super(figure);
    }

    @Override
    public void draw() {
        System.out.println("Ellipse:" + toString());
    }
}
