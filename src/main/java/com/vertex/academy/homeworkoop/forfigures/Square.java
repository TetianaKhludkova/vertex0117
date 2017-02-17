package com.vertex.academy.homeworkoop.forfigures;

import com.vertex.academy.homeworkoop.Point;

/**
 * Created by Valery on 1/27/2017.
 */
public class Square implements Figure {
    //todo: nice name!
    //done
    private Point leftBottomCorner;
    private int width;

    //todo: All the same as Circle
    //done
    private Square() {
    }

    @Override
    public String toString() {
        return "Square{" +
                dimensionsToString() +
                '}';
    }

    @Override
    public void moveTo(int newX, int newY) {
        leftBottomCorner = new Point(newX, newY);
    }

    @Override
    public void translateX(int dX) {
        leftBottomCorner = new Point(leftBottomCorner.getX() + dX, leftBottomCorner.getY());
    }

    @Override
    public void translateY(int dY) {
        leftBottomCorner = new Point(leftBottomCorner.getX(), leftBottomCorner.getY() + dY);
    }

    @Override
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        if(xDimension > 0) {
            width = xDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative");
        }
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            width = yDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative");
        }
    }

    @Override
    public String dimensionsToString() {
        return "leftBottomCorner=" + leftBottomCorner +
                "; width=" + width;
    }

    @Override
    public int leftBorder() {
        return leftBottomCorner.getX();
    }

    @Override
    public int rightBorder() {
        return leftBottomCorner.getX() + width;
    }

    @Override
    public int topBorder() {
        return leftBottomCorner.getY() + width;
    }

    @Override
    public int bottomBorder() {
        return leftBottomCorner.getY();
    }

    public Point getCorner() {
        return new Point(leftBottomCorner.getX(), leftBottomCorner.getY());
    }

    public static class Builder {
        private Square instanse;

        public Builder() {
            instanse = new Square();
            instanse.leftBottomCorner = new Point(0, 0);
        }

        public Square Build() {
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
    }

}
