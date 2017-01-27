package figures;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class Oval implements Figure{
    private Point center;
    private double length;
    private double height;

    private Oval(){}

    double getLength(){
        return length;
    }

    public double getHeight(){
        return height;
    }

    public Point getPoint(){
        return center;
    }

    public static class OvalBuilder{
        private Oval figure;

        public OvalBuilder() { figure = new Oval(); }

        public OvalBuilder setLength(double length){
            figure.length = length;
            return this;
        }

        public OvalBuilder setHeight(double height){
            figure.height = height;
            return this;
        }

        public OvalBuilder setCenter(double X, double Y){
            figure.center = new Point(X,Y);
            return this;
        }

        public Oval getFigure(){ return figure; }
    }

    @Override
    public String toString() {
        return " -- " + getClass().getSimpleName() + "\n"
                + " - Height = " + height + "\n"
                + " - Length = " + length + "\n"
                + " - Center = " + center + "\n\n";
    }
}
