package figures;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class Point {
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
}
