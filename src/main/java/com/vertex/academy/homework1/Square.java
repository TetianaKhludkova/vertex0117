package com.vertex.academy.homework1;

import java.util.Random;

/**
 * Created by a on 25.01.17.
 */

public class Square implements Figure {

    private double side;
    private Point point;





    private Square() {
    }


    @Override
    public String toString() {
        return "{" +
                "side=" + side +
                ", point=" + point +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Square:" + toString());
    }

    @Override
    public void movePoint(int x, int y) {
        this.point = point.move(x, y);

    }

    @Override
    public void resizeFigure(double scale) {
        side *= scale;
    }


    public static class Builder {


       private Square square;

        public Builder() {
            square = new Square();
        }

        public Builder setPoint(Point point){
            square.point=point;
            return this;
        }

        public Builder setSide(int side){
           square.side=side;
            return this;
        }



        public Figure build() {
            return square;
        }

    }
}
