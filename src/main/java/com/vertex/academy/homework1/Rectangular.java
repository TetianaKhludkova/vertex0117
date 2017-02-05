package com.vertex.academy.homework1;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */
public class Rectangular implements Figure {

    // TODO: 05.02.17 should be private
    protected int h;
    protected int w;
    protected Point point;

    // TODO: 05.02.17 should be private
    Rectangular() {

    }

    // TODO: 05.02.17 should be deleted since unused!
    Rectangular(Point point, int h, int w) {
        this.point=point;
        this.h=h;
        this.w=w;
        System.out.println("Rectangular");
    }

    @Override
    public Point getPoint() {
        return this.point;
    }

    @Override
    public int getH() {
        return this.h;
    }

    @Override
    public int getW() {
        return this.w;
    }
// TODO: 05.02.17 isn't it enough to name a class as Builder and you've decided to write a comment?
    // Builder

    public static class Builder {
        Rectangular instance;

        Builder() {
            instance = new Rectangular();
        }

        Builder setPoint(Point point) {
            instance.point=point;
            return this;
        }

        Builder setH(int H) {
            instance.h=H;
            return this;
        }

        Builder setW(int W) {
            instance.w=W;
            return this;
        }

        Rectangular getInstance() {
            return instance;
        }
    }

}
