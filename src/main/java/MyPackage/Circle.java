package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class Circle implements Figure {
    private Point center;
    private int radius;

    public Circle() {
        center = new Point();
        radius = 1;
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
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        if(xDimension > 0) {
            radius = xDimension;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative for Circle");
        }
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            radius = yDimension;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative for Circle");
        }
    }

    @Override
    public String dimensionsToString() {
        return "center=" + center +
                "; radius=" + radius;
    }

    public static class Builder {
        private int centerX, centerY;
        private Circle instanse;

        public Builder() {
            instanse = new Circle();
        }

        public Circle Build() {
            instanse.moveTo(this.centerX, this.centerY);
            return instanse;
        }

        public Builder setCenterX(int x) {
            this.centerX = x;
            return this;
        }

        public Builder setCenterY(int y) {
            this.centerY = y;
            return this;
        }

        public Builder setRadius(int radius) {
            instanse.resizeXDimension(radius);
            return this;
        }

    }
}
