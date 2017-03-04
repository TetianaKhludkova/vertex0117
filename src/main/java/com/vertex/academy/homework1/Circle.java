package com.vertex.academy.homework1;

/**
 * Created by andrew_yashin on 1/22/17.
 */

/** Наверное лучше сделать обертку над кругом, потому что круг - это тот же овал
 * только с одинаковой высотой и шириной
 */

// тогда это будет не обвертка, а просто композиция ;)

public class Circle implements Figure{
    private Oval oval;

    //todo: where is Builder for Circle?
    public Circle(double X, double Y, double radius) {
        this.oval = new Oval.Builder()
                .setCenter(X,Y)
                .setHeight(radius)
                .setLength(radius)
                .getFigure();
    }

    public double getRadius(){
        return oval.getLength();
    }

    public Point getPoint(){
        return oval.getPoint();
    }

    @Override
    public String toString() {
        return " -- " + getClass().getSimpleName() + "\n"
                + " - Height\\Length = " + oval.getHeight() + "\n"
                + " - Center = " + oval.getPoint() + "\n\n";
    }

}
