package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class Oval implements Figure {

    private Circle circle;
    private int yRadius;

    public Oval() {
        circle = new Circle();
        yRadius = 1;
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
    public void resizeXDimension(int xDimension) throws IllegalArgumentException {
        if(xDimension > 0) {
            circle.resizeXDimension(xDimension);
        } else {
            throw new IllegalArgumentException("Width cannot be negative for Rectangular");
        }
    }

    @Override
    public void resizeYDimension(int yDimension) throws IllegalArgumentException {
        if(yDimension > 0) {
            yRadius = yDimension;
        } else {
            throw new IllegalArgumentException("Width cannot be negative for Rectangular");
        }
    }

    @Override
    public String dimensionsToString() {
        return circle.dimensionsToString() +
                "; yRadius=" + yRadius;
    }

    public static class Builder {
        private int centerX, centerY;
        private Oval instanse;

        public Builder() {
            instanse = new Oval();
        }

        public Oval Build() {
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
