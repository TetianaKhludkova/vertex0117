package com.vertex.academy.homework1;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */
// TODO: 05.02.17 it should not extend Oval, it should be a wrapper for it!
public class Circle extends Oval implements Figure
{
    // TODO: 05.02.17 should be private
    Circle() {

    }

    // TODO: 05.02.17 should be deleted
    Circle(Point point, int h) {
        super(point,h,h);
        System.out.println("Circle");
    }

    // TODO: 05.02.17 should be deleted
    // Builder

    public static class Builder {
        // TODO: 05.02.17 should be private
        Circle instance;

        // TODO: 05.02.17 should be public and all methods in Builder
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
