package com.vertex.academy.homework1;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class Oval implements Figure {
    private Point center;
    private double length;
    private double height;

    private Oval(){}

    //todo: why do you use different access levels for getters?
    public double getLength(){
        return length;
    }

    public double getHeight(){
        return height;
    }

    public Point getPoint(){
        return center;
    }

    public static class Builder {
        private Oval figure;

        public Builder() { figure = new Oval(); }

        public Builder setLength(double length){
            figure.length = length;
            return this;
        }

        public Builder setHeight(double height){
            figure.height = height;
            return this;
        }

        public Builder setCenter(double X, double Y){
            figure.center = new Point(X,Y);
            return this;
        }

        public Oval getFigure(){ return figure; }
    }

    @Override
    public String toString() {
        return " -- " + getClass().getSimpleName() + "\n"
                + " - Height = " + height + "\n"
                + " - Length = " + length + "\n"
                + " - Center = " + center + "\n\n";
    }
}
