package com.vertex.academy.myhomework;

/**
 * Created by Valery on 1/27/2017.
 */
public class Rectangular implements Figure {
    private Square square;
    private int height;

    //todo: All the same as Oval
    //done
    private Rectangular() {
    }

    @Override
    public String toString() {
        return "Rectangular{" +
                dimensionsToString() +
                '}';
    }

    @Override
    public void moveTo(int newX, int newY) {
        square.moveTo(newX,  newY);
    }

    @Override
    public void translateX(int dX) {
        square.translateX(dX);
    }

    @Override
    public void translateY(int dY) {
        square.translateY(dY);
    }

    @Override
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        square.resizeXDimension(xDimension);
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            height = yDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative");
        }
    }

    @Override
    public String dimensionsToString() {
        return square.dimensionsToString() +
                "; height=" + height;
    }

    @Override
    public int leftBorder() {
        return square.leftBorder();
    }

    @Override
    public int rightBorder() {
        return square.rightBorder();
    }

    @Override
    public int topBorder() {
        return square.bottomBorder() + height;
    }

    @Override
    public int bottomBorder() {
        return square.bottomBorder();
    }

    public Point getCorner() {
        return square.getCorner();
    }

    public static class Builder {
        private Rectangular instanse;

        public Builder() {
            instanse = new Rectangular();
            instanse.square = new Square.Builder().Build();
        }

        public Rectangular Build() {
            return instanse;
        }

        public Builder setCorner(Point corner) {
            instanse.moveTo(corner.getX(), corner.getY());
            return this;
        }

        public Builder setWidth(int width) {
            instanse.resizeXDimension(width);
            return this;
        }

        public Builder setHeight(int height) {
            instanse.resizeYDimension(height);
            return this;
        }
    }

}
