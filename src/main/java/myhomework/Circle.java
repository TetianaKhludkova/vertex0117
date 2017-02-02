package myhomework;

/**
 * Created by Valery on 1/27/2017.
 */
public class Circle implements Figure {
    private Point center;
    private int radius;

    //todo: this constructor should be private and should not initialize variables.
    //done
    private Circle() {
    }

    @Override
    public String toString() {
        return "Circle{" +
                dimensionsToString() +
                '}';
    }

    @Override
    public void moveTo(int newX, int newY) {
        center = new Point(newX, newY);
    }

    @Override
    public void translateX(int dX) {
        center = new Point(center.getX() + dX, center.getY());
    }

    @Override
    public void translateY(int dY) {
        center = new Point(center.getX(), center.getY() + dY);
    }

    @Override
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        if(xDimension > 0) {
            radius = xDimension / 2;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            radius = yDimension / 2;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    @Override
    public String dimensionsToString() {
        return "center=" + center +
                "; radius=" + radius;
    }

    @Override
    public int leftBorder() {
        return center.getX() - radius;
    }

    @Override
    public int rightBorder() {
        return center.getX() + radius;
    }

    @Override
    public int topBorder() {
        return center.getY() + radius;
    }

    @Override
    public int bottomBorder() {
        return center.getY() - radius;
    }

    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    public static class Builder {
        private Circle instanse;

        public Builder() {
            instanse = new Circle();
            instanse.center = new Point(0, 0);
        }

        public Circle Build() {
            //todo: nice approach but probably figure should be moved in setX/Y methods. Then you could avoid of using additional vars.
            //done
            return instanse;
        }

        //todo: moreover, I think that you should combine them into one method like - getCenter(Point center).
        // Since you are producing inconsistent data while setting only X or Y
        //done
        public Builder setCenter(Point center) {
            instanse.moveTo(center.getX(), center.getY());
            return this;
        }

        public Builder setRadius(int radius) {
            instanse.resizeXDimension(radius);
            return this;
        }

    }
}
