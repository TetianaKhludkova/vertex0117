package com.vertex.academy.homework1;

/**
 * Created by andrew_yashin on 1/22/17.
 */

/** Тоже самое что и с кругом.
 * Квадрат = прямоугольник с одинаковыми сторонами.
 */
// TODO: 05.02.17 nice job, but change wrapping mindset and fix couple of small remarks in todos over the code
public class Square implements Figure {
    private Rectangular rectangular;

    public Square(double X, double Y, double length){
        this.rectangular = new Rectangular.RectangularBuilder()
                .setHeight(length)
                .setLength(length)
                .setLeftDownPoint(X,Y)
                .getFigure();
    }

    public double getLength(){
        return rectangular.getLength();
    }

    public Point getPoint(){
        return rectangular.getPoint();
    }

    @Override
    public String toString() {
        return " -- " +getClass().getSimpleName() + "\n"
                + " - Height\\Length = " + rectangular.getLength() + "\n"
                + " - LeftDownAnglePoint = " + rectangular.getPoint() + "\n\n";
    }
}
