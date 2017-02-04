package com.vertex.academy.myhomework;

/**
 * Created by Valery on 1/27/2017.
 */
public class Oval implements Figure {

    private Circle circle;
    private int yRadius;

    //todo: the same here, should be private and with no initialization.
    //done
    private Oval() {
    }

    @Override
    public String toString() {
        return "Oval{" +
                dimensionsToString() +
                '}';
    }

    @Override
    public void moveTo(int newX, int newY) {
        circle.moveTo(newX,  newY);
    }

    @Override
    public void translateX(int dX) {
        circle.translateX(dX);
    }

    @Override
    public void translateY(int dY) {
        circle.translateY(dY);
    }

    @Override
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        //todo: I'm pretty sure that no if is needed here. This check would be done in circle.
        //done
        circle.resizeXDimension(xDimension);
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            yRadius = yDimension / 2;
        } else {
            throw new IllegalArgumentException("Width cannot be negative");
        }
    }

    @Override
    public String dimensionsToString() {
        return circle.dimensionsToString() +
                "; yRadius=" + yRadius;
    }

    @Override
    public int leftBorder() {
        return circle.leftBorder();
    }

    @Override
    public int rightBorder() {
        return circle.rightBorder();
    }

    //todo: what about circle.getCenter.getY instead of (circle.bottomBorder() + circle.topBorder()) / 2 ?
    //done
    @Override
    public int topBorder() {
        return circle.getCenter().getY() + yRadius;
    }

    @Override
    public int bottomBorder() {
        return circle.getCenter().getY() - yRadius;
    }

    public Point getCenter() {
        return circle.getCenter();
    }

    //todo: the same as a circle's Builder
    //done
    public static class Builder {
        private Oval instanse;

        public Builder() {
            instanse = new Oval();
            instanse.circle = new Circle.Builder().Build();
        }

        public Oval Build() {
            return instanse;
        }

        public Builder setCenter(Point center) {
            instanse.moveTo(center.getX(), center.getY());
            return this;
        }

        public Builder setXRadius(int xRadius) {
            instanse.resizeXDimension(xRadius);
            return this;
        }

        public Builder setYRadius(int yRadius) {
            instanse.resizeYDimension(yRadius);
            return this;
        }
    }

}
