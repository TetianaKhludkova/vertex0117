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
//todo: this constructor shouldn't exist, since this point would be valuable only if we'd like to point to the coordinates origin
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x:"+ x + " y:" + y;
    }
}
