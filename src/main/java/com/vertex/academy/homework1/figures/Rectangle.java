package com.vertex.academy.homework1.figures;

import com.vertex.academy.homework1.Figure;
import com.vertex.academy.homework1.FigureDecorator;

/**
 * Decorates Square
 */
public class Rectangle extends FigureDecorator {

    public Rectangle(Figure figure) {
        super(figure);
    }


    @Override
    public void draw() {
        System.out.println("Rectangle:" + toString());

    }
}
