package com.vertex.academy.homework1;

import java.util.Objects;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */
public class Oval implements Figure {
    // TODO: 05.02.17 should be private
    protected int h;
    protected int w;
    protected Point point;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return h == oval.h &&
                w == oval.w &&
                Objects.equals(point, oval.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(h, w, point);
    }

    // TODO: 05.02.17 should be private
    Oval() {

    }

    Oval(Point point, int H, int W) {
        this.point=point;
        this.h=H;
        this.w=W;
        System.out.println("Oval");
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
        Oval instance;

        Builder() {
            instance = new Oval();
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

        Oval getInstance() {
            return instance;
        }
    }
//    todo: please delete it! and don't ever commit!
/*
    public static void main (String args[])
    {

        for(int i=0;i<20;i++)
        {
            Point point = new Point();
            Oval test = new Oval.Builder().setPoint(point).setH(10).setW(10).getInstance();
            System.out.println("Point x ="+test.getPoint().getX()+" y = "+test.getPoint().getY()+" H = "+test.getH()+" W = "+test.getW());
        }

    }
*/

}
