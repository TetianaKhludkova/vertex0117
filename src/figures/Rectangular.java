package figures;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class Rectangular implements Figure{
    private Point leftDownAngle;
    private double length;
    private double height;

    private Rectangular() {}

    public double getLength() {
        return length;
    }

    public Point getPoint(){
        return leftDownAngle;
    }

    public double getHeight(){
        return height;
    }

    public static class RectangularBuilder {
        private Rectangular figure;

        public RectangularBuilder() { figure = new Rectangular(); }

        public RectangularBuilder setLeftDownPoint(double X, double Y){
            figure.leftDownAngle = new Point(X,Y);
            return this;
        }

        public RectangularBuilder setLength(double length){
            figure.length = length;
            return this;
        }

        public RectangularBuilder setHeight(double height){
            figure.height = height;
            return this;
        }

        public Rectangular getFigure(){
            return figure;
        }
    }

    @Override
    public String toString() {
        return " -- " +getClass().getSimpleName() + "\n"
                + " - Height = " + height + "\n"
                + " - Length = " + length+ "\n"
                + " - LeftDownAnglePoint = " + leftDownAngle + "\n\n";
    }
}
