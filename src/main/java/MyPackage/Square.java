package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class Square implements Figure {
    private Point leftBottomPoint;
    private int width;

    public Square() {
        leftBottomPoint = new Point();
        width = 1;
    }

    @Override
    public String toString() {
        return "Square{" +
                dimensionsToString() +
                '}';
    }

    @Override
    public void moveTo(int newX, int newY) {
        leftBottomPoint = new Point(newX, newY);
    }

    @Override
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        if(xDimension > 0) {
            width = xDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative for Square");
        }
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            width = yDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative for Square");
        }
    }

    @Override
    public String dimensionsToString() {
        return "leftBottomPoint=" + leftBottomPoint +
                "; width=" + width;
    }

    public static class Builder {
        private int centerX, centerY;
        private Square instanse;

        public Builder() {
            instanse = new Square();
        }

        public Square Build() {
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

        public Builder setWidth(int width) {
            instanse.resizeXDimension(width);
            return this;
        }
    }

}
