/*
 * Created by Michael Rudyy on 23.01.2017.
 */
public class Square extends Rectangular implements Figure
{

    Square()
    {

    }

    Square(Point point, int h)
    {
        super(point, h, h);
        System.out.println("Square");
    }

    // Builder

    public static class Builder
    {
        Square instance;

        Builder()
        {
            instance = new Square();
        }

        Square.Builder setPoint(Point point)
        {
            instance.point=point;
            return this;
        }

        Square.Builder setH(int H)
        {
            instance.w=H;
            instance.h=H;
            return this;
        }

        Square getInstance()
        {
            return instance;
        }
    }
}
