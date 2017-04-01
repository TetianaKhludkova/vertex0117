package com.vertex.academy.homework1;

/**
 * Created by andrew_yashin on 1/22/17.
 */
// TODO: 05.02.17 also should be final to avoid overriding
public final class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point changeX(double x){
        return new Point(x, this.getY());
    }

    public Point changeY(double y){
        return new Point(this.getX(), y);
    }

    public Point changeXAndY(double x, double y){
        return new Point(x,y);
    }

    public Point addToX(double addX){
        return new Point(this.getX() + addX, this.getY());
    }

    public Point addToY(double addY){
        return new Point(this.getX(), this.getY() + addY);
    }

    public Point addToXAndY(double addX, double addY){
        return new Point(this.getX() + addX, this.getY() + addY);
    }

    @Override
    public String toString() {
        return "[" + x + " , " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
