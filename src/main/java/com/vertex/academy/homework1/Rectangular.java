package com.vertex.academy.homework1;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */
public class Rectangular implements Figure {
    protected int h;
    protected int w;
    protected Point point;

    Rectangular() {

    }

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
