package com.vertex.academy.homework1;

import java.util.Random;


public class Circle implements Figure {

    private double radius;
    private Point point;





    private Circle() {
    }


    @Override
    public String toString() {
        return "{" +
                "radius=" + radius +
                ", point=" + point.toString() +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Circle" + toString());
    }

    @Override
    public void movePoint(int x, int y) {
        this.point = point.move(x, y);

    }

    @Override
    public void resizeFigure(double scale) {
        radius *= scale;
    }


    public static class Builder {


        private Circle circle;

        public Builder() {
            circle = new Circle();
        }



        public Builder setPoint(Point point){
            circle.point=point;
            return this;
        }

        public Builder setRadius(double radius){
            circle.radius=radius;
            return this;
        }


        public Figure build() {
            return circle;
        }

    }
}
