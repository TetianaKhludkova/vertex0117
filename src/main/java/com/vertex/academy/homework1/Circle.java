package com.vertex.academy.homework1;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */
public class Circle extends Oval implements Figure
{
    Circle() {

    }

    Circle(Point point, int h) {
        super(point,h,h);
        System.out.println("Circle");
    }

    // Builder

    public static class Builder {
        Circle instance;

        Builder() {
            instance = new Circle();
        }

        Builder setPoint(Point point) {
            instance.point=point;
            return this;
        }

        Builder setH(int H) {
            instance.h=H;
            instance.w=H;
            return this;
        }

        Circle getInstance() {
            return instance;
        }
    }
}
