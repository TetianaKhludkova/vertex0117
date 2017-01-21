package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class Rectangular implements Figure {
    private Square square;
    private int height;

    public Rectangular() {
        square = new Square();
        height = 1;
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
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        if(xDimension > 0) {
            square.resizeXDimension(xDimension);
        } else {
            throw new IllegalArgumentException("Width cannot be negative for Rectangular");
        }
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            height = yDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative for Rectangular");
        }
    }

    @Override
    public String dimensionsToString() {
        return square.dimensionsToString() +
                "; height=" + height;
    }

    public static class Builder {
        private int centerX, centerY;
        private Rectangular instanse;

        public Builder() {
            instanse = new Rectangular();
        }

        public Rectangular Build() {
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

        public Builder setHeight(int height) {
            instanse.resizeYDimension(height);
            return this;
        }
    }

}
