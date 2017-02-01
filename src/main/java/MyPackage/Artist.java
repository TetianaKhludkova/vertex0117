package MyPackage;

import java.util.*;

import static java.lang.String.format;

/**
 * Created by Valery on 1/27/2017.
 */
public class Artist {

    private ArrayList<Figure> figures;
//    todo: should be also static to be written in this way
    private final int INIT_QUANTITY;
    private Canvas canvas;

    private void Init() {

        String figureName = "";
        Random randomizer = new Random();
        int[] parameters = new int[4];

        for (int number = 0; number < INIT_QUANTITY; number++) {

            switch (randomizer.nextInt(4)) {
                case 0: figureName = "Square"; break;
                case 1: figureName = "Oval"; break;
                case 2: figureName = "Circle"; break;
                case 3: figureName = "Rectangular"; break;
            };
            parameters[0] = randomizer.nextInt(10000) - 5000;
            parameters[1] = randomizer.nextInt(10000) - 5000;
            parameters[2] = randomizer.nextInt(6000) + 1;
            parameters[3] = randomizer.nextInt(6000) + 1;
            figures.add(FigureFactory.getInstance().getFigure(figureName, parameters));

        }

    }

    //todo: please delete it
    public Artist() {
        figures = new ArrayList<Figure>(0);
        INIT_QUANTITY = 100;
        canvas = new Canvas(10, 10);
        Init();
    }

    public Artist(int quantity, int canvasWidth, int canvasHeight) {
        //todo: why don;t you init ArrayList with quantity instead of 0?
        figures = new ArrayList<Figure>(0);
        INIT_QUANTITY = quantity;
        canvas = new Canvas(canvasWidth, canvasHeight);
        Init();
    }

    public void Paint(int quantity) {

        for (int number = 0; number < quantity; number++) {
            if (figures.isEmpty()) {
                Init();
            }
            System.out.println(format("Painting figure #%1$s :", number + 1));
            canvas.Paint(figures.remove(0));
        }

    }

}
