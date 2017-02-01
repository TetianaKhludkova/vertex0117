package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public interface Figure {

    //todo: don't you see warning on 'public' word? It means that it is unnecessary here
    public void moveTo(int newX, int newY);

    public void translateX(int dX);

    public void translateY(int dY);

    public void resizeXDimension(int xDimension) throws IllegalArgumentException;

    public void resizeYDimension(int yDimension) throws IllegalArgumentException;

    public String dimensionsToString();

    public int leftBorder();

    public int rightBorder();

    public int topBorder();

    public int bottomBorder();

}
