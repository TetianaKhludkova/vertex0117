package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class Point {

    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "x:"+ x + " y:" + y;
    }
}
