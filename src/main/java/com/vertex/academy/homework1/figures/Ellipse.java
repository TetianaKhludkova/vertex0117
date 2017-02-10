package com.vertex.academy.homework1.figures;

import com.vertex.academy.homework1.Figure;
import com.vertex.academy.homework1.FigureDecorator;

/**
 * Decorates Circle
 */
public class Ellipse extends FigureDecorator {
// TODO: 05.02.17 where is builder for this figure?
    // since it is a Decorator, it uses all the features Circle does, instantiating through the FigureDecorator pattern.
    //The only difference is the name in draw method, that is why it is overridden here

    public Ellipse(Figure figure) {
        super(figure);
    }

    @Override
    public void draw() {
        System.out.println("Ellipse:" + toString());
    }
}
