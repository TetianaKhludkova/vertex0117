package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public interface Figure {

    public void moveTo(int newX, int newY);

    public void resizeXDimension(int xDimension) throws IllegalArgumentException;

    public void resizeYDimension(int yDimension) throws IllegalArgumentException;

    public String dimensionsToString();

}
