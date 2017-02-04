import java.util.ArrayList;
import java.util.Random;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */
public class Artist
{

    int amount = 20;
    private ArrayList<Figure> figures = new ArrayList<Figure>();

    Random random = new Random();

    Artist()
    {
        this.createFigures();
    }

    public void paint()
    {
        for (int i=0;i<figures.size();i++)
        {
            Cloth.paintedFigures.add(figures.get(0));
            figures.remove(0);
            System.out.println("Paint "Cloth.paintedFigures.get(i).getClass().getName()+" with point in x = "+Cloth.paintedFigures.get(i).getPoint().getX()+" and y = "+Cloth.paintedFigures.get(i).getPoint().getY()+" width = "+Cloth.paintedFigures.get(i).getW()+ " height = "+Cloth.paintedFigures.get(i).getH());
        }
    }
    public void createFigures()
    {
        for(int i=0;i<amount;i++)
        {
            Point point = new Point();

            int randomNumber = random.nextInt(4);
            switch (randomNumber)
            {
                case 0:
                {
                    Rectangular rectangular = new Rectangular.Builder()
                            .setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .setW(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(rectangular);
                }
                case 1:
                {
                    Oval oval = new Oval.Builder().setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .setW(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(oval);
                }
                case 2:
                {
                    Circle circle = new Circle.Builder()
                            .setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(circle);
                }
                case 3:
                {
                    Square square = new Square.Builder()
                            .setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(square);
                }
            }
        }
    }
}
