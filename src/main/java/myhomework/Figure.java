package myhomework;

/**
 * Created by Valery on 1/27/2017.
 */
public interface Figure {

    //todo: don't you see warning on 'public' word? It means that it is unnecessary here
    //done
    void moveTo(int newX, int newY);

    void translateX(int dX);

    void translateY(int dY);

    void resizeXDimension(int xDimension) throws IllegalArgumentException;

    void resizeYDimension(int yDimension) throws IllegalArgumentException;

    String dimensionsToString();

    int leftBorder();

    int rightBorder();

    int topBorder();

    int bottomBorder();

}
